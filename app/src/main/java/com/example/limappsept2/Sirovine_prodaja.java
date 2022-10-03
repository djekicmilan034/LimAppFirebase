package com.example.limappsept2;

public class Sirovine_prodaja {

    public Sirovine_prodaja(){}

    String kupacProdaja;
    String datumProdaja;
    String komadi1Prodaja;
    String komadi8Prodaja;
    String komadi7Prodaja;
    String cenaProdaja;

    public Sirovine_prodaja(String cenaProdaja, String datumProdaja, String komadi1Prodaja, String komadi7Prodaja, String komadi8Prodaja, String kupacProdaja) {
        this.kupacProdaja = kupacProdaja;
        this.datumProdaja = datumProdaja;
        this.komadi1Prodaja = komadi1Prodaja;
        this.komadi8Prodaja = komadi8Prodaja;
        this.komadi7Prodaja = komadi7Prodaja;
        this.cenaProdaja = cenaProdaja;
    }

    public void setKupacProdaja(String kupacProdaja) {
        this.kupacProdaja = kupacProdaja;
    }

    public void setDatumProdaja(String datumProdaja) {
        this.datumProdaja = datumProdaja;
    }

    public void setKomadi1Prodaja(String komadi1Prodaja) {
        this.komadi1Prodaja = komadi1Prodaja;
    }

    public void setKomadi8Prodaja(String komadi8Prodaja) {
        this.komadi8Prodaja = komadi8Prodaja;
    }

    public void setKomadi7Prodaja(String komadi7Prodaja) {
        this.komadi7Prodaja = komadi7Prodaja;
    }

    public void setCenaProdaja(String cenaProdaja) {
        this.cenaProdaja = cenaProdaja;
    }



    public String getKupacProdaja() {
        return kupacProdaja;
    }

    public String getDatumProdaja() {
        return datumProdaja;
    }

    public String getKomadi1Prodaja() {
        return komadi1Prodaja;
    }

    public String getKomadi8Prodaja() {
        return komadi8Prodaja;
    }

    public String getKomadi7Prodaja() {
        return komadi7Prodaja;
    }

    public String getCenaProdaja() {
        return cenaProdaja;
    }






}
