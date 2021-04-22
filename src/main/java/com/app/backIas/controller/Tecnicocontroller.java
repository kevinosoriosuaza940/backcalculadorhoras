package com.app.backIas.controller;

import com.app.backIas.dto.ResponseDataDTO;
import com.app.backIas.services.ITecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/tecnicoservicio")

public class Tecnicocontroller {
    @Autowired
    private ITecnicoService tecnicoServicio;

    @GetMapping("/consulta-horas")
    public ResponseEntity getHoras (@RequestParam String idTecnico, @RequestParam int numeroSemana) throws Exception {
        try {
            var response = tecnicoServicio.getHoras(idTecnico, numeroSemana);

            if (response == null || response.isEmpty() || response.get(0) == null) {
                return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<ResponseDataDTO>());
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (Exception e) {
            throw new Exception("Error en getHoras controller: " + e);
        }
    }


    @PostMapping("/guardar-horas")
    public ResponseEntity postHoras (@RequestParam Date fechainicio, @RequestParam Date fechafin,
                                     @RequestParam String id_tecnico, @RequestParam String id_servicio) throws Exception {
        var response = tecnicoServicio.postHoras(fechainicio, fechafin, id_tecnico, id_servicio);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
