package com.rft.pti.eke.ovibot.Model;

/**
 * Created by lazarferenc on 2016.12.09..
 */

public class JsonModellEtkezes {
    private String Datum;
    private String Reggeli;
    private String Ebed;
    private String Uzsonna;



    public String getDatum() {
        return Datum;
    }

    public String getReggeli() {
        return Reggeli;
    }

    public void setReggeli(String Reggeli) {
        this.Reggeli = Reggeli;
    }


    public String getEbed() {
        return Ebed;
    }

    public String getUzsonna() {
        return Uzsonna;
    }

    public JsonModellEtkezes(String Datum, String Reggeli, String Ebed, String Uzsonna) {
        this.Datum = Datum;
        this.Reggeli = Reggeli;
        this.Ebed = Ebed;
        this.Uzsonna = Uzsonna;

    }

    public JsonModellEtkezes(){
        super();
    }
}