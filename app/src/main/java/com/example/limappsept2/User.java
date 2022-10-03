package com.example.limappsept2;

public class User {
    public User(){}

    public String getCenaProdaja() {
        return cenaProdaja;
    }

    public void setCenaProdaja(String cenaProdaja) {
        this.cenaProdaja = cenaProdaja;
    }

    public String getDatumProdaja() {
        return datumProdaja;
    }

    public void setDatumProdaja(String datumProdaja) {
        this.datumProdaja = datumProdaja;
    }

    public String getKomadi1Prodaja() {
        return komadi1Prodaja;
    }

    public void setKomadi1Prodaja(String komadi1Prodaja) {
        this.komadi1Prodaja = komadi1Prodaja;
    }

    public String getKomadi7Prodaja() {
        return komadi7Prodaja;
    }

    public void setKomadi7Prodaja(String komadi7Prodaja) {
        this.komadi7Prodaja = komadi7Prodaja;
    }

    public String getKomadi8Prodaja() {
        return komadi8Prodaja;
    }

    public void setKomadi8Prodaja(String komadi8Prodaja) {
        this.komadi8Prodaja = komadi8Prodaja;
    }

    public String getKupacProdaja() {
        return kupacProdaja;
    }

    public void setKupacProdaja(String kupacProdaja) {
        this.kupacProdaja = kupacProdaja;
    }

    public User(String cenaProdaja, String datumProdaja, String komadi1Prodaja, String komadi7Prodaja, String komadi8Prodaja, String kupacProdaja) {
        this.cenaProdaja = cenaProdaja;
        this.datumProdaja = datumProdaja;
        this.komadi1Prodaja = komadi1Prodaja;
        this.komadi7Prodaja = komadi7Prodaja;
        this.komadi8Prodaja = komadi8Prodaja;
        this.kupacProdaja = kupacProdaja;
    }

    String cenaProdaja,datumProdaja,komadi1Prodaja,komadi7Prodaja,komadi8Prodaja,kupacProdaja;
}
