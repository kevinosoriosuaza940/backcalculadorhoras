package com.app.backIas.repository;

import com.app.backIas.dto.PostDataDto;
import com.app.backIas.dto.RequestDataDTO;

import java.util.List;

public interface ITecnicorepository {
    List getHoras(String idTecnico, int numeroSemana) throws Exception;

    List postHoras (PostDataDto post) throws Exception;

    List totalHorasSemana(String idTecnico, int numeroSemana) throws Exception;
}

