package med.voll.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.voll.api.domain.direccion.DatosDireccion;
import med.voll.api.domain.medico.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/medico")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;
    @PostMapping
    @Transactional
    @Operation(
            summary = "Registra un medico en la base de datos",
            description = "",
            tags = {"Medico Controller", "POST"})
    public ResponseEntity<DatosRespuestaMedico> registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico, UriComponentsBuilder uriComponentsBuilder){
        Medico medico = medicoRepository.save(new Medico(datosRegistroMedico));
        //Return 201 Created medico
        //Url donde encontrar al medico que se guardo
        //Ejemplo GET http://localhost:8080/medico/xx
        DatosRespuestaMedico datosRespuestaMedico = new DatosRespuestaMedico(
                medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getTelefono(),
                medico.getEspecialidad().toString(),
                new DatosDireccion(
                        medico.getDireccion().getCalle(),
                        medico.getDireccion().getDistrito(),
                        medico.getDireccion().getCiudad(),
                        medico.getDireccion().getNumero(),
                        medico.getDireccion().getComplemento(),
                        medico.getDireccion().getBarrio(),
                        medico.getDireccion().getCodigo_postal()));

        URI url = uriComponentsBuilder.path("/medico/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaMedico);
    }

    //page para ordenar los elementos por pagina

    @GetMapping
    @Transactional
    @Operation(
            summary = "Consulta los medicos en la base de datos",
            description = "",
            tags = {"Medico Controller", "GET"})
    public ResponseEntity<Page<MedicoDTO>> listadoMedicos (
            @PageableDefault(size = 20) Pageable paginacion
    ){
        //return medicoRepository.findAll(paginacion).map(MedicoDTO::new);
        return ResponseEntity.ok(medicoRepository.findByActivoTrue(paginacion).map(MedicoDTO::new));
    }

    @PutMapping
    @Transactional
    @Operation(
            summary = "Actualizacion datos del medico",
            description = "",
            tags = {"Medico Controller", "PUT"})
    public ResponseEntity<DatosRespuestaMedico> actualizarMedico(
            @RequestBody @Valid ActualizarMedicoDTO actualizarMedicoDTO
    ){
        Medico medico = medicoRepository.getReferenceById(actualizarMedicoDTO.id());
        medico.actualizarDatos(actualizarMedicoDTO);
        return ResponseEntity.ok(new DatosRespuestaMedico(
                medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getTelefono(),
                medico.getEspecialidad().toString(),
                new DatosDireccion(
                        medico.getDireccion().getCalle(),
                        medico.getDireccion().getDistrito(),
                        medico.getDireccion().getCiudad(),
                        medico.getDireccion().getNumero(),
                        medico.getDireccion().getComplemento(),
                        medico.getDireccion().getBarrio(),
                        medico.getDireccion().getCodigo_postal())));
    }

    //Eliminado logico
    @DeleteMapping("/{id}")
    @Transactional
    @Operation(
            summary = "Consulta medicos desactivados en base de datos",
            description = "",
            tags = {"Medico Controller", "DELETE"})
    public ResponseEntity<Medico> eliminarMedico(@PathVariable Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    @Operation(
            summary = "Consulta de medicos deshabilitados por ID",
            description = "",
            tags = {"Medico Controller", "GET"})
    public ResponseEntity<DatosRespuestaMedico> retornaDatosMedico(@PathVariable Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        var datosMedico = new DatosRespuestaMedico(
                medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getTelefono(),
                medico.getEspecialidad().toString(),
                new DatosDireccion(
                        medico.getDireccion().getCalle(),
                        medico.getDireccion().getDistrito(),
                        medico.getDireccion().getCiudad(),
                        medico.getDireccion().getNumero(),
                        medico.getDireccion().getComplemento(),
                        medico.getDireccion().getBarrio(),
                        medico.getDireccion().getCodigo_postal()));
        return ResponseEntity.ok(datosMedico);
    }


    /*
    //Eliminado de base de datos
    public void eliminarMedico(@PathVariable Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        medicoRepository.delete(medico);
    }*/


}
