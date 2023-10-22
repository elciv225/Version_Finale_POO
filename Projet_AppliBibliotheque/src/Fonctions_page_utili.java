import java.time.LocalDate;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Fonctions_page_utili {

    public static void fonction_Utilisateur(){
        boolean boucle = true;
        while (boucle){
            int choix;
            Scanner scanner = new Scanner(System.in);
            Lecteurs lecteurs = new Lecteurs();
            System.out.println("""
                        
                                       Vous etes sur la page utilisateur
                    
                                              Fonction disponible :
                    
                    1 -> Afficher la liste des livres disponible  2 -> Rechercher un livre
                    3 -> Emprunter un livre                       4 -> Rendre un livre
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
                        lecteurs.afficher_Livres("ListeLivresLecteur.txt");
                    }
                    case 2 -> {
                        String recherche;
                        System.out.println("Vous pouvez rechercher le un livre veillez entrer le titre");
                        System.out.print("Titre : ");
                        recherche = scanner.next();
                        Lecteurs.recherche_livre("ListeLivresLecteur.txt",recherche);
                    }
                    case 3 -> {
                        String titre;
                        String auteur;
                        LocalDate date_aujourdhu = LocalDate.now();
                        System.out.println("Entrez les information du livre a emprunter : ");
                        System.out.print("Titre : ");
                        titre = scanner.next();
                        System.out.print("Auteur : ");
                        auteur = scanner.next();
                        Bibliotheque emprunteur = new Bibliotheque(Principale.user,Principale.login,titre,auteur,date_aujourdhu);
                        if (Gestion_Exeception.verification("ListeLivresLecteur.txt",titre) && Gestion_Exeception.verification("ListeLivresLecteur.txt",titre)){
                            Lecteurs.ajouter_Emprunteur(emprunteur);
                        }
                    }
                    case 4 -> {
                        String titre;
                        System.out.println("Entrez le titre du livre a rendre : ");
                        System.out.print("Titre : ");
                        titre = scanner.next();
                        Lecteurs.rendre_livre(Lecteurs.recherche_livre(Bibliotheque.liste_emprunteur));
                        System.out.println("Vous avez rendu "+titre);
                    }
                    default -> System.err.println("\nVeillez entre un des nombres");
                }
            }catch (InputMismatchException e){
                System.out.println("Veillez entre un entier valide");
            }
        }
    }

}
