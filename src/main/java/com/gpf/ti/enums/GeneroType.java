package com.gpf.ti.enums;

public enum GeneroType {
    MASCULINO("M"),
    FEMININO("F");

    private String genero;

    GeneroType(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return this.genero;
    }
}
