import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    static Scanner clavier=new Scanner(System.in);
    static ParcAutomobile parc = new ParcAutomobile();
    public static void main(String[] args) throws VehiculeIndisponibleException, ClientNonAutoriseException {
        boolean continuer = true;
        while(continuer){
            System.out.println("\n Menu");
            System.out.println("1.Ajouter un nouveau véhicule au parc."); //ça c'est ok
            System.out.println("2.Ajouter un nouveau client.");
            System.out.println("3.Louer un véhicule.");
            System.out.println("4.Retourner un véhicule.");
            System.out.println("5.Liste des véhicules disponibles.");
            System.out.println("6.Liste des véhicules loués.");
            System.out.println("7.Quitter.");
            int choix= clavier.nextInt();clavier.nextLine();
            switch(choix){
                case 1:
                    ajouterVehicule();
                    break;
                case 2:
                    ajouterClient();
                    break;
                case 3:
                    louerVehicule();
                    break;
                case 4:
                    retournerVehicule();
                    break;
                case 5:
                    listeVehiculeDispo();
                    break;
                case 6:
                    listeVehiculeLoue();
                    break;
                case 7:
                    continuer=false;
                    System.out.println("A bientot!");
                    break;
                default:
                    System.out.println("Option invalide.");
            }
        }
    }

    private static void listeVehiculeLoue() {
        parc.listerVehiculeIndisponible();
    }

    private static void listeVehiculeDispo() {
        parc.listerVehiculesDisponibles();
    }
    private static void retournerVehicule() {
        System.out.println("Veuillez entrer l'immatriculation du véhicule à retourner :");
        int imm = clavier.nextInt(); clavier.nextLine();
        Vehicule vehicule = parc.rechercherVehicule(imm);

        if (vehicule != null) {
            vehicule.retourner();
            System.out.println("Le véhicule a été retourné.");
        } else {
            System.out.println("Véhicule introuvable.");
        }
    }
    private static void louerVehicule() {
        System.out.println("Entrer le nom et prenom du client");
        System.out.println("NOM:");
        String nom = clavier.nextLine();
        System.out.println("PRENOM:");
        String prenom= clavier.nextLine();
        Client client= new Client(nom,prenom);
        try {
            client.StockerLocation();
        } catch (VehiculeIndisponibleException | ClientNonAutoriseException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void ajouterClient() {
        System.out.println("Entrer les informations du client:");
        System.out.println("Nom:");
        String nom= clavier.nextLine();
        System.out.println("Prénom");
        String prenom=clavier.nextLine();
        System.out.println("Numero de permis:");
        int numP= clavier.nextInt();clavier.nextLine();
        System.out.println("Numero de téléphone:");
        int num= clavier.nextInt();clavier.nextLine();
        Client client= new Client(nom,prenom,numP,num);
        System.out.println("Le client "+nom+" "+prenom+" a bien été ajouté");
    }
    private static void ajouterVehicule() {
        System.out.println("Quel type de vehicule souhaitez vous ajouter?");
        System.out.println("1.Voiture");
        System.out.println("2.Camion");
        int choix= clavier.nextInt();  clavier.nextLine();
        Vehicule vehicule;
        switch(choix){
            case 1:
                System.out.println("Entrez les details de la voiture");
                System.out.println("Immatriculation:");
                int imm= clavier.nextInt();clavier.nextLine();
                System.out.println("Marque:");
                String marque=clavier.nextLine();
                System.out.println("Modele:");
                String modele=clavier.nextLine();
                System.out.println("Année de mise en service:");
                int anne=clavier.nextInt();clavier.nextLine();
                System.out.println("Kilometrage:");
                double km=clavier.nextDouble();clavier.nextLine();
                System.out.println("Nombre de places:");
                int nbr=clavier.nextInt();clavier.nextLine();
                System.out.println("Type de carburant(essence,diesel ou electrique):");
                String carb=clavier.nextLine();
                Voiture voiture= new Voiture(imm,marque,modele,anne,km,nbr,carb);
                parc.ajouterVehicule(voiture);

                break;
            case 2:
                System.out.println("Entrez les details du camion");
                System.out.println("Immatriculation:");
                int immC= clavier.nextInt();clavier.nextLine();
                System.out.println("Marque:");
                String marqueC=clavier.nextLine();
                System.out.println("Modele:");
                String modeleC=clavier.nextLine();
                System.out.println("Année de mise en service:");
                int anneC=clavier.nextInt();clavier.nextLine();
                System.out.println("Kilometrage:");
                double kmC=clavier.nextDouble();clavier.nextLine();
                System.out.println("Capacité de chargement:");
                double cap=clavier.nextDouble(); clavier.nextLine();
                System.out.println("Nombre d'essieux:");
                int nbrEC= clavier.nextInt();clavier.nextLine();
                Camion camion= new Camion(immC,marqueC,modeleC,anneC,kmC,cap,nbrEC);
                parc.ajouterVehicule(camion);
                break;
            default:
                System.out.println("Option non valide");
                break;
        }
        System.out.println("Liste de véhicule actuelle:");
        System.out.println(parc.listeVehicules);

    }
}
