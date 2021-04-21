package com.app.backIas.dto;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Immutable
public class ResponseDataDTO implements Serializable {

    private static final long serialVersionUID = -1499220808977659891L;

    @Id
    @Column(name = "id_tecnico")
    private String id_tecnico;

    @Column(name = "numero_semana")
    private int numero_semana;

    @Column(name = "horas_normales")
    private  int horas_normales;

    @Column(name = "horas_nocturnas")
    private int horas_nocturnas;

    @Column(name = "horas_normales_extras")
    private int horas_normale_sextras;

    @Column(name = "horas_dominicales")
    private int horas_dominicales;

    @Column(name = "horas_nocturnas_extras")
    private int horas_nocturnas_extras;

    @Column(name = "horas_dominicales_extras")
    private int horas_dominicales_extras;

    @Column(name = "total_horas")
    private int total_horas;

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

    public int getHoras_normale_sextras () {
        return horas_normale_sextras;
    }

    public void setHoras_normale_sextras (int horas_normale_sextras) {
        this.horas_normale_sextras = horas_normale_sextras;
    }

    public int getHoras_dominicales () {
        return horas_dominicales;
    }

    public void setHoras_dominicales (int horas_dominicales) {
        this.horas_dominicales = horas_dominicales;
    }

    public int getHoras_nocturnas_extras () {
        return horas_nocturnas_extras;
    }

    public void setHoras_nocturnas_extras (int horas_nocturnas_extras) {
        this.horas_nocturnas_extras = horas_nocturnas_extras;
    }

    public int getHoras_dominicales_extras () {
        return horas_dominicales_extras;
    }

    public void setHoras_dominicales_extras (int horas_dominicales_extras) {
        this.horas_dominicales_extras = horas_dominicales_extras;
    }

    public int getTotal_horas () {
        return total_horas;
    }

    public void setTotal_horas (int total_horas) {
        this.total_horas = total_horas;
    }

    public int getHoras_nocturnas () {
        return horas_nocturnas;
    }

    public void setHoras_nocturnas (int horas_nocturnas) {
        this.horas_nocturnas = horas_nocturnas;
    }

    public int getHoras_normales () {
        return horas_normales;
    }

    public void setHoras_normales (int horas_normales) {
        this.horas_normales = horas_normales;
    }
}



