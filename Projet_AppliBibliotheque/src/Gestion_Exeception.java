import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Gestion_Exeception {
//S'assure que la date est entré au format Année-Mois-Jour
    public static LocalDate format_Date(Scanner scanner) {
        LocalDate date = null;
        boolean valide = false;
        int i = 0;
        while (!valide) {
            try {
                if (i > 0){
                    System.out.print("Entrez votre Date de naissance au format AAAA-MM-JJ : ");
                }
                i++;
                String date_entrer = scanner.next();
                date = LocalDate.parse(date_entrer);
                valide = true;
            } catch (DateTimeParseException e) {
                System.out.println("Format de date incorrect");
            }
        }
        return date;
    }
//S'assure que la date d'anniversaire entré est antérieur à la date du jour
    public static void date_impossible(Scanner scanner){
        LocalDate date_aujourdhui;
        do {
            LocalDate date_entree = format_Date(scanner);
            date_aujourdhui = LocalDate.now();
            if (date_entree.isAfter(date_aujourdhui)){
                System.out.println("Vous avez entree un date plus avance que la date d'aujourd'hui");
                System.out.print("Entrez une date possible au forma AAAA-MM-JJ : ");
            }else {
                break;
            }
        }while (true);
    }
//S'assure que le non de l'utilisateur entré ne contient pas de caractères spéciaux
    public static boolean nom_impossible(String nom){
        return !nom.matches("^[a-zA-Z]+$");
    }
//S'assure qu'une recherche est dans un fichier text
    public  static boolean verification(String nom_Fichier, String donne_verifier){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nom_Fichier));
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                if (ligne.contains(donne_verifier)) {
                    reader.close();
                    return true;
                }
            }
            reader.close(); //ferme le fichier si aucune correspondance n'a été trouvée.
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
