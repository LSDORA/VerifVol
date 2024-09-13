package org.example.Service;

import org.example.Model.Billet;
import org.example.Model.Vol;

public interface SearchServiceInterface {
    Billet rechercher(String text);
    Vol getVolById(int idVol);
}
