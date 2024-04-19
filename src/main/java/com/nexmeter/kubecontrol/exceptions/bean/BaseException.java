package com.nexmeter.kubecontrol.exceptions.bean;

import java.io.Serial;

/**
 * @author Tony
 * 2024/4/19
 */
public class BaseException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -4040025000789533326L;

    public BaseException() {
        super();
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
