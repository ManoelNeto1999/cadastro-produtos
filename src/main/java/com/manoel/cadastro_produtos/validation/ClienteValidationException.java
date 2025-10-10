package com.manoel.cadastro_produtos.validation;

public class ClienteValidationException extends RuntimeException{
    private final String field;

    public ClienteValidationException(String message) {
        super(message);
        this.field = null;
    }

    public ClienteValidationException(String field, String message) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
