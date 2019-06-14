package com.greatsoft.casecheck.service;

import com.greatsoft.casecheck.entiry.UrlBasePath;
import com.greatsoft.casecheck.mapper.UrlBasePathMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @Description:
 * @Author: yangzhanbiao
 * @CreateDate: 2019/5/13 9:52 AM
 */
@Service
public class UrlBasePathService {
    private static final Logger logger=LoggerFactory.getLogger(UrlBasePathService.class);
    @Autowired
    private UrlBasePathMapper urlBasePathMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insertUrlBasePath(UrlBasePath urlBasePath){
        try {
            urlBasePath.setId(UUID.randomUUID().toString().toUpperCase().replace("-", ""));
            urlBasePath.setLid(UUID.randomUUID().toString().toUpperCase().replace("-", ""));
            urlBasePathMapper.insert(urlBasePath);
            return 1;
        }catch (Exception e){
            logger.error("新增异常{}",e.getMessage());
            return 0;
        }

    }

    @Transactional(rollbackFor = Exception.class)
    public int updateUrlBasePath(UrlBasePath urlBasePath){
        try {
            urlBasePathMapper.update(urlBasePath);
            return 1;
        }catch (Exception e){
            logger.error("修改异常{}",e.getMessage());
            return 0;
        }

    }

    @Transactional(rollbackFor = Exception.class)
    public int deleteByLid(String lid){
        try {
            urlBasePathMapper.deleteByLid(lid);
            return 1;
        }catch (Exception e){
            logger.error("删除异常{}",e.getMessage());
            return 0;
        }

    }

}
