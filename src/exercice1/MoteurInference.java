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
/*
          ajouter la conclusion aux baseFaits
          Supprimer la regle de la baseRegle (de iter en fait)
*/
            if (counter == regle.getPremisse().length){
                baseFaits.add(regle.getConclusion());
                iter.remove();
            }
        }
        if (!baseFaits.contains(propVerif) && !baseReglesComp.isEmpty()){
            chainageAvantComp(baseFaits, baseReglesComp, propVerif);
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
/*
          ajouter la conclusion aux baseFaits
          Supprimer la regle de la baseRegle
*/
            if (counter == regle.getPremisse().length){
                    if (!baseFaits.contains(regle.getConclusion())){
                        baseFaits.add(regle.getConclusion());
                    }
                    iter.remove();
                }
            }
        return baseFaits;
        }
//  c pour afficher le nombre de recursivite effectue
    private static int c = 0;
    public static boolean chainageArriereComp(ArrayList<String> baseFaits, ArrayList<RegleComposee> baseReglesComp, String propVerif){
        boolean valVerite = true;
        c++;
//  afficher le nombre de recursivite effectue
//-------------------------------------------------------------------------------------------------
        System.out.println("-------------");
        System.out.println(c);
        System.out.println("-------------");
//-------------------------------------------------------------------------------------------------
        System.out.println("propVerif: "+propVerif);
        if (baseFaits.contains(propVerif)){
            System.out.println(propVerif + " existe dans la base des faits");
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
//                c'est juste pour afficher la regle sur le console
//-------------------------------------------------------------------------------------------------
                    for (String st:r.getPremisse()) {
                        System.out.print(st + "-");
                    }
                    System.out.println("->"+r.getConclusion());
//-------------------------------------------------------------------------------------------------
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
