package exercice1;

import exercice2.RegleComposee;

    import java.util.ArrayList;

    public class Main {
        public static void main(String[] args) {
//  Exercice1 ---------------------------------------------------------------------------------------------------
            RegleSimple r1 = new RegleSimple("P","Q");
            RegleSimple r2 = new RegleSimple("Q","R");
            RegleSimple r3 = new RegleSimple("T","R");
            RegleSimple r4 = new RegleSimple("L","M");

            ArrayList<String> bF1 = new ArrayList<>();
            ArrayList<RegleSimple> bR1 = new ArrayList<>();

            bR1.add(r1);
            bR1.add(r4);
            bR1.add(r2);
            bR1.add(r3);

            bF1.add("P");
            System.out.println("Exercice1 chainage avant");
            System.out.println(MoteurInference.chainageAvant(bF1, bR1, "M"));
            System.out.println("Exercice2 chainage arriere");
            System.out.println(MoteurInference.chainageArriere(bF1, bR1, "M"));
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

            System.out.println("Exercice2 Chainage Arriere comp");
            System.out.println(MoteurInference.chainageArriereComp(bF2, bR2, "B"));
            System.out.println("Exercice2 Chainage Avant comp");
            System.out.println(MoteurInference.chainageAvantComp(bF2, bR2, "B"));

//  Exercice3 ---------------------------------------------------------------------------------------------------
            RegleComposee rc1  = new RegleComposee("fleur&graine","phanérogame");
            RegleComposee rc2  = new RegleComposee("phanérogame&graine_nue","sapin");
            RegleComposee rc3  = new RegleComposee("phanérogame&1_cotylédone","monocotylédone");
            RegleComposee rc4  = new RegleComposee("phanérogame&2_cotylédone","dicotylédone");
            RegleComposee rc5  = new RegleComposee("monocotylédone&rhyzome","muguet");
            RegleComposee rc6  = new RegleComposee("dicotylédone","anémone");
            RegleComposee rc7  = new RegleComposee("monocotylédone&non_rhyzome","lilas");
            RegleComposee rc8  = new RegleComposee("feuille&fleur","cryptogame");
            RegleComposee rc9  = new RegleComposee("cryptogame&non_racine","mousse");
            RegleComposee rc10 = new RegleComposee("cryptogame&racine","fougère");
            RegleComposee rc11 = new RegleComposee("non_feuille&plante","thallophyte");
            RegleComposee rc12 = new RegleComposee("thallophyte&chlorophylle","algue");
            RegleComposee rc13 = new RegleComposee("thallophyte&non_chlorophylle","champion");
            RegleComposee rc14 = new RegleComposee("non_feuilles&non_fleur&non_plante","colibacile");

            ArrayList<RegleComposee> bR3 = new ArrayList<>();
            bR3.add(rc1);
            bR3.add(rc2);
            bR3.add(rc3);
            bR3.add(rc4);
            bR3.add(rc5);
            bR3.add(rc6);
            bR3.add(rc7);
            bR3.add(rc8);
            bR3.add(rc9);
            bR3.add(rc10);
            bR3.add(rc11);
            bR3.add(rc12);
            bR3.add(rc13);
            bR3.add(rc14);

            ArrayList<String> bF3 = new ArrayList<>();
            bF3.add("non_feuille");
            bF3.add("chlorophylle");
            bF3.add("fleur");
            bF3.add("graine");
            bF3.add("plante");

//            System.out.println("Exercice3 Chainage Avant");
//            System.out.println(MoteurInference.chainageAvantComp(bF3, bR3));
        }
}
