import java.util.Scanner;

public class Principale {
//Variable de connexion
    public static String user;
    public static String login;
//Methode principale
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\tBienvenue dans la Bibliotheque\n\t\t\tVeillez vous connecter\n");
        do {
            System.out.print("Entrez votre nom : ");
            user = scanner.next();
            if (Gestion_Exeception.nom_impossible(user)){
                System.out.println("Le nom ne doit pas contenir des chiffres ou des caractères speciaux");
            }
        }while (Gestion_Exeception.nom_impossible(user));
        System.out.print("Entrez votre Date de naissance au format ");
        System.err.print("AAAA-MM-JJ : ");
        login = scanner.next();
        if ((login.equals("2005")) && (user.equals("admin") || user.equals("Admin"))){
            Fonction_Principale.page_administrateur();
        }else {
            System.out.print("Une erreur c'est produite\nEntrez a nouveau votre Date de naissance au format AAAA-MM-JJ : ");
            Gestion_Exeception.date_impossible(scanner);
            Fonction_Principale.page_utilisateur();
        }
    }

}

//567 ligne ahh ouais