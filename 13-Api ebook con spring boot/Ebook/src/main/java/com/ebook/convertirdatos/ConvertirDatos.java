package com.ebook.convertirdatos;

import com.ebook.modelo.DatosLibros;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertirDatos implements IConvertirDatos{
    private ObjectMapper objectMapper =  new ObjectMapper();
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try{
            return objectMapper.readValue(json, clase);
        }catch(JsonProcessingException ex){
            throw new RuntimeException(ex);
        }
    }
}

