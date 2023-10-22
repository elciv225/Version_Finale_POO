import java.io.*;

public class Administrateur extends Bibliotheque {

    public Administrateur() {}

    public void afficher_Fichier(String nomFichier) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nomFichier));
            String ligne;
            while ((ligne = reader.readLine()) != null) { // Tant que la ligne n'est pas vide
                System.out.println(ligne); //Affiche la ligne
            }
        } catch (IOException e) { //Exception pouvant se produire lors de la lecture du fichier
            e.printStackTrace();//Affiche les détails de l'exception.
        }
    }

    public void afficher_Livres_NonDisponibles(String nomFichier){
        Parametre_liste parametre_liste = new Parametre_liste();
        parametre_liste.enregistrer_LivresNonDispo("ListeLivresAdmin.txt", nomFichier);
        afficher_Fichier(nomFichier);
    }

    public void ajouter_Livre(Bibliotheque livre){
        Parametre_liste parametre_liste = new Parametre_liste();
        liste_livre_admin.add(livre);
        parametre_liste.enregistrer_FichierTexteAdmin(livre);
        parametre_liste.enregistrer_FichierTexteLecteur(livre);
        parametre_liste.enregistrer_LivresNonDispo("ListeLivresAdmin.txt","ListLivreNonDispo.txt");
    }

    public void retirer_Livre(String titre){
        File fichier = new File("ListeLivresAdmin.txt");
        File fichierTemporaire = new File("FichierTestTemporaire.txt");
        try {
            //Lit le fichier ListeLivresAdmin.txt
            BufferedReader reader = new BufferedReader(new FileReader(fichier));
            //Lit le fichier LFichierTestTemporaire.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter(fichierTemporaire));
            String line;
            boolean supprime = false; //Si false le livre doit être supprimer
            while ((line = reader.readLine()) != null) {
                if (line.contains("Titre : " + titre)) {
                    supprime = true;
                    // On saute les 4 lignes suivantes qui contiennent les détails du livre
                    for (int i = 0; i < 4; i++) {
                        reader.readLine();
                    }
                    continue;
                }
                writer.write(line);
                writer.newLine();
            }
            if (supprime) {
                writer.close();
                reader.close();
                if (fichier.delete()) {
                    if (!fichierTemporaire.renameTo(fichier)) {//renomme le fichier temporaire pour qu'il ait le même nom que le fichier original
                        System.out.println("Impossible de renommer le fichier temporaire.");
                    }
                } else {
                    System.out.println("Impossible de supprimer le fichier original.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


