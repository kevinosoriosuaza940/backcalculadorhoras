package com.app.backIas.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Contadorhoras {

    static Calendar cal = Calendar.getInstance();

    public static int calculateHour (Date date) {
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public static int calcularhoraservicio (Date starhour, Date endhour) {

        if (calculateHour(starhour) >= calculateHour(endhour)) {
            return 0;
        }
        return calculateHour(endhour) - calculateHour(starhour);
    }

    public static int calculadorhorasnocturnas (Date start, Date end) {

        Calendar calStart = Calendar.getInstance();
        Calendar calEnd = Calendar.getInstance();

        calStart.setTime(start);
        calEnd.setTime(end);
        int startNight = 20;
        int endNigth = 7;
        int midNigth = 24;

        if (( calStart.get(Calendar.HOUR_OF_DAY) >= startNight && calEnd.get(Calendar.HOUR_OF_DAY) <= midNigth ) || calEnd.get(Calendar.HOUR_OF_DAY) <= endNigth) {

            if (calEnd.get(Calendar.HOUR_OF_DAY) <= midNigth)
                return calEnd.get(Calendar.HOUR_OF_DAY) - startNight; // dia - noche
            else {// dia - madrugada
                return ( midNigth - calStart.get(Calendar.HOUR_OF_DAY) ) + calEnd.get(Calendar.HOUR_OF_DAY);
            }

        } else if (calStart.get(Calendar.HOUR_OF_DAY) >= startNight && calEnd.get(Calendar.HOUR_OF_DAY) <= endNigth) {

            if (calEnd.get(Calendar.HOUR_OF_DAY) <= endNigth) {// noche-noche
                return ( calEnd.get(Calendar.HOUR_OF_DAY) + 4 ) - ( calStart.get(Calendar.HOUR_OF_DAY) - startNight ); //20 - 24
            } else {
                return ( endNigth - calStart.get(Calendar.HOUR_OF_DAY) ) - ( endNigth - calEnd.get(Calendar.HOUR_OF_DAY) ); //0 - 7
            }

        } else if (calStart.get(Calendar.HOUR_OF_DAY) >= startNight && calEnd.get(Calendar.HOUR_OF_DAY) >= endNigth) {
            if (calStart.get(Calendar.HOUR_OF_DAY) <= midNigth && calStart.get(Calendar.HOUR_OF_DAY) >= startNight) {
                return ( midNigth - calStart.get(Calendar.HOUR_OF_DAY) ); // noche - dia
            } else {
                return ( endNigth - calStart.get(Calendar.HOUR_OF_DAY) ); // madrugada - dia
            }
        } else {
            return 0;
        }

    }

    public static int calculardiasemana (Date date) {
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static int  calculatesemanaaño (Date date) {
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public static int calcularhorasdominicales (Date stardate, Date enddate) {
        int dia = calculardiasemana(stardate);
        if (dia == 7) {
            return calcularhoraservicio(stardate, enddate);
        } else {
            return 0;
        }
    }


    public static int calcularhorascomunes (Date stardate, Date enddate) {



        return calcularhoraservicio(stardate, enddate) - calcularhorasdominicales(stardate, enddate) - calculadorhorasnocturnas(stardate, enddate);
    }
        public String formatDate () {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
            String dateStr = "1994-02-21 02:00:00";
            try {
                Date date = formatter.parse(dateStr);
                return formatter.format(date);
            } catch(ParseException e) {e.printStackTrace();}
            return dateStr;
        }
    }


