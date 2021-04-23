package com.app.backIas.controller;

import com.app.backIas.business.Contadorhoras;
import com.app.backIas.dto.RequestDataDTO;
import com.app.backIas.dto.ResponseDataDTO;
import com.app.backIas.services.ITecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public ResponseEntity postHoras (@RequestBody RequestDataDTO requestPostDTO) throws Exception {
        ControlDate dcd = new ControlDate();
        Date horafechainicio =  dcd.formatDate(requestPostDTO.getHora_inicio());
        Date horafechafin =  dcd.formatDate(requestPostDTO.getHora_fin());
        List totalHoras = tecnicoServicio.totalHorasSemana(requestPostDTO.getId_tecnico(), Contadorhoras.calculatesemanaaño(horafechainicio));

        int horas = Integer.parseInt(totalHoras.get(0).toString());
        System.out.println(totalHoras);

        var response = tecnicoServicio.postHoras(horafechainicio, horafechafin, requestPostDTO.getId_tecnico(), requestPostDTO.getId_servicio(),horas);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    }




