package com.app.backIas.model;

public class FormData {
    private String fecha_inicio;
    private String fecha_fin;
    private String Id_tecnico;
    private String id_servicio;

    public FormData (String fecha_inicio, String fecha_fin, String id_tecnico, String id_servicio) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        Id_tecnico = id_tecnico;
        this.id_servicio = id_servicio;
    }

    public String getFecha_inicio () {
        return fecha_inicio;
    }

    public void setFecha_inicio (String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin () {
        return fecha_fin;
    }

    public void setFecha_fin (String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getId_tecnico () {
        return Id_tecnico;
    }

    public void setId_tecnico (String id_tecnico) {
        Id_tecnico = id_tecnico;
    }

    public String getId_servicio () {
        return id_servicio;
    }

    public void setId_servicio (String id_servicio) {
        this.id_servicio = id_servicio;
    }
    @Override
    public String toString(){
        return  fecha_inicio + fecha_fin+id_servicio+Id_tecnico;
    }
}
