import java.util.ArrayList;
public class ParcAutomobile {
    ArrayList<Vehicule> listeVehicules = new ArrayList<>();
    public void ajouterVehicule(Vehicule vehicule) {
        listeVehicules.add(vehicule);
        System.out.println("Le véhicule a bien été enregistré.\n Détail du vehicule: " + vehicule.toString());
    }
    public void listerVehiculesDisponibles() {
        System.out.println("Liste des véhicules disponibles :");
        boolean existe = false;
        for (Vehicule vehicule : listeVehicules) {
            if ("disponible".equalsIgnoreCase(vehicule.statut)) {
                System.out.println(vehicule.toString());
                existe = true;
            }
        }
        if (!existe) {
            System.out.println("Aucun véhicule disponible pour le moment.");
        }
    }
    public void listerVehiculeIndisponible(){
        System.out.println("Liste des véhicules indisponibles :");
        boolean existeC = false;
        for (Vehicule vehicule : listeVehicules) {
            if ("loué".equalsIgnoreCase(vehicule.statut)) {
                System.out.println(vehicule.toString());
                existeC = true;
            }
        }
        if (!existeC) {
            System.out.println("Aucun véhicule loué pour le moment.");
            }
        }
    }
