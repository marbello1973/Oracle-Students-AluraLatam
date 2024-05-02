package com.ebook.convertirdatos;

public interface IConvertirDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
