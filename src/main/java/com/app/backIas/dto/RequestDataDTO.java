package com.app.backIas.dto;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Immutable
public class RequestDataDTO implements Serializable{


    private static final long serialVersionUID = -4450642822094155216L;

    @Id
    @Column(name = "id_tecnico")
    private String id_tecnico;

    @Column(name = "numero_semana")
    private int numero_semana;

    @Column(name = "hora_inicio")
    private String hora_inicio;

    @Column(name = "hora_fin")
    private String hora_fin;

    @Column(name="id_servicio")
    private String id_servicio;

    public String getId_tecnico () {
        return id_tecnico;
    }

    public void setId_tecnico (String id_tecnico) {
        this.id_tecnico = id_tecnico;
    }

    public int getNumero_semana () {
        return numero_semana;
    }

    public void setNumero_semana (int numero_semana) {
        this.numero_semana = numero_semana;
    }

    public String getHora_inicio () {
        return hora_inicio;
    }

    public void setHora_inicio (String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fin () {
        return hora_fin;
    }

    public void setHora_fin (String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getId_servicio () {
        return id_servicio;
    }

    public void setId_servicio (String id_servicio) {
        this.id_servicio = id_servicio;
    }
}
