package exercice1;

import exercice2.RegleComposee;

import java.util.ArrayList;

public class MainAvant {
    public static void main(String[] args) {
//  Exercice2 TP1 - TP2 ------------------------------------------------------------------------------------
        RegleComposee rc_1 = new RegleComposee("A&B","C");
        RegleComposee rc_2 = new RegleComposee("C&D","F");
        RegleComposee rc_3 = new RegleComposee("F&B","E");
        RegleComposee rc_4 = new RegleComposee("F&A","G");
        RegleComposee rc_5 = new RegleComposee("G&F","B");

        ArrayList<RegleComposee> bR2 = new ArrayList<>();
        bR2.add(rc_1);  bR2.add(rc_2);  bR2.add(rc_3);  bR2.add(rc_4);  bR2.add(rc_5);

        ArrayList<String> bF2 = new ArrayList<>();
        bF2.add("A"); bF2.add("C"); bF2.add("D");

        System.out.println("Exercice2 Chainage Avant");
        System.out.println(MoteurInference.chainageAvantComp(bF2, bR2, "F"));

    }
}
