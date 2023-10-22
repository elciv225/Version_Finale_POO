import java.util.Scanner;
import java.util.InputMismatchException;


public class Fonctions_page_admin {

    public static void fonction_Administrateur(){
        boolean boucle = true;
        while (boucle){
            int choix;
            Scanner scanner = new Scanner(System.in);
            Administrateur administrateur = new Administrateur();
            System.out.println("""
                  
                                          Vous etes sur la page administrateur
                    
                                                    Fonction disponible :
                   
                    1 -> Afficher la liste des livres        2 -> Afficher la liste des livres non disponible
                    3 -> Afficher la liste des emprunteurs   4 -> Ajouter un livre
                    5 -> Retirer un livre
                    0 -> Arreter le programme
                    """);
            System.out.print("Entrer le chiffre de ce que vous voulez pour effectuer une action");
            try {
                System.out.print("\nchoix : ");
                choix = scanner.nextInt();
                switch (choix) {
                    case 0 -> boucle = false;
                    case 1 -> {
                        System.out.println("\n\nVoici la liste des livres\n");
                        administrateur.afficher_Fichier("ListeLivresAdmin.txt");
                    }
                    case 2 -> {
                        System.out.println("\n\nVoici la liste des livres non disponible\n");
                        administrateur.afficher_Livres_NonDisponibles("ListLivreNonDispo.txt");
                    }
                    case 3 -> {
                        System.out.println("\n\nVoici la liste des emprunteurs\n");
                        administrateur.afficher_Fichier("ListeLivresEmprunteur.txt");
                    }
                    case 4 -> {
                        String titre;
                        String auteur;
                        String categorie;
                        int nbre_disponible;
                        System.out.println("\n\nVous allez ajoujer un livre\n");
                        System.out.print("Titre : ");
                        titre = scanner.next();
                        System.out.print("Auteur : ");
                        auteur = scanner.next();
                        System.out.print("Categorie : ");
                        categorie = scanner.next();
                        System.out.print("Nombre disponible : ");
                        nbre_disponible = scanner.nextInt();
                        Bibliotheque nouveau_livre = new Bibliotheque(auteur, titre, categorie, nbre_disponible);
                        administrateur.ajouter_Livre(nouveau_livre);
                        System.out.println("Le livre a ete correctement ajoute");
                    }
                    case 5 -> {
                        String titre;
                        System.out.println("Veillez le titre du livre a supprimer");
                        System.out.print("Titre : ");
                        titre = scanner.next();
                        administrateur.retirer_Livre(titre);
                        System.out.println("Le livre "+titre+" a ete supprime");
                    }
                    default -> System.err.println("\nVeillez entre un des nombres");
                }
            }catch (InputMismatchException e){
                System.out.println("Veillez entre un entier valide");
            }

        }

    }

}
