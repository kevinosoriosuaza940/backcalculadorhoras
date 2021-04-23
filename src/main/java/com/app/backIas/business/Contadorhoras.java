package com.app.backIas.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Contadorhoras {

    static Calendar cal = Calendar.getInstance();

    public static int calculateHour (Date hora_inicio) {
        cal.setTime(hora_inicio);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public static int calcularhoraservicio (Date hora_inicio, Date hora_fin) {
        int total_horas = calculateHour(hora_fin) - calculateHour(hora_inicio);
        if (calculateHour(hora_inicio) > calculateHour(hora_fin)) {
            return 0;
        }
        return total_horas;
    }

    public static int calculadorhorasnocturnas (Date hora_inicio, Date hora_fin) {

        Calendar calInicio = Calendar.getInstance();
        Calendar calFin = Calendar.getInstance();

        calInicio.setTime(hora_inicio);
        calFin.setTime(hora_fin);
        int startNight = 20;
        int endNigth = 7;
        int midNigth = 24;

        if (( calInicio.get(Calendar.HOUR_OF_DAY) > startNight && ( calFin.get(Calendar.HOUR_OF_DAY) <= midNigth ) || calFin.get(Calendar.HOUR_OF_DAY) <= endNigth )) {

            if (calFin.get(Calendar.HOUR_OF_DAY) <= midNigth)
                return calFin.get(Calendar.HOUR_OF_DAY) - startNight; // dia - noche
            else {// dia - madrugada
                return ( midNigth - calInicio.get(Calendar.HOUR_OF_DAY) ) + calFin.get(Calendar.HOUR_OF_DAY);
            }

        } else if (calInicio.get(Calendar.HOUR_OF_DAY) >= startNight && calFin.get(Calendar.HOUR_OF_DAY) <= endNigth) {

            if (calFin.get(Calendar.HOUR_OF_DAY) <= endNigth) {// noche-noche
                return ( calFin.get(Calendar.HOUR_OF_DAY) + 4 ) - ( calInicio.get(Calendar.HOUR_OF_DAY) - startNight ); //20 - 24
            } else {
                return ( endNigth - calInicio.get(Calendar.HOUR_OF_DAY) ) - ( endNigth - calFin.get(Calendar.HOUR_OF_DAY) ); //0 - 7
            }

        } else if (calInicio.get(Calendar.HOUR_OF_DAY) >= startNight && calFin.get(Calendar.HOUR_OF_DAY) >= endNigth) {
            if (calInicio.get(Calendar.HOUR_OF_DAY) <= midNigth) {
                return ( ( midNigth - calInicio.get(Calendar.HOUR_OF_DAY) ) + endNigth ); // noche - dia
            } else {
                return ( endNigth - calInicio.get(Calendar.HOUR_OF_DAY) ); // madrugada - dia
            }
        } else {
            return 0;
        }

    }

    public static int calculardiasemana (Date fecha_inicio) {
        cal.setTime(fecha_inicio);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static int calculatesemanaaño (Date fecha_inicio) {
        cal.setTime(fecha_inicio);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public static int calcularhorasdominicales (Date fecha_inicio, Date fecha_fin) {
        int dia = calculardiasemana(fecha_inicio);
        if (dia == 7) {
            return calcularhoraservicio(fecha_inicio, fecha_fin);
        } else {
            return 0;
        }
    }


    public static int calcularhorascomunes (Date fecha_inicio, Date fecha_fin) {


        return calcularhoraservicio(fecha_inicio, fecha_fin) - calcularhorasdominicales(fecha_inicio, fecha_fin) - calculadorhorasnocturnas(fecha_inicio, fecha_fin);
    }

}


