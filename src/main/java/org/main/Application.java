package org.main;

import ma.en7.model.Produit;
import ma.en7.serviceImplementation.MetierProduitImpl;

import java.util.List;
import java.util.Scanner;

public class Application {
    static Scanner sc = new Scanner(System.in);
    static MetierProduitImpl produitService = new MetierProduitImpl();

    public static void afficherMenu(){
        System.out.println("\n************* MENU ************* ");
        System.out.println("1. Afficher la liste des produits");
        System.out.println("2. Rechercher un produit par son id");
        System.out.println("3. Ajouter un nouveau produit dans la liste");
        System.out.println("4. Supprimer un produit par id");
        System.out.println("5. Quitter ce programme");
    }
    public static  void afficherProduits(){
        List<Produit> p= produitService.getAll();
        System.out.println("p = "+p);
        if (!p.isEmpty() ){
            System.out.println("************* PRODUITS *************");
            System.out.printf("%-6s | %-10s | %-20s | %-10s | %-10s | %-8s %n", "ID","Nom","Description","Marque","Prix","Stock");
            for (Produit p1 : p){
            System.out.printf("%-6d | %-10s | %-20s | %-10s | %-10.2f | %-8d %n", p1.getId(),p1.getNom(),p1.getDescription(),p1.getMarque(),p1.getPrix(),p1.getNbr_stock());

            }

        }else{
            System.out.println("Table est vide");
        }
    }

    public static  void chercherProduitParId(){
        int id = 0;
        do {

        System.out.println("Entrez l'id du produit: ");
        while (!sc.hasNextInt()){
            System.out.println("Entrez un id valide");
            sc.next();
        }
        id = sc.nextInt();
        if(id <1 ){
            System.out.println("L'id doit être un entier superieur à 1");
        }
        }while (id <1);
        Produit produit =produitService.findById(id);
        System.out.println("p = "+produit);
        if (produit==null){
            System.out.println("Produit non trouvé -_-");
        }else{
            System.out.println("************* PRODUIT AVEC ID: " + id + " *************");
            System.out.printf("%-6s | %-10s | %-20s | %-10s | %-10s | %-8s%n",
                    "ID", "Nom", "Description", "Marque", "Prix", "Stock");

            System.out.printf("%-6d | %-10s | %-20s | %-10s | %-10.2f | %-8d%n",
                    produit.getId(),
                    produit.getNom(),
                    produit.getDescription(),
                    produit.getMarque(),
                    produit.getPrix(),
                    produit.getNbr_stock());
        }
    }

    public static  void ajouterProduit(){
        Produit p = new Produit();
        Produit idChecker = new Produit();
    int id=0;
        do {
            System.out.println("Entrez l'id du produit: ");
            while (!sc.hasNextInt()) {
                System.out.println("L'ID doit être un entier supérieur à 0");
                sc.next(); // Effacer l'entrée invalide
            }
            id = sc.nextInt();
            sc.nextLine(); // Consommer le retour à la ligne restant

            if (id < 1) {
                System.out.println("L'ID doit être un entier supérieur à 0");
            } else {
                idChecker = produitService.findById(id);
                if (idChecker != null) {
                    System.out.println("L'id " + id + " est déjà pris par un autre produit!");
                }
            }
        } while (idChecker != null || id < 1);

        p.setId(id);
        System.out.println("id entregistre p.getId "+p.getId());

        System.out.println("Entrez le nom du produit: ");
        while (!sc.hasNextLine()){
            System.out.println("Merci d'entrer un nom valide!");
            sc.next();
        }
        String nom = sc.nextLine();
        p.setNom(nom);
        System.out.println("Entrez la description du produit: ");
        while (!sc.hasNextLine()){
            System.out.println("Merci d'entrer une description valide!");
            sc.next();
        }
        String description = sc.nextLine();
        p.setDescription(description);

        System.out.println("Entrez la marque du produit: ");
        while (!sc.hasNextLine()){
            System.out.println("Merci d'entrer une nom valide!");
            sc.next();
        }
        String marque = sc.nextLine();
        p.setMarque(marque);
        System.out.println("Entrez le prix du produit: ");
        while (!sc.hasNextDouble()){
            System.out.println("Merci d'entrer un prix valide!");
            sc.next();
        }
        double prix = sc.nextDouble();
        p.setPrix(prix);

        int q_stock = 0;
        do{

        System.out.println("Entrez la quandtité du stock du produit: ");
        while (!sc.hasNextInt() ){
            System.out.println("Merci d'entrer un entier > 0!");
            sc.next();
        }

             q_stock = sc.nextInt();
        }while (q_stock <1);
        p.setNbr_stock(q_stock);

        produitService.add(p);
        System.out.println("produit ajouté ");
    }

    public  static  void  supprimerProduit(){
        int id = 0;
        do {

            System.out.println("Entrez l'id du produit: ");
            while (!sc.hasNextInt()){
                System.out.println("Entrez un id valide!");
                sc.next();
            }
            id = sc.nextInt();
            if(id <1 ){
                System.out.println("L'id doit être un entier superieur à 1");
            }
        }while (id<1);
        Produit produit = produitService.findById(id);
        if (produit==null){
            System.out.println("Produit à supprimer non trouvé");
        }else {
            produitService.delete(id);
            System.out.println("Produit supprimé avec succes");
        }
    }
    public static void main(String[] args) {
        int selectedOption = 0;

        do{
            afficherMenu();
            while (!sc.hasNextInt()){
                System.out.println("Merci d'entrer un entier entre 1 et 5 ");
                sc.next();
            }
            selectedOption = sc.nextInt();
            switch (selectedOption){
                case 1: afficherProduits();break;
                case 2: chercherProduitParId();break;
                case 3: ajouterProduit();break;
                case 4: supprimerProduit();break;
                case 5: break;
                default:  System.out.println("Merci d'entrer un choix valide (entier entre 1 et 5)"); break;
            }

        }while (selectedOption != 5);
        System.out.println("Le programme est terminé");
    }
}

