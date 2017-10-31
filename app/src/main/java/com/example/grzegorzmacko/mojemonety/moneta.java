package com.example.grzegorzmacko.mojemonety;

/**
 * Created by Grzesiek on 2017-06-08.
 */

public class moneta {
     int _id;

    public moneta(int _id, String waluta, int rok, String ksztalt, String metal,String stop_metalu,String kraj_pochodzenia,
                  int nominal, int waga, int srednica, int wartosc){
        this.setId(_id);
        this.setWaluta(waluta);
        this.setRok(rok);
        this.setKsztalt(ksztalt);
        this.setMetal(metal);
        this.setStop_metalu(stop_metalu);
        this.setKraj_pochodzenia(kraj_pochodzenia);
        this.setNominal(nominal);
        this.setWaga(waga);
        this.setSrednica(srednica);
        this.setWartosc(wartosc);
    }

    public moneta(){


    }



    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    String waluta;
    Integer rok;
    String ksztalt;
    String metal;
    String stop_metalu;
    String kraj_pochodzenia;
    Integer nominal;
    Integer waga;
    Integer srednica;
    Integer wartosc;

    public Integer getRok() {
        return rok;
    }

    public void setRok(Integer rok) {
        this.rok = rok;
    }

    public String getKsztalt() {
        return ksztalt;
    }

    public void setKsztalt(String ksztalt) {
        this.ksztalt = ksztalt;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public String getStop_metalu() {
        return stop_metalu;
    }

    public void setStop_metalu(String stop_metalu) {
        this.stop_metalu = stop_metalu;
    }

    public String getKraj_pochodzenia() {
        return kraj_pochodzenia;
    }

    public void setKraj_pochodzenia(String kraj_pochodzenia) {
        this.kraj_pochodzenia = kraj_pochodzenia;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public Integer getWaga() {
        return waga;
    }

    public void setWaga(Integer waga) {
        this.waga = waga;
    }

    public Integer getSrednica() {
        return srednica;
    }

    public void setSrednica(Integer srednica) {
        this.srednica = srednica;
    }

    public Integer getWartosc() {
        return wartosc;
    }

    public void setWartosc(Integer wartosc) {
        this.wartosc = wartosc;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }
}
