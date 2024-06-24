/**
 * Classe principale de la SAÉ
 * 
 * @author Étienne André Sergueï Lenglet
 * @since 2021-11-04
 *
 */

public class Principale {

    private static final String[] ELEMENTS_DE_DEBUT = { "ABITEBOUL", "ADLEMAN", "AL-KINDI", "ALUR", "BERNERS-LEE",
            "BOOLE", "BUCHI", "BUTLER", "CLARKE", "CURRY" };
    private static final String[] ELEMENTS_DE_FIN = { "RABIN", "RIVEST", "SHAMIR", "SIFAKIS", "TORVALDS",
            "TURING", "ULLMAN", "VALIANT", "WIRTH", "YAO" };

    // NOTE: pour fichier 10 000
    // private static final String[] ELEMENTS_DE_DEBUT_SUPPR
    // = {"ABBADI", "ABERGEL", "ALIAS", "ALIOUI", "AKKUS", "ALAZARD",
    // "ALLA", "AIDARA", "ABRANTES", "AARAB"};
    // NOTE: pour fichier 1 000
    // private static final String[] ELEMENTS_DE_DEBUT_SUPPR
    // = {"ABADIE", "ABDALLAH", "ABRAHAM", "ADAM", "AFONSO",
    // "ALBERT", "ALEXANDRE", "ALI", "ALIX", "ALLAIN"};
    // NOTE: pour fichier 10 000
    // private static final String[] ELEMENTS_DE_FIN_SUPPR
    // = {"WEIS", "ZANIN", "WERQUIN", "YAGOUBI", "WERNERT",
    // "WAWRZYNIAK", "ZULIANI", "ZAIRE", "WAVRANT", "VILLAR"}; //
    // NOTE: pour fichier 1 000
    // private static final String[] ELEMENTS_DE_FIN_SUPPR
    // = {"WEBER", "WEISS", "WINTERSTEIN", "WOLFF", "YANG",
    // "YILDIRIM", "YILDIZ", "YILMAZ", "ZIEGLER", "ZIMMERMANN"}; //

    // Type des listes, peut etre utile pour factoriser les tests
    private static final int CONTIGUE = 1;
    private static final int CHAINEE = 2;
    private static final int CHAINEE_PLIBRES = 3;

    // Exemple d'utilisation de LectureFichier et remplissage d'une liste
    public static void remplir_liste(ListeTriee liste, String nom_fichier) {
        LectureFichier lf = new LectureFichier(nom_fichier);
        //
        String[] liste_noms = lf.lireFichier();
        for (int i = 0; i < liste_noms.length; i++) {
            liste.adjlisT(liste_noms[i]);
        }

    }

    public static void main(String[] args) {
        System.out.println("Bienvenue !");

        // Exemple d'utilisation de la classe EcritureFichier
        EcritureFichier fichier = new EcritureFichier("resultats.csv");
        fichier.ouvrirFichier();
        fichier.ecrireLigne("liste;operation;emplacement;duree");
        fichier.fermerFichier();

        /** création d'une liste à partir d'un fichier */
        LectureFichier fichierp = new LectureFichier("noms10000.txt");
        ListeTriee lT = new ListeTriee(new ListeProf());
        String[] liste_noms = fichierp.lireFichier();

        for (int i = 0; i < liste_noms.length; i++) {
            lT.adjlisT(liste_noms[i]);

        }
        int count = 0;
        for (int i = 0; i < liste_noms.length; i++) {

            System.out.println(lT.val(i));
            count = count + 1;
        }
        System.out.println("nobre de noms : " + count);

        LectureFichier fichier1 = new LectureFichier("noms10000.txt");
        ListeTriee lChalib = new ListeTriee(new ListeChaineePlacesLibres(10000));
        ListeTriee lCha = new ListeTriee(new ListeChainee(10000));
        ListeTriee lCont = new ListeTriee(new ListeContigue(10000));

        String[] liste_noms1 = fichier1.lireFichier();


        long somme=0;
        for (int i=0;i<100;i++){
        long date_debut1 = System.nanoTime();
        for (int y = 0; i < 10; i++) {
            lChalib.adjlisT(liste_noms1[y]);

        }
        long date_fin1 = System.nanoTime();
        long duree1 = date_fin1 - date_debut1;
        somme = somme + duree1;
        }
        long Moyenne1 =  somme/100;
        System.out.println("duree Moyenne liste chaineeLibre debut : " + Moyenne1);

        somme=0;
        for (int i=0;i<100;i++){
        long date_debut2 = System.nanoTime();
        for (int y = 0; y < 10; y++) {
            lCha.adjlisT(liste_noms1[y]);

        }
        long date_fin2 = System.nanoTime();
        long duree2 = date_fin2 - date_debut2;
        somme = somme + duree2;
        }
        long Moyenne2 =  somme/100;
        System.out.println("duree Moyenne liste chainee debut : " + Moyenne2);




        somme=0;
        for (int i=0;i<100;i++){
        long date_debut3 = System.nanoTime();
        for (int y = 0; y < 10; y++) {
            lCont.adjlisT(liste_noms1[y]);

        }
        long date_fin3 = System.nanoTime();
        long duree3 = date_fin3 - date_debut3;
        somme = somme + duree3;
        }
        long Moyenne3 =  somme/100;
        System.out.println("duree Moyenne liste contigue debut : " + Moyenne3);


        somme=0;
        for (int i=0;i<100;i++){
        long date_debut4 = System.nanoTime();
        for (int y = 9990; y < 10000; y++) {
            lChalib.adjlisT(liste_noms1[y]);

        }
        long date_fin4 = System.nanoTime();
        long duree4 = date_fin4 - date_debut4;
        somme = somme + duree4;
        }
        long Moyenne4 =  somme/100;
        System.out.println("duree Moyenne liste chaineeLibre fin : " + Moyenne4);




        somme=0;
        for (int i=0;i<100;i++){
        long date_debut5 = System.nanoTime();
        for (int y = 9990; y < 10000; y++) {
            lCha.adjlisT(liste_noms1[y]);

        }
        long date_fin5 = System.nanoTime();
        long duree5 = date_fin5 - date_debut5;
         somme = somme + duree5;
        }
        long Moyenne5 =  somme/100;
        System.out.println("duree Moyenne liste chainee fin : " + Moyenne5);



        somme=0;
        for (int i=0;i<100;i++){
        long date_debut6 = System.nanoTime();
        for (int y = 9990; y < 10000; y++) {
            lCont.adjlisT(liste_noms1[y]);

        }
        long date_fin6 = System.nanoTime();
        long duree6 = date_fin6 - date_debut6;
         somme = somme + duree6;
        }
        long Moyenne6 =  somme/100;
        System.out.println("duree Moyenne liste contigue fin : " + Moyenne6);



        somme=0;
        for (int i=0;i<100;i++){
        long date_debut7 = System.nanoTime();
        for (int y = 0; y < 10; y++) {
            lChalib.suplisT(liste_noms1[y]);

        }
        long date_fin7 = System.nanoTime();
        long duree7 = date_fin7 - date_debut7;
         somme = somme + duree7;
        }
        long Moyenne7 =  somme/100;
        System.out.println("duree Moyenne liste chaineeLibre sup debut : " + Moyenne7);



        somme=0;
        for (int i=0;i<100;i++){
        long date_debut8 = System.nanoTime();
        for (int y = 0; y < 10; y++) {
            lCha.suplisT(liste_noms1[y]);

        }
        long date_fin8 = System.nanoTime();
        long duree8 = date_fin8 - date_debut8;
         somme = somme + duree8;
        }
        long Moyenne8 =  somme/100;
        System.out.println("duree Moyenne liste chainee sup debut : " + Moyenne8);



        somme=0;
        for (int i=0;i<100;i++){
        long date_debut9 = System.nanoTime();
        for (int y = 0; y < 10; y++) {
            lCont.suplisT(liste_noms1[y]);

        }
        long date_fin9 = System.nanoTime();
        long duree9 = date_fin9 - date_debut9;
         somme = somme + duree9;
        }
        long Moyenne9 =  somme/100;
        System.out.println("duree Moyenne liste contigue  sup debut : " + Moyenne9);



        somme=0;
        for (int i=0;i<100;i++){
        long date_debut10 = System.nanoTime();
        for (int y = 9990; y < 10000; y++) {
            lChalib.suplisT(liste_noms1[y]);

        }
        long date_fin10 = System.nanoTime();
        long duree10 = date_fin10 - date_debut10;
         somme = somme + duree10;
        }
        long Moyenne10 =  somme/100;
        System.out.println("duree Moyenne liste chaineeLibre sup fin : " + Moyenne10);



        somme=0;
        for (int i=0;i<100;i++){
        long date_debut11 = System.nanoTime();
        for (int y = 9990; y < 10000; y++) {
            lCha.suplisT(liste_noms1[y]);

        }
        long date_fin11 = System.nanoTime();
        long duree11 = date_fin11 - date_debut11;
         somme = somme + duree11;
        }
        long Moyenne11 =  somme/100;
        System.out.println("duree Moyenne liste chainee sup fin : " + Moyenne11);



        somme=0;
        for (int i=0;i<100;i++){
        long date_debut12 = System.nanoTime();
        for (int y = 9990; y < 10000; y++) {
            lCont.suplisT(liste_noms1[y]);

        }
        long date_fin12 = System.nanoTime();
        long duree12 = date_fin12 - date_debut12;
         somme = somme + duree12;
        }
        long Moyenne12 =  somme/100;
        System.out.println("duree Moyenne liste contigue sup fin : " + Moyenne12);

        //création d'un fichier à partir des résultat
        EcritureFichier fichierRes = new EcritureFichier("resultatsListe.csv");
        fichierRes.ouvrirFichier();
        fichierRes.ecrireLigne("listechainnee;ajout;debut;"+Moyenne2+"\n");
        fichierRes.ecrireLigne("listechainee;ajout;fin;"+Moyenne5+"\n");
        fichierRes.ecrireLigne("listechainee;supression;debut;"+Moyenne8+"\n");
        fichierRes.ecrireLigne("listechainee;supression;fin;"+Moyenne11+"\n");
        fichierRes.ecrireLigne("listechaineeLibre;ajout;debut;"+Moyenne1+"\n");
        fichierRes.ecrireLigne("listechaineeLibre;ajout;fin;"+Moyenne4+"\n");
        fichierRes.ecrireLigne("listechaineeLibre;supression;debut;"+Moyenne7+"\n");
        fichierRes.ecrireLigne("listechaineeLibre;supression;fin;"+Moyenne10+"\n");
        fichierRes.ecrireLigne("listecontigue;ajout;debut;"+Moyenne3+"\n");
        fichierRes.ecrireLigne("listecontigue;ajout;fin;"+Moyenne6+"\n");
        fichierRes.ecrireLigne("listecontigue;supression;debut;"+Moyenne9+"\n");
        fichierRes.ecrireLigne("listecontigue;supression;fin;" + Moyenne12+"\n");
        
        fichierRes.fermerFichier();



        /*
         * long date_debut = System . nanoTime () ;
         * 
         * // ici une action dont on mesure le temps
         * 
         * // Fin chronometre
         * long date_fin = System . nanoTime () ;
         * long duree = date_fin - date_debut ;
         */
    }
}
