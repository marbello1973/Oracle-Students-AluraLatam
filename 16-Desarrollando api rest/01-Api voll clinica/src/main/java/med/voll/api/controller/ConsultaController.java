package med.voll.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.voll.api.domain.consulta.AgendaConsultaService;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.consulta.DatosCancelamientoConsulta;
import med.voll.api.domain.consulta.DatosDetalleConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
@RequestMapping("/consulta")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {
    @Autowired
    private AgendaConsultaService agendaConsultaService;

    @PostMapping
    @Transactional
    @Operation(
            summary = "Agendar consulta ",
            description = "",
            tags = {"Consulta Controller", "POST"})
    public ResponseEntity agendar(@RequestBody @Valid DatosAgendarConsulta datos){
        var response = agendaConsultaService.agendar(datos);
        return ResponseEntity.ok(response);
    }

   /* @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DatosCancelamientoConsulta datos){
        agendaConsultaService.cancelar(datos);
        return ResponseEntity.noContent().build();
    }*/


}
