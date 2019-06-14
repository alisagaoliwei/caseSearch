package com.greatsoft.casecheck.mapper;

import com.greatsoft.casecheck.entiry.ResourceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Author: lijiahe
 * @CreateDate: 2019/4/30 16:41
 */
@Mapper
public interface ResourceInfoMapper {
    /**
     * 新增
     *
     * @param resourceInfo
     * @return
     */
    int insert(ResourceInfo resourceInfo);

    /**
     * 修改
     *
     * @param resources
     * @return
     */
    int update(ResourceInfo resources);

    /**
     * 根据角色业务id查询菜单
     *
     * @param roleLid
     * @return
     */
    List<ResourceInfo> findResourcesByRoleLid(String roleLid);

    /**
     * 查询所有状态正常(status为0)的菜单
     *
     * @return
     */
    List<ResourceInfo> findResources();

    /**
     * 根据父id和菜单名称查询
     *
     * @param pid
     * @param name
     * @return
     */
    List<ResourceInfo> findResourcesByPidAndName(@Param("pid") String pid, @Param("name") String name);

    /**
     * 根据父id和菜单序号查询
     *
     * @param pid
     * @param serialNo
     * @return
     */
    List<ResourceInfo> findResourcesByPidAndNo(@Param("pid") String pid, @Param("serialNo") String serialNo);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    ResourceInfo findResourceById(String id);

    /**
     * 根据菜单序号和菜单父id查询
     *
     * @param serialNo
     * @param pid
     * @return
     */
    ResourceInfo findResourceByNoAndPid(@Param("serialNo") String serialNo, @Param("pid") String pid);

    /***
     * 根据角色业务id和菜单父id查询
     * @param roleLid
     * @param pid
     * @return
     */
    List<ResourceInfo> findResourcesByRoleLidAndPid(@Param("roleLid") String roleLid, @Param("pid") String pid);

    /**
     * 根据业务id删除
     *
     * @param lid
     */
    void deleteByLid(String lid);


    /**
     * 根据父id查询
     *
     * @param pid
     * @return
     */
    List<ResourceInfo> findResourcesByPid(String pid);


    /**
     * 根据父id和名字查询id
     *
     * @param pid
     * @param name
     * @return
     */
    List<String> findIdsByPidAndName(@Param("pid") String pid, @Param("name") String name);

    /**
     * 根据级别查询No
     *
     * @param leve
     * @return
     */
    List<String> findNoByLeve(@Param("leve") int leve, @Param("pid") String pid);

    /**
     * 根据基准业务主键id统计菜单条数
     * @param urlLid
     * @return
     */
    int countByUrlLid(String urlLid);
}
