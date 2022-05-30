package exercice1;
import exercice2.RegleComposee;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class MoteurInference {
    public MoteurInference() {
    }
    public static boolean chainageAvant(ArrayList<String> baseFaits, ArrayList<RegleSimple> baseRegles, String propVerif){
//        Creer un iterateur de baseRegles
        ListIterator<RegleSimple> iter = baseRegles.listIterator();
//         verifier que propVerif n'est pas dans baseFaits & baseRegles n'est pas vide
        while (!baseFaits.contains(propVerif) && iter.hasNext()){
//            verifier l'existence du premisse dans les bases des faits
            if (baseFaits.contains(iter.next().getPremisse())){
//                ajouter la conclusion aux baseFaits
                baseFaits.add(iter.next().getConclusion());
//                Supprimer la regle de la baseRegle (de iter en fait)
                iter.remove();
            }
        }
//        vérifier si elle s’est arrêtée parce que la propVerif est retrouvée dans la liste des baseFaits ou non
        return baseFaits.contains(propVerif);
    }
    public static boolean chainageAvantComp(ArrayList<String> baseFaits, ArrayList<RegleComposee> baseReglesComp, String propVerif){
        ListIterator<RegleComposee> iter = baseReglesComp.listIterator();
//      verifier que propVerif n'est pas dans baseFaits & baseRegles n'est pas vide
            while (!baseFaits.contains(propVerif) && iter.hasNext()){
                RegleComposee regle = iter.next();
//          verifier l'existence du premisse dans les bases des faits
                int counter = 0;
                for (int i = 0; i < regle.getPremisse().length; i++) {
                    if (baseFaits.contains(regle.getPremisse()[i])){
                        counter ++;
                    }
                }
//          ajouter la conclusion aux baseFaits
//          Supprimer la regle de la baseRegle (de iter en fait)
                if (counter == regle.getPremisse().length){
                    baseFaits.add(iter.next().getConclusion());
                    iter.remove();
                }
            }
//          vérifier si elle s’est arrêtée parce que la propVerif est retrouvée dans la liste des baseFaits ou non
        return baseFaits.contains(propVerif);
        }
    public static ArrayList<String> chainageAvantComp(ArrayList<String> baseFaits, ArrayList<RegleComposee> baseReglesComp){
        ListIterator<RegleComposee> iter = baseReglesComp.listIterator();
//      verifier que propVerif n'est pas dans baseFaits & baseRegles n'est pas vide
            while (iter.hasNext()){
                RegleComposee regle = iter.next();
//          verifier l'existence du premisse dans les bases des faits
                int counter = 0;
                for (int i = 0; i < regle.getPremisse().length; i++) {
                    if (baseFaits.contains(regle.getPremisse()[i])){
                        counter ++;
                    }
                }
//          ajouter la conclusion aux baseFaits
//          Supprimer la regle de la baseRegle (de iter en fait)
                if (counter == regle.getPremisse().length){
                    baseFaits.add(regle.getConclusion());
                    iter.remove();
                }
            }
        return baseFaits;
        }
    public static boolean chainageArriere(ArrayList<String> baseFaits, ArrayList<RegleComposee> baseReglesComp, String propVerif){
//      vérifier si la PropVerif figure dans la BF, si oui, elle doit retourner true.
        if (baseFaits.contains(propVerif)){
            return true;
//      Sinon, il faut parcourir la BR et vérifier si la PropoVerif figure comme conclusion d’une des règles
        }
        else {
            ListIterator<RegleComposee> iter = baseReglesComp.listIterator();
            ArrayList<RegleComposee> reglesChoisis = new ArrayList<>();
//          Choisir l'ensemble de conflits
            while (iter.hasNext()){
                RegleComposee regle = iter.next();
                if (regle.getConclusion().equals(propVerif)){
                    reglesChoisis.add(regle);
                }
            }
//          Si la règle est trouvée alors la méthode « chainageArrière » doit être appliquée par
//          récursivité sur la prémisse de la règle trouvée et retourner sa valeur de vérité
            if (!reglesChoisis.isEmpty()) {
                for (RegleComposee r : reglesChoisis) {
                    for (String premisse : r.getPremisse()) {
                        chainageArriere(baseFaits, baseReglesComp, premisse);
                    }
//          Si la règle n’est pas trouvée il faut préciser que la règle n’existe pas et que l’utilisateur
//          doit préciser sa valeur de vérité
                }
            } else {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("La règle n’existe pas. Prière de préciser sa valeur de vérité. :)");
                    String valeur = sc.nextLine();
                    return false;
                }
        return true;
        }
    }
}
