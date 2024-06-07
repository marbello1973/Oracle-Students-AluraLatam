package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MedicoConConsulta implements ValidadorDeConsultas{
    @Autowired
    private ConsultaRepository repository;
    public void validar(DatosAgendarConsulta datos){

        if(datos.idMedico() == null) {
            return;
        }

        var medicoConAgenda = repository.existsByMedicoIdAndData(datos.idMedico(), datos.fecha());

        if(medicoConAgenda){
            throw new ValidationException("Medico tiene consulta en este horario");
        }
    }
}
