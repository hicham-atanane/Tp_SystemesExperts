package exercice1;
import exercice2.RegleComposee;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class MoteurInference {
    public MoteurInference() {
    }
//----------------------------------------------------------------------------------------------------------------------------------------
    private static int reglesRestants0 = 0;
    public static boolean chainageAvant(ArrayList<String> baseFaits, ArrayList<RegleSimple> baseRegles, String propVerif){
        ListIterator<RegleSimple> iter = baseRegles.listIterator();
        while (!baseFaits.contains(propVerif) && iter.hasNext()){
            RegleSimple regle = iter.next();
            if (baseFaits.contains(regle.getPremisse())){
                baseFaits.add(regle.getConclusion());
                iter.remove();
            }

        }
        if (reglesRestants0 != baseRegles.size()){
            reglesRestants0 = baseRegles.size();
            if (!baseFaits.contains(propVerif) && !baseRegles.isEmpty()){
                chainageAvant(baseFaits, baseRegles, propVerif);
            }
        }
//        vérifier si elle s’est arrêtée parce que la propVerif est retrouvée dans la liste des baseFaits ou non
        return baseFaits.contains(propVerif);
    }
//----------------------------------------------------------------------------------------------------------------------------------------
    private static int reglesRestants1 = 0;
    public static boolean chainageAvantComp(ArrayList<String> baseFaits, ArrayList<RegleComposee> baseReglesComp, String propVerif){
        ListIterator<RegleComposee> iter = baseReglesComp.listIterator();
//      verifier que propVerif n'est pas dans baseFaits & baseRegles n'est pas vide
        while (!baseFaits.contains(propVerif) && iter.hasNext()){
            RegleComposee regle = iter.next();
//          verifier l'existence du premisse dans les bases des faits
            boolean bFcontient = true;
            for (int i = 0; i < regle.getPremisse().length; i++) {
                if (!baseFaits.contains(regle.getPremisse()[i])){
                    bFcontient = false;
                    break;
                }
            }
            if (bFcontient){
                baseFaits.add(regle.getConclusion());
                iter.remove();
            }
        }
        if (reglesRestants1 != baseReglesComp.size()){
            reglesRestants1 = baseReglesComp.size();
            chainageAvantComp(baseFaits, baseReglesComp);
        }
        return baseFaits.contains(propVerif);
    }
//    ----------------------------------------------------------------------------------------------------------------------------------------
    private static int reglesRestants2 = 0;
    public static ArrayList<String> chainageAvantComp(ArrayList<String> baseFaits, ArrayList<RegleComposee> baseReglesComp){
        ListIterator<RegleComposee> iter = baseReglesComp.listIterator();
        while (iter.hasNext()){
            RegleComposee regle = iter.next();
            int counter = 0;
            for (int i = 0; i < regle.getPremisse().length; i++) {
                if (baseFaits.contains(regle.getPremisse()[i])){
                    counter ++;
                }
            }
            if (counter == regle.getPremisse().length){
                    if (!baseFaits.contains(regle.getConclusion())){
                        baseFaits.add(regle.getConclusion());
                    }
                    iter.remove();
                }
        }
        if (reglesRestants2 != baseReglesComp.size()){
            reglesRestants2 = baseReglesComp.size();
            chainageAvantComp(baseFaits, baseReglesComp);
        }
        return baseFaits;
    }
//    ----------------------------------------------------------------------------------------------------------------------------------------

    public static boolean chainageArriere(ArrayList<String> baseFaits, ArrayList<RegleSimple> baseRegles, String propVerif){
        boolean valVerite = true;
        if (baseFaits.contains(propVerif)){
            valVerite = true;
        }
        else {
            ListIterator<RegleSimple> iter = baseRegles.listIterator();
            ArrayList<RegleSimple> reglesChoisis = new ArrayList<>();
            while (iter.hasNext()){
                RegleSimple regle = iter.next();
                if (regle.getConclusion().equals(propVerif)){
                    reglesChoisis.add(regle);
                }
            }
            if (!reglesChoisis.isEmpty()) {
                for (RegleSimple r : reglesChoisis) {
                        if (!chainageArriere(baseFaits, baseRegles, r.getPremisse())){
                            valVerite = false;
                            break;
                        }
                    }
                }
            else { valVerite = false;}
        }
        return valVerite;
    }
    public static boolean chainageArriereComp(ArrayList<String> baseFaits, ArrayList<RegleComposee> baseReglesComp, String propVerif){
        boolean valVerite = true;
        if (baseFaits.contains(propVerif)){
            valVerite = true;
        }
        else {
            ListIterator<RegleComposee> iter = baseReglesComp.listIterator();
            ArrayList<RegleComposee> reglesChoisis = new ArrayList<>();
            while (iter.hasNext()){
                RegleComposee regle = iter.next();
                if (regle.getConclusion().equals(propVerif)){
                    reglesChoisis.add(regle);
                }
            }
            if (!reglesChoisis.isEmpty()) {
                for (RegleComposee r : reglesChoisis) {
                    for (String premisse : r.getPremisse()) {
                        if (!chainageArriereComp(baseFaits, baseReglesComp, premisse)){
                            valVerite = false;
                            break;
                        }
                    }
                }
            }
            else { valVerite = false;}
        }
        return valVerite;
    }
}
