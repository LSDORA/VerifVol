package org.example.Model;

public class Billet {
    private int idBillet;
    private String refBillet;
    private int idVol;

    public Billet(int idBillet, String refBillet, int idVol) {
        this.idBillet = idBillet;
        this.refBillet = refBillet;
        this.idVol = idVol;
    }

    public int getIdBillet() {
        return idBillet;
    }

    public void setIdBillet(int idBillet) {
        this.idBillet = idBillet;
    }

    public String getRefBillet() {
        return refBillet;
    }

    public void setRefBillet(String refBillet) {
        this.refBillet = refBillet;
    }

    public int getIdVol() {
        return idVol;
    }

    public void setIdVol(int idVol) {
        this.idVol = idVol;
    }
}
