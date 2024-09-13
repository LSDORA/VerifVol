package org.example.Model;

public class Vol {
    private int id;
    private String numvol;

    public Vol(int id, String numvol) {
        this.id = id;
        this.numvol = numvol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumvol() {
        return numvol;
    }

    public void setNumvol(String numvol) {
        this.numvol = numvol;
    }
}
