public abstract class Vehicule {
    int immatriculation;
    String marque;
    String modele;
    int anneeDeMiseEnServic;
    double kilometrage;
    String statut;
    public Vehicule(int immatriculation) {
        this.immatriculation = immatriculation;
        this.statut = "disponible";
    }
       public Vehicule(int immatriculation, String marque, String modele, int anneeDeMiseEnServic, double kilometrage) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.anneeDeMiseEnServic = anneeDeMiseEnServic;
        this.kilometrage = kilometrage;
        this.statut = "disponible";
    }
    public abstract double calculPrixLocation(int nbrjour);
    @Override
    public abstract String toString();
}