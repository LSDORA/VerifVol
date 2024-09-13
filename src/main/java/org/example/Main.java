package org.example;

import org.example.Controller.SearchController;
import org.example.Model.Vol;
import org.example.Repository.VolRepository;
import org.example.Repository.SearchRepositoryInterface;
import org.example.Service.SearchService;
import org.example.Service.SearchServiceInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SearchRepositoryInterface volRepository = new VolRepository();



        ArrayList<SearchRepositoryInterface> repositories = new ArrayList<>();
        repositories.add(volRepository);

        SearchServiceInterface searchService = new SearchService(repositories);


        SearchController searchController = new SearchController(searchService);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez votre référence de billet : ");
        String referenceBillet = scanner.nextLine();


        String result = searchController.find(referenceBillet);


        if (result != null && !result.isEmpty()) {
            System.out.println("Votre numéro de vol est : " + result);
        } else {
            System.out.println("Aucun vol trouvé pour la référence de billet : " + referenceBillet);
        }


        scanner.close();
    }
}
