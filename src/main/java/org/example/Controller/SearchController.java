package org.example.Controller;

import org.example.Model.Billet;
import org.example.Model.Vol;
import org.example.Service.SearchServiceInterface;

public class SearchController {

    private SearchServiceInterface service;

    public SearchController(SearchServiceInterface service) {
        this.service = service;
    }

    public String find(String referenceBillet) {
        Billet billet = service.rechercher(referenceBillet);


        if (billet != null) {
            int idVol = billet.getIdVol();


            Vol vol = service.getVolById(idVol);

            if (vol != null) {
                return vol.getNumvol();
            } else {
                return "Vol non trouvé pour l'ID : " + idVol;
            }
        } else {
            return "Billet non trouvé pour la référence : " + referenceBillet;
        }
    }
}
