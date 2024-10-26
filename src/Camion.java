public class Camion extends Vehicule implements Louable{
    double capaciteDeChargement;
    int nombreEssieux;
    public Camion(int immatriculation) {
        super(immatriculation);
        this.statut= "disponible";
    }
    public Camion(int immatriculation, String marque, String modele, int anneeDeMiseEnServic, double kilométrage, double capaciteDeChargement,
                  int nombreEssieux) {
        super(immatriculation, marque, modele, anneeDeMiseEnServic, kilométrage);
        this.capaciteDeChargement= capaciteDeChargement;
        this.nombreEssieux=nombreEssieux;
    }
    @Override
    public double calculPrixLocation(int nbrjour) {
        final int TARIF= 70000;
        return TARIF*nbrjour;
    }
    public void louer() {
        statut = "loué";
        System.out.println(statut);
    }
    @Override
    public void retourner() {
        statut = "disponible";
    }
    @Override
    public String toString() {
        return "Camion \n Immatricule: "+immatriculation+" ,Marque: "+marque+" ,Modèle: "+modele+" ,Année de mise en service:"+anneeDeMiseEnServic+" ,Kilométrage:"+kilometrage+" ,Capacité de chargement:"+capaciteDeChargement+" ,Nombre d'essieux:"+nombreEssieux;
    }
}
