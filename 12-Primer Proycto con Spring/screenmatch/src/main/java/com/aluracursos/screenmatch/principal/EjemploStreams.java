package com.aluracursos.screenmatch.principal;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class EjemploStreams {

    public void muestraEjemplo(){
        List<String> name = Arrays.asList("Brenda", "Maria", "Jose", "Karen", "Luis");

        name.stream()
                .sorted()
                .forEach(System.out::println);
    }

    public enum Planetas{
        TIERRA("Tierra"),
        MARTE("Marte"),
        JUPITER("Jupiter"),
        SATURNO("Saturno");
        private String planetaSistemaSolar;
        Planetas(String planetaSistemaSolar){
            this.planetaSistemaSolar = planetaSistemaSolar;
        }
    }

    public void planetaDeOrigen(Planetas planeta){
        switch (planeta){
            case TIERRA:
                System.out.println("Se encuentra en la ");
            default:
                System.out.println("Esta en otro lado");
                break;
        }
    }

}


/*
api chatgpt

package com.aluracursos.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obtenerTraduccion(String texto) {
        OpenAiService service = new OpenAiService("TU-API-KEY");

        CompletionRequest requisicion = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduce a español el siguiente texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var respuesta = service.createCompletion(requisicion);
        return respuesta.getChoices().get(0).getText();
    }
}

dependencias maven

<dependency>
<groupId>com.theokanning.openai-gpt3-java</groupId>
<artifactId>service</artifactId>
<version>0.14.0</version>
</dependency>

*/




