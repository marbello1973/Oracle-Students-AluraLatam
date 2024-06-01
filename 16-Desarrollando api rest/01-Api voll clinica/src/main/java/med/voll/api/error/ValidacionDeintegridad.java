package med.voll.api.error;

public class ValidacionDeintegridad extends RuntimeException {
    public ValidacionDeintegridad(String validarIdPaciente) {
        super(validarIdPaciente);

    }
}
