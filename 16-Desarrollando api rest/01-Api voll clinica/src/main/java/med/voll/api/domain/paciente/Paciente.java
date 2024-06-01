package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.direccion.Direccion;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    private Boolean activo;
    @Embedded
    private Direccion direccion;

    public Paciente(DatosRegistroPaciente datosRegistroPaciente) {
        this.activo = true;
        this.nombre = datosRegistroPaciente.nombre();
        this.email = datosRegistroPaciente.email();
        this.telefono = datosRegistroPaciente.telefono();
        this.documento = datosRegistroPaciente.documento();
        this.direccion = new Direccion(datosRegistroPaciente.direccion());
    }

    public void actualizarDatos(ActualizarPacienteDTO actualizarPacienteDTO){
        if(actualizarPacienteDTO.nombre() != null) this.nombre = actualizarPacienteDTO.nombre();
        if(actualizarPacienteDTO.documento() != null) this.documento = actualizarPacienteDTO.documento();
        if(actualizarPacienteDTO.direccion() != null){
            this.direccion = direccion.actualizarDatos(actualizarPacienteDTO.direccion());
        }
    }

    public void desactivarPaciente(){
        this.activo = false;
    }
}
