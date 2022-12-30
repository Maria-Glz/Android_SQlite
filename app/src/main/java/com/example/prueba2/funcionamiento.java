package com.example.prueba2;

public class funcionamiento {

    private int img;
    private String idd,temperatura,ph,oxigeno_disuelto,turbidez,conductividad;

    public funcionamiento(String string, String cursorString, String s, String string1, String cursorString1)
    {
    }
//texview en lugar de id
    public funcionamiento(String idd, String temperatura, String ph, String oxigeno_disuelto, String turbidez, String conductividad) {
        this.idd = idd;
        this.temperatura = temperatura;
        this.ph = ph;
        this.oxigeno_disuelto = oxigeno_disuelto;
        this.turbidez = turbidez;
        this.conductividad = conductividad;
        this.img = img;
    }

    public funcionamiento() {

    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getOxigeno_disuelto() {
        return oxigeno_disuelto;
    }

    public void setOxigeno_disuelto(String oxigeno_disuelto) {
        this.oxigeno_disuelto = oxigeno_disuelto;
    }

    public String getTurbidez() {
        return turbidez;
    }

    public void setTurbidez(String turbidez) {
        this.turbidez = turbidez;
    }

    public String getConductividad() {

        return conductividad;
    }

    public void setConductividad(String conductividad) {
        this.conductividad = conductividad;
    }


    public String getId() {
        return idd;
    }
    public void setIdd(String idd) {
        this.idd = idd;
    }
}

