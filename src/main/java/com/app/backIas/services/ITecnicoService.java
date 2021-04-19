package com.app.backIas.services;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface ITecnicoService {
    List getHoras(String idTecnico, int numeroSemana) throws Exception;

    List postHoras(Date fecha_inicio, Date fecha_fin, String id_tecnico, String id_servicio) throws Exception;
}
