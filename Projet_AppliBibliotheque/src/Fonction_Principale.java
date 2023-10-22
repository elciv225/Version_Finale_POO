import java.util.Scanner;

public class Fonction_Principale {

    public static void page_utilisateur(){
        System.out.println("\n\n\t\t\tBienvenue "+ Principale.user+"\n");
        Fonctions_page_utili.fonction_Utilisateur();
    }

    public static void  page_administrateur(){
        Scanner scanner = new Scanner(System.in);
        String mdp;
        System.out.println("\n\n\t\tVous etes sur la page administrateur\n");
        System.out.print("Entrez le mot de passe pour avoir acces aux fonction\nATTENTION VOUS AVEZ SEULEMENT DROIT A 3 ESSAIS\n\nEntrez le code : ");
        for (int i = 1; i <= 3; i++){
            mdp = scanner.next();
            if(mdp.equals("bibli23")){
                System.out.println("\nLe mot de passe est CORRECT");
                Fonctions_page_admin.fonction_Administrateur();
                break;
            }else {
                System.err.print("Le mot de passe est INCORRECT");
                if (i < 3){
                    System.out.print(" Il vous reste "+(3-i)+"/3 essais\nEntrez le code : ");
                }
            }
        }
    }

}
