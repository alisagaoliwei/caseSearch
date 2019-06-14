package com.greatsoft.casecheck.service;

import com.greatsoft.casecheck.dto.home.HomeResponseDTO;
import com.greatsoft.casecheck.entiry.Account;
import com.greatsoft.casecheck.entiry.ResourceInfo;
import com.greatsoft.casecheck.entiry.RoleResourceInfo;
import com.greatsoft.casecheck.mapper.ResourceInfoMapper;
import com.greatsoft.casecheck.mapper.RoleResourceInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Description:
 * @Author: yangzhanbiao
 * @CreateDate: 2019/5/6 10:55 AM
 */
@Service
public class ResourceInfoService {
    private static final Logger logger = LoggerFactory.getLogger(ResourceInfoService.class);
    @Autowired
    private ResourceInfoMapper resourceInfoMapper;
    @Autowired
    private RoleResourceInfoMapper roleResourceInfoMapper;


    @Transactional(rollbackFor = Exception.class)
    public int insertResource(ResourceInfo resource, Account account) {
        String serialNo = "0";
        List<String> serialNos = null;

        try {
            serialNos = resourceInfoMapper.findNoByLeve(resource.getLeve(), resource.getPid());
        } catch (Exception e) {
            logger.error("获得当前最后一条的序号查询异常{}", e.getMessage());
            return 0;
        }

        //获得当前最后一条的序号
        if (serialNos != null && !serialNos.isEmpty()) {
            serialNo = serialNos.get(serialNos.size() - 1);
        }

        resource.setSerialNo(String.valueOf(Integer.valueOf(serialNo) + 1));
        resource.setId(UUID.randomUUID().toString().toUpperCase().replace("-", ""));
        resource.setLid(UUID.randomUUID().toString().toUpperCase().replace("-", ""));

        try {
            resourceInfoMapper.insert(resource);
        } catch (Exception e) {
            logger.error("新增异常{}", e.getMessage());
            return 0;
        }

        RoleResourceInfo roleResourceInfo = new RoleResourceInfo();
        roleResourceInfo.setRoleLid(account.getRoleLid());
        roleResourceInfo.setResourceLid(resource.getLid());
        roleResourceInfo.setId(UUID.randomUUID().toString().toUpperCase().replace("-", ""));

        try {
            roleResourceInfoMapper.insertSelective(roleResourceInfo);
        } catch (Exception e) {
            logger.error("新增异常{}", e.getMessage());
            return 0;
        }
        return 1;
    }

    @Transactional(rollbackFor = Exception.class)
    public int updateResourceInfo(ResourceInfo resources) {
        try {
            resourceInfoMapper.update(resources);
        } catch (Exception e) {
            logger.error("修改失败{}", e.getMessage());
            return 0;
        }

        return 1;
    }

    @Transactional(rollbackFor = Exception.class)
    public int delete(String lId) {
        try {
            resourceInfoMapper.deleteByLid(lId);
        } catch (Exception e) {
            logger.error("删除失败{}", e.getMessage());
            return 0;
        }

        try {
            roleResourceInfoMapper.deleteByResourceLId(lId);
        } catch (Exception e) {
            logger.error("删除失败{}", e.getMessage());
            return 0;
        }

        return 1;
    }

    @Transactional(rollbackFor = Exception.class)
    public int moveResource(String sourceId, String targetId, String sourceNo, String targetNo, Account account) {
        ResourceInfo resourceInfo = new ResourceInfo();
        resourceInfo.setSerialNo(targetNo);
        resourceInfo.setId(sourceId);
        resourceInfo.setModified(new Date());
        resourceInfo.setModifierId(account.getLid());
        resourceInfo.setModifier(account.getAccount());

        try {
            resourceInfoMapper.update(resourceInfo);
        } catch (Exception e) {
            logger.error("修改异常{}", e.getMessage());
            return 0;
        }

        resourceInfo.setSerialNo(sourceNo);
        resourceInfo.setId(targetId);
        resourceInfo.setModified(new Date());

        try {
            resourceInfoMapper.update(resourceInfo);
        } catch (Exception e) {
            logger.error("修改异常{}", e.getMessage());
            return 0;
        }

        return 1;
    }

    /***
     * 查询菜单的树型结构
     * @param resources
     * @return
     */
    public List<HomeResponseDTO> getMenuTrees(List<ResourceInfo> resources, List<String> resourceLids) {

        if (resourceLids != null && !resourceLids.isEmpty()) {
            for (ResourceInfo resource : resources) {
                if (resourceLids.contains(resource.getLid())) {
                    resource.setIsChoose(1);
                } else {
                    resource.setIsChoose(0);
                }
            }
        }

        List<HomeResponseDTO> parentList = new ArrayList<>();
        for (ResourceInfo resource : resources) {
            if (StringUtils.isBlank(resource.getPid())) {
                HomeResponseDTO home = new HomeResponseDTO(resource);
                home.setChildrenList(getChildren(resource.getId(), resources));
                parentList.add(home);
            }
        }
        return parentList;
    }

    /***
     * 查询子菜单
     * @param id
     * @param resourcesList
     * @return
     */
    public List<HomeResponseDTO> getChildren(String id, List<ResourceInfo> resourcesList) {
        List<ResourceInfo> list = null;
        if (StringUtils.isNotBlank(id)) {
            list = new ArrayList<>();
            for (ResourceInfo resources : resourcesList) {
                if (id.equals(resources.getPid())) {
                    list.add(resources);
                }
            }
        }

        List<HomeResponseDTO> children = new ArrayList<>();
        if (list != null) {
            for (ResourceInfo resource : list) {
                HomeResponseDTO home = new HomeResponseDTO(resource);
                home.setChildrenList(getChildren(resource.getId(), resourcesList));
                children.add(home);
            }
        }
        return children;
    }

}
