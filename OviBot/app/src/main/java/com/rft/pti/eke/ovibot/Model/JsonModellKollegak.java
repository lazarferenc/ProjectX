package com.rft.pti.eke.ovibot.Model;

/**
 * Created by lazarferenc on 2016.12.09..
 */

public class JsonModellKollegak {
    private String TeljesNev;
    private String Iroda;
    private String Telefon;
    private String Email;
    //private String Datum;
    /*Getterek*/
    public String getTeljesNev() {
        return TeljesNev;
    }
    public String getIroda() {
        return Iroda;
    }
    public String getTelefon() {
        return Telefon;
    }
    public String getEmail() {
        return Email;
    }
    /*Setter*/
    public void setTeljesNev(String TeljesNev) {
        this.TeljesNev = TeljesNev;
    }


    public JsonModellKollegak(String TeljesNev, String Iroda, String Telefon, String Email) {
        this.TeljesNev = TeljesNev;
        this.Iroda = Iroda;
        this.Telefon = Telefon;
        this.Email = Email;

    }

    public JsonModellKollegak(){
        super();
    }
}
