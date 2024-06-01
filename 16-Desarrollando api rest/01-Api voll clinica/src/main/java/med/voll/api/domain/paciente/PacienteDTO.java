package med.voll.api.domain.paciente;

public record PacienteDTO(
        Long id,
        String nombre,
        String email,
        String telefono
){
    public PacienteDTO(Paciente paciente){
        this(
                paciente.getId(),
                paciente.getNombre(),
                paciente.getEmail(),
                paciente.getTelefono()
        );
    }
}
