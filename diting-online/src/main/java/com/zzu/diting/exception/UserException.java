package com.zzu.diting.exception;

/**
 * @author Miles
 * @Title: UserException
 * @ProjectName zzu-diting-jiayu
 * @Date 2019/4/14--14:32
 */
public class UserException extends RuntimeException {
    private String message;

    public UserException(String message) {
        super(message);
    }
}
