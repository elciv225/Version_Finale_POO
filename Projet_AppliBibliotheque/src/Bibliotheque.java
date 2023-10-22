import java.util.ArrayList;
import java.time.LocalDate;

public class Bibliotheque{
//Constructeur vide
    public Bibliotheque(){}
//Variables
    private String auteur;
    private String titre;
    private String categorie;
    private int nbre_Disposible;
    private String nom_Emprunteur;
    private String anniversaire_Emprunteur;
    private LocalDate date_emprunt;
//Listes ArrayList
    public static ArrayList<Bibliotheque> liste_livre_admin = new ArrayList<>(10000);
    public static ArrayList<Bibliotheque> liste_emprunteur = new ArrayList<>(10000);
//Getters
    public String getAuteur() {
        return auteur;
    }
    public String getTitre() {
        return titre;
    }
    public String getCategorie() {
        return categorie;
    }
    public int getNbre_Disposible() {
        return nbre_Disposible;
    }
    public String getNom_Emprunteur() {
        return nom_Emprunteur;
    }
    public String getAnniversaire_Emprunteur() {
        return anniversaire_Emprunteur;
    }
    public LocalDate getDate_emprunt() {
        return date_emprunt;
    }
//Setter
    public void setNbre_Disposible(int nbre_Disposible) {
        this.nbre_Disposible = nbre_Disposible;
    }
// Construteurs
    public Bibliotheque(String auteur, String titre, String categorie, int nbre_Disposible) {
        this.auteur = auteur;
        this.titre = titre;
        this.categorie = categorie;
        this.nbre_Disposible = nbre_Disposible;
    }
    public Bibliotheque(String nom_Emprunteur, String anniversaire_Emprunteur, String titre, String auteur,LocalDate date_emprunt) {
        this.auteur = auteur;
        this.titre = titre;
        this.nom_Emprunteur = nom_Emprunteur;
        this.anniversaire_Emprunteur = anniversaire_Emprunteur;
        this.date_emprunt = date_emprunt;
    }
}






