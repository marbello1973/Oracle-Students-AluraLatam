package med.voll.api.domain.medico;

public record MedicoDTO(
        Long id,
        String nombre,
        String especilidad,
        String documento,
        String email
){

    public MedicoDTO(Medico medico) {
        this(
            medico.getId(),
            medico.getNombre(),
            medico.getEspecialidad().toString(),
            medico.getDocumento(),
            medico.getEmail()
        );
    }
}
