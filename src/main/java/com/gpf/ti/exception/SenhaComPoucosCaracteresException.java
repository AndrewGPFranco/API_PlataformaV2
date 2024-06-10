package com.gpf.ti.exception;

public class SenhaComPoucosCaracteresException extends RuntimeException{

    public SenhaComPoucosCaracteresException() {
        super("A senha informada precisa ter mais de 4 caracteres!");
    }
}
