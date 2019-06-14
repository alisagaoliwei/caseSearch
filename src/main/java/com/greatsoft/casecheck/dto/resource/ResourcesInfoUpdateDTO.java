package com.greatsoft.casecheck.dto.resource;

/**
 * @Description:菜单移动接参实体类
 * @Author: yangzhanbiao
 * @CreateDate: 2019/5/6 3:02 PM
 */
public class ResourcesInfoUpdateDTO {
    /*
     * 要移动菜单的id
     */
    String sourceId;
    /*
     * 要移动菜单的目标位置编号
     */
    String targetNo;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getTargetNo() {
        return targetNo;
    }

    public void setTargetNo(String targetNo) {
        this.targetNo = targetNo;
    }

    @Override
    public String toString() {
        return "ResourcesInfoUpdateDTO{" +
                "sourceId='" + sourceId + '\'' +
                ", targetNo='" + targetNo + '\'' +
                '}';
    }
}
