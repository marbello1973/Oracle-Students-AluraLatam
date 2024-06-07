package med.voll.api.domain.consulta.desafio;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosCancelamientoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaCancelamiento")
public class ValidadorHorarioAntecedencia implements ValidadorCancelamientoDeConsulta {
    @Autowired
    private ConsultaRepository repository;

    /*@Override
    public void validar(DatosCancelamientoConsulta datos){
        var consulta = repository.getReferenceById(datos.idConsulta);
        var ahora = LocalDateTime.now();
        var diferenciaEnHoras = Duration.between(ahora, consulta.getData());
        if(diferenciaEnHoras < 24 ) {
            throw new ValidationException("Consulta solo debe ser cancelada 24 horas antes ");
        }

    }*/

}
