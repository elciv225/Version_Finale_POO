import java.io.*;

public class Parametre_liste extends Bibliotheque{

    public Parametre_liste() {}

    public void enregistrer_FichierTexteAdmin(Bibliotheque livre ) {
        String ListeLivres = "ListeLivresAdmin.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ListeLivres, true))) {
            writer.write("Titre : " + livre.getTitre());
            writer.newLine();
            writer.write("Auteur : " + livre.getAuteur());
            writer.newLine();
            writer.write("Catégorie : " + livre.getCategorie());
            writer.newLine();
            writer.write("Nombre disponible : " + livre.getNbre_Disposible());
            writer.newLine();
            writer.newLine();//Séparation
            System.out.println("Données enregistrées dans " + ListeLivres);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enregistrer_FichierTexteLecteur(Bibliotheque livre) {
        String ListeLivres = "ListeLivresLecteur.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ListeLivres, true))) {
            writer.write("Titre : " + livre.getTitre());
            writer.newLine();
            writer.write("Auteur : " + livre.getAuteur());
            writer.newLine();
            writer.write("Catégorie : " + livre.getCategorie());
            writer.newLine();
            writer.newLine();//Séparation
            System.out.println("Données enregistrées dans " + ListeLivres);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void enregistrer_FichierTexteEmprunteur(Bibliotheque livre) {
        String ListeLivres = "ListeLivresEmprunteur.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ListeLivres, true))) {
            writer.write("Nom de l'emprunteur : " + livre.getNom_Emprunteur());
            writer.newLine();
            writer.write("Date de naissance : " + livre.getAnniversaire_Emprunteur());
            writer.newLine();
            writer.write("Titre : " + livre.getTitre());
            writer.newLine();
            writer.write("Auteur : " + livre.getAuteur());
            writer.newLine();
            writer.write("Date d'emprunt : " + livre.getDate_emprunt());
            writer.newLine();
            writer.newLine();//Séparation
            System.out.println("Données enregistrées dans " + ListeLivres);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enregistrer_LivresNonDispo(String fichierOrigine, String fichierDestination) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fichierOrigine));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fichierDestination));
            String ligne;
            boolean livre_Disponible = true; //Si true le livre est disponible
            while ((ligne = reader.readLine()) != null) {
                if (ligne.contains("Nombre disponible : 0")) { // Si la ligne contient Nombre disponible : 0, le livre n'est pas disponible
                    livre_Disponible = false;
                    continue;
                }
                if (!livre_Disponible) {// Si le livre n'est pas disponible, copie la ligne dans le fichier de destination
                    writer.write(ligne);
                    writer.newLine();
                }
                if (ligne.startsWith("Catégorie : ")) {
                    livre_Disponible = true; // Réinitialise le drapeau
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

