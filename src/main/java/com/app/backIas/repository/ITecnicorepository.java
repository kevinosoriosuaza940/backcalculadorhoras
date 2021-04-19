package com.app.backIas.repository;

import com.app.backIas.dto.PostDataDto;

import java.util.Date;
import java.util.List;

public interface ITecnicorepository {
    List getHoras(String idTecnico, int numeroSemana) throws Exception;

    List postHoras (PostDataDto post) throws Exception;
}

