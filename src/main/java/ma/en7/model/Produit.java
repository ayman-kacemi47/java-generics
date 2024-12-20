package ma.en7.model;

public class Produit {
    private int id;
    private String nom;
     private String description;
     private String marque;
     private double prix;
     private int nbr_stock;

    public Produit() {
    }

    public Produit(int id, String nom, String description, String marque, double prix, int nbr_stock) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.marque = marque;
        this.prix = prix;
        this.nbr_stock = nbr_stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getNbr_stock() {
        return nbr_stock;
    }

    public void setNbr_stock(int nbr_stock) {
        this.nbr_stock = nbr_stock;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", nbr_stock=" + nbr_stock +
                '}';
    }
}
