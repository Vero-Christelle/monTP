public abstract class Vehicule implements Louable{
    int immatriculation;
    String marque;
    String modele;
    int anneeDeMiseEnServic;
    double kilometrage;
    String statut;
    public void louer() {
        statut = "loué";
        System.out.println(statut);
    }
    @Override
    public void retourner() {
        statut = "disponible";
    }
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