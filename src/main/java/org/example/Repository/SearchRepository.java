package org.example.Repository;

import org.example.Model.Vol;
import org.example.Model.Billet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class SearchRepository implements SearchRepositoryInterface {

    protected Map<Integer, Vol> vols;
    protected Map<Integer, ArrayList<Billet>> billetsParVol;

    public SearchRepository() {
        // Initialisation des collections
        vols = new HashMap<>();
        billetsParVol = new HashMap<>();
        loadData();
    }

    protected abstract void loadData();

    @Override
    public ArrayList<Vol> getVol() {
        return new ArrayList<>(vols.values());
    }

    @Override
    public ArrayList<Billet> getBillets() {
        ArrayList<Billet> allBillets = new ArrayList<>();
        for (ArrayList<Billet> billets : billetsParVol.values()) {
            allBillets.addAll(billets);
        }
        return allBillets;
    }

    @Override
    public Vol getVolById(int idVol) {
        return vols.get(idVol);
    }

    @Override
    public Billet rechercher(String referenceBillet) {
        for (ArrayList<Billet> billets : billetsParVol.values()) {
            for (Billet billet : billets) {
                if (billet.getRefBillet().equalsIgnoreCase(referenceBillet)) {
                    return billet;
                }
            }
        }
        return null;
    }
}
