package com.greatsoft.casecheck.mapper;

import com.greatsoft.casecheck.entiry.RoleResourceInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description:
 * @Author: lijiahe
 * @CreateDate: 2019/4/30 16:41
 */
@Mapper
public interface RoleResourceInfoMapper {
    /**
     * 根据roleLid查询ResourceLid集合
     *
     * @param roleLid
     * @return
     */
    List<String> findResourceLidByRoleLid(String roleLid);

    /**
     * 根据菜单的业务id删除
     *
     * @param resourceLid
     */
    void deleteByResourceLId(String resourceLid);

    /**
     * 根据角色的业务id删除
     *
     * @param roleLid
     * @return
     */
    void deleteByRoleLid(String roleLid);

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    void insertList(List<RoleResourceInfo> list);

    /**
     * 插入
     *
     * @param roleResourceInfo
     * @return
     */
    int insertSelective(RoleResourceInfo roleResourceInfo);
}
