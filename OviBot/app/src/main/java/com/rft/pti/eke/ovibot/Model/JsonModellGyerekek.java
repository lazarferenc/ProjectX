package com.rft.pti.eke.ovibot.Model;

/**
 * Created by lazarferenc on 2016.12.09..
 */

public class JsonModellGyerekek {

    private String TeljesNev;
    private String Magatartas;
    private String Hangulat;
    private String Jelenlet;
    private String Datum;

    /*Getterek*/

/*     public String getTeljesNev() {
        return TeljesNev;
    }

     public String getMagatartas() {
        return Magatartas;
    }

    public String getHangulat() {
        return Hangulat;
    }

    public String getJelenlet() {
        return Jelenlet;
    }

    public String getDatum() {
        return Datum;
    }*/



    /*TeljesNev setter*/
    public void setTeljesNev(String TeljesNev) {
        this.TeljesNev = TeljesNev;
    }

    public JsonModellGyerekek(String TeljesNev, String Magatartas, String Hangulat, String Jelenlet, String Datum) {
        this.TeljesNev = TeljesNev;
        this.Magatartas = Magatartas;
        this.Hangulat = Hangulat;
        this.Jelenlet = Jelenlet;
        this.Datum = Datum;
    }

    public JsonModellGyerekek(){
        super();
    }
}
