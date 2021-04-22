package com.app.backIas.repository;

import com.app.backIas.dto.PostDataDto;
import com.app.backIas.dto.ResponseDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TecnicorepositoryIMPL implements ITecnicorepository {

    /*
            "insert into Servicio(id_tipo_servicio, id_servicio) values\n" +
                    "(1,:id_servicio);\n" +
                    "insert into Semana (numero_semana) values \n" +
                    "(:numero_semana);\n" +
                    "insert into Dia (numero_dia) values\n" +
                    "(:numero_dia);\n" +
                    "insert into Horas  \n" +
                    "(hora_inicio , hora_fin , horas_normales, horas_normales_extras, horas_nocturnas, horas_nocturnas_extras,horas_dominicales, horas_dominicales_extras,total_horas)values\n" +
                    "(\n" +
                    ":hora_inicio,\n" +
                    ":hora_fin,\n" +
                    ":horas_normales,\n" +
                    ":horas_normales_extras,\n" +
                    ":horas_nocturnas,\n" +
                    ":horas_nocturnas_extras,\n" +
                    ":horas_dominicales,\n" +
                    ":horas_dominicales_extras,\n" +
                    ":total_horas);"
*/
    @Autowired
    private EntityManager em;

    @Override
    public List getHoras (String idTecnico, int numeroSemana) throws Exception {
        try {
            String queryHoras =
                    "select ST.id_tecnico, S.numero_semana, SUM(H.horas_normales_extras) as horas_normales_extras, \n" +
                    "SUM(H.horas_normales) as horas_normales,\n" +
                    "SUM(H.horas_dominicales) as horas_dominicales, SUM(H.horas_nocturnas_extras) as horas_nocturnas_extras, \n" +
                    "SUM(H.horas_nocturnas) as horas_nocturnas,SUM(H.horas_dominicales_extras) as horas_dominicales_extras,\n" +
                    "SUM(H.total_horas) as total_horas\n" +
                    "from \n" +
                    "Horas H \n" +
                    "inner join Dia D on H.id_horas = D.id_dia\n" +
                    "inner join Semana S on D.id_dia = S.id_semana\n" +
                    "inner join ServicioTecnico ST on ST.id_semana = ST.id_semana\n" +
                    "where id_tecnico = :id_tecnico and numero_semana = :numero_semana";
            Query query = em.createNativeQuery(queryHoras, ResponseDataDTO.class);
            query.setParameter("id_tecnico", idTecnico);
            query.setParameter("numero_semana", numeroSemana);

            return query.getResultList();
        } catch (Exception e) {
            throw new Exception("Error en el metodo getHoras repository: " + e);
        }
    }

    public List postHoras (PostDataDto post) throws Exception {
        try {
            String queryInsert =
                    "begin;\n" +
                    "insert into Servicio(id_tipo_servicio, id_servicio) values\n" +
                    "((select MAX(id_tipo_servicio) from TipoServicio) + 1,\n" +
                    ":id_servicio);\n" +
                    "insert into Semana (numero_semana) values \n" +
                    "(:numero_semana);\n" +
                    "insert into Dia (numero_dia) values\n" +
                    "(:numero_dia);\n" +
                    "insert into Horas  \n" +
                    "(hora_inicio , hora_fin , horas_normales, horas_normales_extras, horas_nocturnas, horas_nocturnas_extras,\n" +
                    "horas_dominicales, horas_dominicales_extras,total_horas)values\n" +
                    "(\n" +
                    ":hora_inicio,\n" +
                    ":hora_fin,\n" +
                    ":horas_normales,\n" +
                    ":horas_normales_extras,\n" +
                    ":horas_nocturnas,\n" +
                    ":horas_nocturnas_extras,\n" +
                    ":horas_dominicales,\n" +
                    ":horas_dominicales_extras,\n" +
                    ":total_horas);\n" +
                    "INSERT INTO ServicioTecnico (id_tecnico, id_servicio, id_semana) \n" +
                    "VALUES\n" +
                    "(\n" +
                    ":id_tecnico,\n" +
                    "(SELECT id_servicio FROM Servicio ORDER by id_servicio ASC LIMIT 1),\n" +
                    "(SELECT MAX(id_semana)  FROM Semana)\n" +
                    ");\n" +
                    "COMMIT;";
            Query query = em.createNativeQuery(queryInsert);
            query.setParameter("id_tecnico", post.getId_tecnico());
            query.setParameter("id_servicio", post.getId_servicio());
            query.setParameter("hora_inicio", post.getHora_inicio());
            query.setParameter("hora_fin", post.getHora_fin());
            query.setParameter("numero_semana", post.getNumero_semana());
            query.setParameter("numero_dia", post.getNumero_dia());
            query.setParameter("horas_normales", post.getHoras_normales());
            query.setParameter("horas_normales_extras", post.getHoras_normales_extras());
            query.setParameter("horas_nocturnas", post.getHoras_nocturnas());
            query.setParameter("horas_dominicales", post.getHoras_dominicales());
            query.setParameter("horas_nocturnas_extras", post.getHoras_nocturnas_extras());
            query.setParameter("horas_dominicales_extras", post.getHoras_dominicales_extras());
            query.setParameter("total_horas", post.getTotal_horas());

            return getHoras(post.getId_tecnico(), post.getNumero_semana());
        } catch (Exception e) {
            throw new Exception("Error en el metodo getHoras repository: " + e);
        }
    }
}
