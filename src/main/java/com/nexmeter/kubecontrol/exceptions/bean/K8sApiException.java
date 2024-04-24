package com.nexmeter.kubecontrol.exceptions.bean;

import java.io.Serial;

/**
 * @author Tony
 * 2024/4/19
 */
public class K8sApiException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -4040025000789533326L;

    public K8sApiException() {
        super();
    }

    public K8sApiException(Throwable cause) {
        super(cause);
    }

    public K8sApiException(String message) {
        super(message);
    }

    public K8sApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
