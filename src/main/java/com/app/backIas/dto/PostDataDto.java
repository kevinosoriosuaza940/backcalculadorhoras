package com.app.backIas.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class PostDataDto {
    @Id
    @Column(name = "id_tecnico")
    private String id_tecnico;

    @Column(name = "id_tipo_servicio")
    private int id_tipo_servicio;

    @Column(name = "id_servicio")
    private String id_servicio;

    @Column(name = "numero_semana")
    private int numero_semana;

    @Column(name = "numero_dia")
    private int numero_dia;

    @Column(name = "horas_normales")
    private int horas_normales;

    @Column(name = "hora_inicio")
    private Date hora_inicio;

    @Column(name = "hora_fin")
    private Date hora_fin;

    @Column(name = "horas_normales_extras")
    private int horas_normales_extras;

    @Column(name = "horas_nocturnas")
    private int horas_nocturnas;

    @Column(name = "horas_nocturnas_extras")
    private int horas_nocturnas_extras;

    @Column(name = "horas_dominicales")
    private int horas_dominicales;

    @Column(name = "horas_dominicales_extras")
    private int horas_dominicales_extras;

    @Column(name = "total_horas")
    private int total_horas;



    @Column(name = "id_semana")
    private int id_semana;


    public int getId_tipo_servicio () {
        return id_tipo_servicio;
    }

    public void setId_tipo_servicio (int id_tipo_servicio) {
        this.id_tipo_servicio = id_tipo_servicio;
    }

    public String getId_servicio () {
        return id_servicio;
    }

    public void setId_servicio (String id_servicio) {
        this.id_servicio = id_servicio;
    }

    public int getNumero_semana () {
        return numero_semana;
    }

    public void setNumero_semana (int numero_semana) {
        this.numero_semana = numero_semana;
    }

    public int getNumero_dia () {
        return numero_dia;
    }

    public void setNumero_dia (int numero_dia) {
        this.numero_dia = numero_dia;
    }

    public int getHoras_normales () {
        return horas_normales;
    }

    public void setHoras_normales (int horas_normales) {
        this.horas_normales = horas_normales;
    }

    public Date getHora_inicio () {
        return hora_inicio;
    }

    public void setHora_inicio (Date hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Date getHora_fin () {
        return hora_fin;
    }

    public void setHora_fin (Date hora_fin) {
        this.hora_fin = hora_fin;
    }

    public int getHoras_normales_extras () {
        return horas_normales_extras;
    }

    public void setHoras_normales_extras (int horas_normales_extras) {
        this.horas_normales_extras = horas_normales_extras;
    }

    public int getHoras_nocturnas () {
        return horas_nocturnas;
    }

    public void setHoras_nocturnas (int horas_nocturnas) {
        this.horas_nocturnas = horas_nocturnas;
    }

    public int getHoras_nocturnas_extras () {
        return horas_nocturnas_extras;
    }

    public void setHoras_nocturnas_extras (int horas_nocturnas_extras) {
        this.horas_nocturnas_extras = horas_nocturnas_extras;
    }

    public int getHoras_dominicales () {
        return horas_dominicales;
    }

    public void setHoras_dominicales (int horas_dominicales) {
        this.horas_dominicales = horas_dominicales;
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

    public String getId_tecnico () {
        return id_tecnico;
    }

    public void setId_tecnico (String id_tecnico) {
        this.id_tecnico = id_tecnico;
    }

    public int getId_semana () {
        return id_semana;
    }

    public void setId_semana (int id_semana) {
        this.id_semana = id_semana;
    }
}


