package ma.fstt.model;

public class Produit {
    private long id_produit;
    private String  nom_produit;
    private String categorie;
    private String prix;
    private String description;

    public Produit(){}

    public Produit(long id_produit, String nom_produit, String categorie, String prix, String description) {
        this.id_produit = id_produit;
        this.nom_produit = nom_produit;
        this.categorie = categorie;
        this.prix = prix;
        this.description = description;
    }

    public long getId_produit() {
        return id_produit;
    }

    public void setId_produit(long id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCatégoreie(String categoreie) {
        this.categorie = categoreie;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id_produit=" + id_produit +
                ", nom_produit='" + nom_produit + '\'' +
                ", categoreie='" + categorie + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                '}';
    }
}
