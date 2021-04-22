package com.app.backIas.services;

import com.app.backIas.business.Contadorhoras;
import com.app.backIas.dto.PostDataDto;
import com.app.backIas.repository.ITecnicorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class TecnicoserviceIMPL implements ITecnicoService{

    @Autowired
    private ITecnicorepository tecnicoRepository;

    @Override
    public List getHoras (String idTecnico, int numeroSemana) throws Exception {
        return tecnicoRepository.getHoras(idTecnico, numeroSemana);
    }

    @Override
    public List postHoras (Date fecha_inicio, Date fecha_fin, String id_tecnico, String id_servicio) throws Exception {

        PostDataDto post = new PostDataDto();

        post.setId_tecnico(id_tecnico);
        post.setId_servicio(id_servicio);
        post.setHora_inicio(fecha_inicio);
        post.setHora_fin(fecha_fin);
        post.setNumero_semana(Contadorhoras.calculatesemanaaño(fecha_inicio));
        post.setNumero_dia(Contadorhoras.calculatesemanaaño(fecha_inicio));
        post.setHoras_normales(Contadorhoras.calcularhorascomunes(fecha_fin,fecha_fin));
        post.setHoras_normales_extras(0);
        post.setHoras_nocturnas(Contadorhoras.calculadorhorasnocturnas(fecha_inicio,fecha_fin));
        post.setHoras_dominicales(Contadorhoras.calcularhorasdominicales(fecha_inicio,fecha_fin));
        post.setHoras_nocturnas_extras(0);
        post.setHoras_dominicales_extras(0);
        post.setTotal_horas(0);
        post.setId_semana(0);

        return tecnicoRepository.postHoras(post);
    }
}
