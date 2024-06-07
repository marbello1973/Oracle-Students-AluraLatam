package med.voll.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.voll.api.domain.direccion.DatosDireccion;
import med.voll.api.domain.paciente.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/paciente")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;
    @PostMapping
    @Transactional
    @Operation(
            summary = "Registro de pacientes en base de datos",
            description = "",
            tags = {"Paciente Controller", "POST"})
    public ResponseEntity<DatosRespuestaPaciente> registrarPaciente(@RequestBody @Valid DatosRegistroPaciente datosRegistroPaciente, UriComponentsBuilder uriComponentsBuilder){
        Paciente paciente = pacienteRepository.save(new Paciente(datosRegistroPaciente));
        DatosRespuestaPaciente datosRespuestaPaciente = new DatosRespuestaPaciente(
                paciente.getId(),
                paciente.getNombre(),
                paciente.getEmail(),
                paciente.getTelefono(),
                new DatosDireccion(
                        paciente.getDireccion().getCalle(),
                        paciente.getDireccion().getDistrito(),
                        paciente.getDireccion().getCiudad(),
                        paciente.getDireccion().getNumero(),
                        paciente.getDireccion().getComplemento(),
                        paciente.getDireccion().getBarrio(),
                        paciente.getDireccion().getCodigo_postal()));
        URI url = uriComponentsBuilder.path("/paciente/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaPaciente);
    }

    @GetMapping
    @Transactional
    @Operation(
            summary = "Consulta de todos los pacientes registrados en base de datos",
            description = "",
            tags = {"Paciente Controller", "GET"})
    public ResponseEntity<Page<PacienteDTO>> listadoPacientes(@PageableDefault(size = 20)Pageable paginacion){
        return ResponseEntity.ok(pacienteRepository.findByActivoTrue(paginacion).map(PacienteDTO::new));
    }

    @PutMapping
    @Transactional
    @Operation(
            summary = "Actualizar pacientes registrados",
            description = "",
            tags = {"Paciente Controller", "PUT"})
    public ResponseEntity<DatosRespuestaPaciente> actualizarPaciente(@RequestBody @Valid ActualizarPacienteDTO actualizarPacienteDTO){
        Paciente paciente = pacienteRepository.getReferenceById(actualizarPacienteDTO.id());
        paciente.actualizarDatos(actualizarPacienteDTO);
        return ResponseEntity.ok(new DatosRespuestaPaciente(
                paciente.getId(),
                paciente.getNombre(),
                paciente.getEmail(),
                paciente.getTelefono(),
                new DatosDireccion(
                        paciente.getDireccion().getCalle(),
                        paciente.getDireccion().getDistrito(),
                        paciente.getDireccion().getCiudad(),
                        paciente.getDireccion().getNumero(),
                        paciente.getDireccion().getComplemento(),
                        paciente.getDireccion().getBarrio(),
                        paciente.getDireccion().getCodigo_postal())));
    }

    //Eliminado logico o desactivar paciente de base de datos
    @DeleteMapping("/{id}")
    @Transactional
    @Operation(
            summary = "Consultar pacientes deshabilitados",
            description = "",
            tags = {"Paciente Controller", "DELETE"})
    public ResponseEntity<Paciente> eliminarPaciente(@PathVariable Long id){
        Paciente paciente = pacienteRepository.getReferenceById(id);
        paciente.desactivarPaciente();
        return ResponseEntity.noContent().build();
    }

    //Eliminado de la base de datos del paciente
    /*@DeleteMapping("/{id}")
    public ResponseEntity<Paciente> eliminarPaciente(@PathVariable Long id){
        Paciente paciente = pacienteRepository.getReferenceById(id);
        pacienteRepository.delete(paciente);
    }*/

    @GetMapping("/{id}")
    @Transactional
    @Operation(
            summary = "Consultar pacientes deshabiltados por ID",
            description = "",
            tags = {"Paciente Controller", "GET"})
    public ResponseEntity<DatosRespuestaPaciente> retornarDatosPaciente(@PathVariable Long id){
        Paciente paciente = pacienteRepository.getReferenceById(id);
        var datosPaciente = new DatosRespuestaPaciente(
                paciente.getId(),
                paciente.getNombre(),
                paciente.getEmail(),
                paciente.getTelefono(),
                new DatosDireccion(
                        paciente.getDireccion().getCalle(),
                        paciente.getDireccion().getDistrito(),
                        paciente.getDireccion().getCiudad(),
                        paciente.getDireccion().getNumero(),
                        paciente.getDireccion().getComplemento(),
                        paciente.getDireccion().getBarrio(),
                        paciente.getDireccion().getCodigo_postal()));
        return ResponseEntity.ok(datosPaciente);
    }
}
