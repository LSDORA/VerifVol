package org.example.Repository;

import org.example.Model.Billet;
import org.example.Model.Vol;

import java.util.ArrayList;

public interface SearchRepositoryInterface {
    ArrayList<Vol> getVol();
    ArrayList<Billet> getBillets();
    Billet rechercher(String referenceBillet);
    Vol getVolById(int idVol);
}
