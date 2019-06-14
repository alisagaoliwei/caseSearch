package com.greatsoft.casecheck.mapper;

import com.github.pagehelper.Page;
import com.greatsoft.casecheck.entiry.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Author: lijiahe
 * @CreateDate: 2019/4/30 16:42
 */
@Mapper
public interface RoleMapper {
    /**
     * 查询所有的角色
     *
     * @return
     */
    List<Role> findRoles();

    /**
     * 分页查询角色
     *
     * @param name
     * @return
     */
    Page<Role> findRoles(@Param("name") String name);


    /**
     * 查询除所填lid外的角色
     * @param lid
     * @return
     */
    List<Role>findRolesNotByLid(@Param("lid") String lid);

    /**
     * 根据lid查找角色
     *
     * @param lid
     * @return
     */
    List<Role> findRolesByLid(@Param("lid") String lid);

    /**
     * 根据lid删除角色
     *
     * @param lid
     * @return
     */
    void deleteRolesByLid(@Param("lid") String lid);


    /**
     * 插入
     *
     * @param role
     * @return
     */
    int insert(Role role);

    /***
     * 修改
     * @param role
     * @return
     */
    int updateRolesByLid(Role role);

    /**
     * 根据角色名字查询lid
     * @param name
     * @return
     */
    List<String> findLidsByName(String name);
}
