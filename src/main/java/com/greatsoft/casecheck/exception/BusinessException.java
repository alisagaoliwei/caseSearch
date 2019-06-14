package com.greatsoft.casecheck.exception;

/**
 * @Description:
 * @Author: lijiahe
 * @CreateDate: 2019/4/30 15:28
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 3861731401599863388L;

    public BusinessException(String msg) {
        super(msg);
    }
}
