public class Voiture extends Vehicule implements Louable {


    int nombreDePlaces;
    String typeDeCarburant;
    public Voiture(int immatriculation) {
        super(immatriculation);
        this.statut="disponible";
    }
    public Voiture(int immatriculation, String marque, String modele, int anneeDeMiseEnServic, double kilométrage, int nombreDePlaces, String typeDeCarburant) {
        super(immatriculation, marque, modele, anneeDeMiseEnServic, kilométrage);
        this.nombreDePlaces = nombreDePlaces;
        this.typeDeCarburant = typeDeCarburant;
    }
    @Override
    public double calculPrixLocation(int nbrjour) {
        final int TARIF=30000;
        return TARIF*nbrjour;
    }
    @Override
    public void louer(){
        statut = "loué";
    }
     @Override
    public void retourner() {
        statut = "disponible";
    }
         @Override
    public String toString() {
        return "Voiture \n Immatricule:"+immatriculation+" ,Marque:"+marque+" ,Modèle:"+modele+" ,Année de mise en service:"+anneeDeMiseEnServic+" ,Kilométrage:"+kilometrage+" ,Nombre de place:"+nombreDePlaces+" ,Type de carburant:"+typeDeCarburant;
    }
}
