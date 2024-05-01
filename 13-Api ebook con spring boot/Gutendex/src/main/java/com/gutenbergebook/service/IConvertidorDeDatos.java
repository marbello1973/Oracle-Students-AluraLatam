package com.gutenbergebook.service;

public interface IConvertidorDeDatos {
    <T> T obtenerDatosApi(String json, Class<T> clase);
}
