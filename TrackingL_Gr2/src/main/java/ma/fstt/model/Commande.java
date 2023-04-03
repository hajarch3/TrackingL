package ma.fstt.model;

public class Commande {
    private long id_commande;
    private String  date_debut;
    private String date_fin;
    private String km;
    private String client;
    private String etat;

    public Commande(){}

    public Commande(long id_commande, String date_debut, String date_fin, String km, String client, String etat) {
        this.id_commande = id_commande;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.km = km;
        this.client = client;
        this.etat = etat;
    }

    public long getId_commande() {
        return id_commande;
    }

    public void setId_commande(long id_commande) {
        this.id_commande = id_commande;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id_commande=" + id_commande +
                ", date_debut='" + date_debut + '\'' +
                ", date_fin='" + date_fin + '\'' +
                ", km='" + km + '\'' +
                ", client='" + client + '\'' +
                ", etat='" + etat + '\'' +
                '}';
    }
}
