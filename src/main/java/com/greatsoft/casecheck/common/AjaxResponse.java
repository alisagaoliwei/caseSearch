package com.greatsoft.casecheck.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:ajax 请求统一返回
 * @Author: lijiahe
 * @CreateDate: 2019/4/6 17:39
 */
public class AjaxResponse implements Serializable {
    private static final long serialVersionUID = 2182922145146159369L;
    /**
     * 是否成功（0成功，1失败）
     */
    private int status;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 其他参数
     */
    private Map<String, Object> objMap;

    /**
     * 构造方法
     */
    public AjaxResponse() {
    }

    public AjaxResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public AjaxResponse(int status, String message, Map<String, Object> objMap) {
        this.status = status;
        this.message = message;
        this.objMap = objMap;
    }

    public AjaxResponse(int status, String message, Object object) {
        Map<String, Object> objMap = new HashMap<>();
        objMap.put("objects", object);
        this.status = status;
        this.message = message;
        this.objMap = objMap;
    }

    public AjaxResponse(int status, String message, int pageNo) {
        Map<String, Object> objMap = new HashMap<>();
        objMap.put("objects", null);
        objMap.put("pages", 1);
        objMap.put("total", 0);
        objMap.put("pageNo", pageNo);
        this.status = status;
        this.message = message;
        this.objMap = objMap;
    }

    public AjaxResponse(int status, String message, int pageNo, long pages, long total, Object object) {
        Map<String, Object> objMap = new HashMap<>();
        objMap.put("objects", object);
        objMap.put("pages", pages);
        objMap.put("total", total);
        objMap.put("pageNo", pageNo);
        this.status = status;
        this.message = message;
        this.objMap = objMap;
    }

    public static AjaxResponse success() {
        return new AjaxResponse(0, "操作成功");
    }

    public static AjaxResponse success(String message, Object object) {
        return new AjaxResponse(0, message, object);
    }

    public static AjaxResponse success(String message, int pageNo) {
        return new AjaxResponse(0, message, pageNo);
    }

    public static AjaxResponse success(String message, int pageNo, long pages, long total, Object object) {
        return new AjaxResponse(0, message, pageNo, pages, total, object);
    }

    public static AjaxResponse success(Map<String, Object> objMap) {
        return new AjaxResponse(0, "操作成功", objMap);
    }

    public static AjaxResponse failed(String message){
        return new AjaxResponse(1, message);
    }

    public static AjaxResponse failed(String message, Map<String, Object> objMap){
        return new AjaxResponse(1, message, objMap);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getObjMap() {
        return objMap;
    }

    public void setObjMap(Map<String, Object> objMap) {
        this.objMap = objMap;
    }
}
