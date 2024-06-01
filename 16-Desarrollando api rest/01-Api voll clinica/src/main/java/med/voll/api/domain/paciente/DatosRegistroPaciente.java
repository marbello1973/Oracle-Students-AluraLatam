package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DatosDireccion;

public record DatosRegistroPaciente(
        @NotBlank(message = "{nombre.obligatorio}")
        String nombre,
        @NotBlank
        @Email
        String email,
        @Pattern(regexp = "\\d{6,20}")
        @NotBlank
        String telefono,
        @Pattern(regexp = "\\d{4,20}")
        @NotBlank(message = "Documento no debe ir vacio")//personalizar lo errores
        String documento,
        @NotNull
        @Valid
        DatosDireccion direccion
){}


