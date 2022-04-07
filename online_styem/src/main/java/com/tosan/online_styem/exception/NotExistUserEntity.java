package com.tosan.online_styem.exception;

public class NotExistUserEntity extends RuntimeException {
    public NotExistUserEntity(String message) {
        super(message);
    }
}
