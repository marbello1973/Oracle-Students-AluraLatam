package med.voll.api.domain.consulta;

import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.error.ValidacionDeintegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaConsultaService {
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private ConsultaRepository consultaRepository;

    public void agendar(DatosAgendarConsulta datosAgendarConsulta){

        if(pacienteRepository.findById(datosAgendarConsulta.idPaciente()).isPresent()){
            throw new ValidacionDeintegridad("Id del paciente no encontrado");
        }

        if(datosAgendarConsulta.idMedico() != null && medicoRepository.existsById(datosAgendarConsulta.idMedico())){
            throw new ValidacionDeintegridad("Id del medico no encontrado");
        }

        var medico = seleccionarMedico(datosAgendarConsulta);

        var paciente = pacienteRepository.findById(datosAgendarConsulta.idPaciente()).get();

        var consulta = new Consulta(null, medico, paciente, datosAgendarConsulta.fecha());

        consultaRepository.save(consulta);

    }

    private Medico seleccionarMedico(DatosAgendarConsulta datosAgendarConsulta) {
        if(datosAgendarConsulta.idMedico() != null) {
            medicoRepository.getReferenceById(datosAgendarConsulta.idMedico());
        }

        if(datosAgendarConsulta.especilidad() == null){
            throw new ValidacionDeintegridad("Debe seleccionar especialidad");
        }

        return medicoRepository.seleccionarMedicoEspecilidadFecha(
                datosAgendarConsulta.especilidad(),
                datosAgendarConsulta.fecha()
        );



    }

}
