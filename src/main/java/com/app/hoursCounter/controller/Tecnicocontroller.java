package com.app.hoursCounter.controller;

import com.app.hoursCounter.dto.PostDataDto;
import com.app.hoursCounter.dto.RespondedataDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Tecnicoservicio")
public class Tecnicocontroller {
    @GetMapping("/consulta-horas")
    public ResponseEntity<List<RespondedataDto>> getHoras (@RequestParam String idTecnico, int idSemana) {
        return null;
    }

    @PostMapping("/guardar-horas")
    public ResponseEntity<List<PostDataDto>> postHoras () {
        return null;
    }
}
