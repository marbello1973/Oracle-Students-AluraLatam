package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ConsultasPacientes implements ValidadorDeConsultas {
    @Autowired
    private ConsultaRepository repository;
    public void  validar(DatosAgendarConsulta datos){
        var primerHorario = datos.fecha().withHour(7);
        var ultimoHorario = datos.fecha().withHour(18);
        var pacienteConsulta = repository.existsByPacienteIdAndDataBetween(datos.idPaciente(), primerHorario, ultimoHorario);

    }
}
