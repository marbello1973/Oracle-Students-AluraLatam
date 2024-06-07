package med.voll.api.domain.consulta;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.validaciones.ValidadorDeConsultas;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.error.ValidacionDeintegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaConsultaService {
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    List<ValidadorDeConsultas> validadores;


    public DatosDetalleConsulta agendar(DatosAgendarConsulta datosAgendarConsulta){

        if(!pacienteRepository.findById(datosAgendarConsulta.idPaciente()).isPresent()){
            throw new ValidacionDeintegridad("Id del paciente no encontrado");
        }

        if(datosAgendarConsulta.idMedico() != null && !medicoRepository.existsById(datosAgendarConsulta.idMedico())){
            throw new ValidacionDeintegridad("Id del medico no encontrado");
        }

        validadores.forEach(v -> v.validar(datosAgendarConsulta));

        Paciente paciente = pacienteRepository.findById(datosAgendarConsulta.idPaciente()).get();

        Medico medico = seleccionarMedico(datosAgendarConsulta);

        if(medico == null){
            throw new ValidacionDeintegridad("no existen medicos disponibles para este horario y especialidad");
        }

        Consulta consulta = new Consulta(medico, paciente, datosAgendarConsulta.fecha());

        consultaRepository.save(consulta);

        return new DatosDetalleConsulta(consulta);

    }

   /* public void cancelar(DatosCancelamientoConsulta datos){
        if(!consultaRepository.existsById(datos.idConsulta())){
            throw new ValidacionDeintegridad("Id de consulta no existe...");
        }
        validadoresCancelamiento.forEach(v -> v.validar(datos));
        var consulta = consultaRepository.getReferenceById(datos.idConsulta());
        consulta.cancelar(datos.motivo());

    }*/

    private Medico seleccionarMedico(DatosAgendarConsulta datos) {
        if(datos.idMedico() != null){
            return medicoRepository.getReferenceById(datos.idMedico());
        }
        if(datos.especialidad() == null){
            throw new ValidacionDeintegridad("Debe seleccionar una especialidad para el medico");
        }

        return medicoRepository.seleccionarMedicoEspecilidadFecha(datos.especialidad(), datos.fecha());
    }

}
