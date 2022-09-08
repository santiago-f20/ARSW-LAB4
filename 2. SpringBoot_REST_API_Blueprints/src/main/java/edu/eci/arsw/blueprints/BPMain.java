package edu.eci.arsw.blueprints;

import edu.eci.arsw.blueprints.filter.services.FilterService;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BPMain implements CommandLineRunner {
    @Autowired
    BlueprintsServices services;

    @Autowired
    FilterService filters;

    public static void main(String[] args) {
        SpringApplication.run(BPMain.class, args);
    }

    public void print(String author, String author1) {
        System.out.println("Autor 1: " + author);
        System.out.println("Planos registrados.");
        System.out.println("Autor 2: " + author1);
        System.out.println("Planos registrados.");
    }

    @Override
    public void run(String... args) throws Exception {
        int planos = 10;
        String author = "Santiago";
        String author1 = "Juan";
        print(author, author1);
        for (int i = 0; i < planos; i++) {
            services.addNewBlueprint(new Blueprint(author, "plano" + (i * 2)));
            services.addNewBlueprint(new Blueprint(author1, "plano" + (i * 2) + 1));
        }
        System.out.println("--------PLANOS--------");
        System.out.println(services.getAllBlueprints());
        System.out.println("--------PLANOS DE SANTIAGO--------");
        System.out.println(services.getBlueprintsByAuthor("Santiago"));
        System.out.println("--------PLANOS DE JUAN DAVID--------");
        System.out.println(services.getBlueprintsByAuthor("Juan"));

    }

}
