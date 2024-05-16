package com.literalura.servicio;

public interface IConvertirDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
