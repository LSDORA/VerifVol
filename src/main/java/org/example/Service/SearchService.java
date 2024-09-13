package org.example.Service;

import org.example.Model.Vol;
import org.example.Model.Billet;
import org.example.Repository.SearchRepositoryInterface;

import java.util.ArrayList;

public class SearchService implements SearchServiceInterface {
    private ArrayList<SearchRepositoryInterface> repository;

    public SearchService(ArrayList<SearchRepositoryInterface> repository) {
        this.repository = repository;
    }

    @Override
    public Billet rechercher(String referenceBillet) {
        for (SearchRepositoryInterface reps : repository) {
            Billet billet = reps.rechercher(referenceBillet);
            if (billet != null) {
                return billet;
            }
        }
        return null;
    }

    @Override
    public Vol getVolById(int idVol) {
        for (SearchRepositoryInterface reps : repository) {
            Vol vol = reps.getVolById(idVol);
            if (vol != null) {
                return vol;
            }
        }
        return null;
    }
}
