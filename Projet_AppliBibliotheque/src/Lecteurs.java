import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Lecteurs extends Bibliotheque {

    public Lecteurs() {}

    public void afficher_Livres(String nom_Fichier){
        File fichier = new File(nom_Fichier);
        try {

            try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void rendre_livre(Bibliotheque livre){
        if (livre != null){
            if (verifier_emprunt(livre.getNom_Emprunteur(), livre.getTitre(),"ListeLivresEmprunteur.txt")){
                for (Bibliotheque emprunteur : liste_livre_admin) {
                    if (emprunteur.getTitre().equals(livre.getTitre())) {
                        emprunteur.setNbre_Disposible(emprunteur.getNbre_Disposible()- 1);
                        System.out.println("Le livre a ete rendu");
                        break;
                    }
                }
            }else {
                System.out.println("Vous n'avez pas emprunter ce livre");
            }
        }
    }

    public static void ajouter_Emprunteur(Bibliotheque livre){
        Parametre_liste.enregistrer_FichierTexteEmprunteur(livre);
        for (Bibliotheque emprunteur : liste_livre_admin) {
            if (emprunteur.getTitre().equals(livre.getTitre())) {
                emprunteur.setNbre_Disposible(emprunteur.getNbre_Disposible() + 1);
                break;
            }
        }
    }

    public static Bibliotheque recherche_livre(List<Bibliotheque> liste_livre) {
        Bibliotheque result = null;
        for (Bibliotheque livre : liste_livre) {
            result = livre;
            break;
        }
        return result;
    }

    public static void recherche_livre(String nom_Fichier, String element_Rechercher){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nom_Fichier));
            String ligne;
            boolean retrouve = false;
            while ((ligne = reader.readLine()) != null) {
                if (ligne.contains(element_Rechercher)) {
                    for (int i = 0; i < 2; i++) {
                        ligne = reader.readLine();
                        if (ligne != null) {
                            System.out.println(ligne);
                        }
                    }
                    retrouve = true;
                    break;
                }
            }
            if(!retrouve){
                System.out.println("L'element rechercher n'existe pas à la Bibliotheque");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static boolean verifier_emprunt(String nom_emprunteur, String titre_livre, String nom_fichier){
        try (BufferedReader reader = new BufferedReader(new FileReader(nom_fichier))) {
            String line;
            String currentEmprunteur;
            String currentLivre;
            boolean isEmprunteurMatch = false;
            boolean isLivreMatch = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Nom de l'emprunteur : ")) {
                    currentEmprunteur = line.substring("Nom de l'emprunteur : ".length());
                    isEmprunteurMatch = currentEmprunteur.equals(nom_emprunteur);
                } else if (line.startsWith("Titre : ")) {
                    currentLivre = line.substring("Titre : ".length());
                    isLivreMatch = currentLivre.equals(titre_livre);
                }
                if (isEmprunteurMatch && isLivreMatch) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
