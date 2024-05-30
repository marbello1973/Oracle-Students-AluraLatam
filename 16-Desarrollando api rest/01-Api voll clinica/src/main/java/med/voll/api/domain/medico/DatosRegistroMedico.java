package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DatosDireccion;


public record DatosRegistroMedico(
        @NotBlank(message = "{nombre.obligatorio}")//mensaje personalizado desde properties
        String nombre,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefono,
        @Pattern(regexp = "\\d{4,20}")
        @NotBlank(message = "Documento no debe ir vacio")//personalizar lo errores
        String documento,
        @NotNull
        Especialidad especialidad,
        @NotNull
        @Valid
        DatosDireccion direccion

        ){}
