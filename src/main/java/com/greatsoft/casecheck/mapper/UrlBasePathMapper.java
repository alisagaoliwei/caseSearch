package com.greatsoft.casecheck.mapper;

import com.github.pagehelper.Page;
import com.greatsoft.casecheck.entiry.UrlBasePath;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Author: yangzhanbiao
 * @CreateDate: 2019/5/13 9:52 AM
 */
@Mapper
public interface UrlBasePathMapper {
    /**
     * 查询所有
     * @return
     */
    List<UrlBasePath> findUrlBasePaths();

    /**
     * 根据名称查询业务主键
     * @param name
     * @return
     */
    List<String> findLidsByName(@Param("name") String name);

    /**
     * 分页查询
     * @param name
     * @return
     */
    Page<UrlBasePath> findUrlBasePaths(@Param("name") String name);

    /**
     * 根据业务主键查询
     * @param lid
     * @return
     */
    UrlBasePath findUrlBasePathByLid(String lid);

    /**
     * 插入
     * @param urlBasePath
     * @return
     */
    int insert(UrlBasePath urlBasePath);

    /**
     * 修改
     * @param urlBasePath
     * @return
     */
    int update(UrlBasePath urlBasePath);

    /**
     * 删除
     * @param lid
     * @return
     */
    int deleteByLid(String lid);
}
