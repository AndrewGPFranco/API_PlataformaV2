package com.gpf.ti.exception;

public class AulaNotFoundException extends RuntimeException {

    public AulaNotFoundException(Long id) {
        super("Aula com o id " + id + " não foi encontrada em nosso sistema!");
    }
}
