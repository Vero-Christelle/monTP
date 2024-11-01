import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    String nom;
    String prenom;
    int numeroDePermis;
    int numeroDeTel;

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Client(String nom, String prenom, int numeroDePermis, int numeroDeTel) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroDePermis = numeroDePermis;
        this.numeroDeTel = numeroDeTel;
    }

    ArrayList<Vehicule> listeLocation = new ArrayList<>();
    Scanner clavier = new Scanner(System.in);
    public void StockerLocation()throws VehiculeIndisponibleException, ClientNonAutoriseException{
        boolean continuer=true;
        while(continuer){
            System.out.println("voulez vous ajouter une location?");
            System.out.println("1.oui");
            System.out.println("2.non");
            int rep = clavier.nextInt(); clavier.nextLine();
            switch(rep){
                case 1:
                    AjouterLocation();
                    break;
                case 2:
                    continuer=false;
                    break;
                default:
                    System.out.println("Option non valide");
                    break;
            }
        }
    }
    public void AjouterLocation()throws VehiculeIndisponibleException, ClientNonAutoriseException{
        System.out.println("Souhaitez vous louer une voiture ou un camion?");
        System.out.println("1.voiture");
        System.out.println("2.camion");
        int choix=clavier.nextInt();clavier.nextLine();
        System.out.println("Entrer l'immatricule du véhicule.");
        int imm= clavier.nextInt();clavier.nextLine();
        Vehicule vehicule = Main.parc.rechercherVehicule(imm);
        switch(choix){
            case 1:
                if ("loué".equalsIgnoreCase(vehicule.statut)) {
                        throw new VehiculeIndisponibleException("La voiture est déjà loué.");
                } else {
                    vehicule.louer();
                    listeLocation.add(vehicule);
                    System.out.println("La location a été effectué");
                }
                break;
            case 2:
                System.out.println("Le client a t-il le permis adequat pour conduire un camion?");
                System.out.println("1.NON");
                System.out.println("2.OUI");
                int rep= clavier.nextInt();clavier.nextLine();

                switch (rep) {
                    case 1:
                        throw new ClientNonAutoriseException("Le client n'a pas le permis adequate,il ne peut pas louer un camion");
                    case 2:
                        if ("loué".equalsIgnoreCase(vehicule.statut)) {
                            throw new VehiculeIndisponibleException("Le camion est déjà loué.");
                        } else {
                            vehicule.louer();
                            listeLocation.add(vehicule);
                            System.out.println("La location a été effectué");
                        }
                        break;
                    default:
                        System.out.println("Option invalide");
                }
                break;
            default:
                System.out.println("option invalide");
                break;
        }
    }}




