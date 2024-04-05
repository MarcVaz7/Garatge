package Practica_cotxes;

import java.util.Scanner;

public class FunRace {

    //Arxiu que contè la funció de cursa on s'escull un rival aleatori d'entre els que hi ha al array, posteriorment es calcula el temps que es triga 
    //en arribar a 200 km/h, el que tingui el valor més baix és el guanyador
    
    public static void Race(Scanner esc, ObCar[] cotxe) {
        System.out.println("===============================================================================");
        System.out.println("MODE CURSA");
        System.out.println("===============================================================================");
        boolean exit2 = true;
        int op = 0;
        int min = 0;
        int max = 0;
        int resultat = -1;
        int rival = -1;
        int mig = 0;
        String marca = "";
        String model = "";
        String marcaR = "";
        String modelR = "";
        System.out.println("Benvingut al mode pilotatge!");
        System.out.println("Escull si vols un rival aleatori o si el vols escollir tu");
        System.out.println("1 - Rival random");
        System.out.println("2 - Rival escollit");
        Funcar.NumCheck(esc); //Comprovem que el que s'escriu un numero
            op = esc.nextInt();
            
            while (op != 1 && op != 2) {
                System.out.println("Escriu un numero entre 1 i 3");
                Funcar.NumCheck(esc);
                op = esc.nextInt();
            }
        switch(op){
            case 1: FunRace.RandomR(esc, cotxe, marca, model, min, max, resultat, mig, exit2, rival);
                break;
            case 2: FunRace.SelectR(esc, cotxe, marca, model, modelR, marcaR, min, max, resultat, rival, mig, exit2);
                break;
        }
        
    }
    public static void RandomR(Scanner esc, ObCar[] cotxe, String marca, String model, int min, int max, int resultat, int mig, boolean exit2, int rival){
    FunGar.Mostrar(esc, cotxe);
        esc.nextLine();
        do {
            do {
                System.out.println("Escull un cotxe");
                System.out.println("============================================================");
                System.out.println("Marca:");
                marca = esc.nextLine(); //Demanem la marca del cotxe
                System.out.println("Model:");
                model = esc.nextLine(); //I el model
                //Inici de la cerca binaria
                min = 0;
                max = cotxe.length - 1;
                resultat = -1;
                
                while (min <= max && resultat == -1) {
                    if (!cotxe[max].getmarca().equalsIgnoreCase("")) {
                        mig = (min + max) / 2;
                        if (cotxe[mig].getmarca().equalsIgnoreCase(marca) && cotxe[mig].getmodel().equalsIgnoreCase(model)) {
                            resultat = mig;
                        } else if (cotxe[mig].getmarca().compareToIgnoreCase(marca) < 0) {
                            min = mig + 1;
                        } else if (cotxe[mig].getmarca().compareToIgnoreCase(marca) > 0) {
                            max = mig - 1;
                        } else if (cotxe[mig].getmarca().compareToIgnoreCase(marca) == 0 && cotxe[mig].getmodel().compareToIgnoreCase(model) < 0) {
                            min = mig + 1;
                        } else {
                            max = mig - 1;
                        }
                    } else if (cotxe[max].getmarca().equalsIgnoreCase("")) {
                        max = max - 1;
                    }
                } //Amb aquest while fem servir part de la funció per a poder obtenir una equivalència a la marca i el model del cotxe desitjat

                if (resultat == -1) {
                    System.out.println("El cotxe no està al garatge. Compra'l al mode garatge o escolleix un altre");
                    exit2 = false;
                } else {
                    exit2 = true;
                }
            } while (exit2 == false);
            if (cotxe[resultat].getvelm() < 200) {
                System.out.println("El vehicle que has seleccionat no compleix les regles de la carrera");
            }
        }while(cotxe[resultat].getvelm() < 200); //En el cas de que el vehicle seleccionat no tingui com a velocitat màxima un valor igual o superior a 200 es repetira la selecció de cotxe fins que es seleccioni un que si que ho superi 
        
        //Generarem un numero aleatori per a decidir el rival
        System.out.println("Decidint el teu rival");
        rival = (int) (Math.random() * cotxe.length);
        while (cotxe[rival].getvelm() == 0) { //En el cas de que surti una posició del array que estigui buida es buscarà un nou rival generant un altre numero aleatori
            rival = (int) (Math.random() * cotxe.length);
        }
        if (cotxe[rival].getvelm() < 200) { //En el cas que el cotxe seleccionat no tingui una velocitat màxima de 200 o més es tornara a generar un numero aleatori
            while (cotxe[rival].getvelm() == 0) {
                rival = (int) (Math.random() * cotxe.length);
            }
        }
        
        System.out.println("===============================================================================");
        System.out.println("El teu rival és el " + Funcar.Blila() + cotxe[rival].getmarca() + " " + cotxe[rival].getmodel() + Funcar.reset());
        System.out.println("===============================================================================");
        int tempsU = 200 / cotxe[resultat].getacc();
        int tempsR = 200 / cotxe[rival].getacc();
        System.out.println(Funcar.Bcian() + "|" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + " |" + Funcar.reset());
        System.out.println(Funcar.Bcian() + "|" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + " |" + Funcar.reset());
        System.out.println(Funcar.Bcian() + "|" + "#" + "_" + "#" + "_" + "#" + "_" + "COMENÇA LA CURSA" + "#" + "_" + "#" + "_" + "#" + " |" + Funcar.reset());
        System.out.println(Funcar.Bcian() + "|" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + " |" + Funcar.reset());
        System.out.println(Funcar.Bcian() + "|" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + " |" + Funcar.reset());
        System.out.println(" ");
        if (tempsU < tempsR) { //Si tempsU és més petit que tempsR vol dir que el rivla triga menys en arribar a 200, per tant guanya el rival
            System.out.println(Funcar.verd() + "EL GUANYADOR ÉS EL " + cotxe[resultat].getmarca() + " " + cotxe[resultat].getmodel() + Funcar.reset());
        } else if (tempsU > tempsR) { //Si tempsU és més gran que tempsR vol dir que ha guanyat el usuari
            System.out.println(Funcar.verd() + "EL GUANYADOR ÉS EL " + cotxe[rival].getmarca() + " " + cotxe[rival].getmodel() + Funcar.reset());
        } else { //Si passa qualsevol altre cosa es dirà que s'ha empatat
            System.out.println(Funcar.Bgroc() + "S'HA PRODUÏT UN EMPAT" + Funcar.reset());
        }
    }
    
    public static void SelectR(Scanner esc, ObCar[] cotxe, String marca, String model, String modelR, String marcaR, int min, int max, int resultat, int rival, int mig, boolean exit2){
    esc.nextLine();
        do {
            FunGar.Mostrar(esc, cotxe);
            do {
                System.out.println("Escull un cotxe");
                System.out.println("============================================================");
                System.out.println("Marca:");
                marca = esc.nextLine();
                System.out.println("Model:");
                model = esc.nextLine();
                min = 0;
                max = cotxe.length - 1;
                resultat = -1;
                
                while (min <= max && resultat == -1) {
                    if (!cotxe[max].getmarca().equalsIgnoreCase("")) {
                        mig = (min + max) / 2;
                        if (cotxe[mig].getmarca().equalsIgnoreCase(marca) && cotxe[mig].getmodel().equalsIgnoreCase(model)) {
                            resultat = mig;
                        } else if (cotxe[mig].getmarca().compareToIgnoreCase(marca) < 0) {
                            min = mig + 1;
                        } else if (cotxe[mig].getmarca().compareToIgnoreCase(marca) > 0) {
                            max = mig - 1;
                        } else if (cotxe[mig].getmarca().compareToIgnoreCase(marca) == 0 && cotxe[mig].getmodel().compareToIgnoreCase(model) < 0) {
                            min = mig + 1;
                        } else {
                            max = mig - 1;
                        }
                    } else if (cotxe[max].getmarca().equalsIgnoreCase("")) {
                        max = max - 1;
                    }
                }

                if (resultat == -1) {
                    System.out.println("El cotxe no està al garatge. Compra'l al mode garatge o escolleix un altre");
                    exit2 = false;
                } else {
                    exit2 = true;
                }
            } while (exit2 == false);
            if (cotxe[resultat].getvelm() < 200) {
                System.out.println("El vehicle que has seleccionat no compleix les regles de la carrera");
            }
        }while(cotxe[resultat].getvelm() < 200);
        
    //Ara fem la cerca binaria per a escollir el rival
    do {
        FunGar.Mostrar(esc, cotxe);
            do {
                System.out.println("Escull un cotxe");
                System.out.println("============================================================");
                System.out.println("Marca:");
                marcaR = esc.nextLine(); 
                System.out.println("Model:");
                modelR = esc.nextLine(); 
                min = 0;
                max = cotxe.length - 1;
                rival = -1;
                
                while (min <= max && rival == -1) {
                    if (!cotxe[max].getmarca().equalsIgnoreCase("")) {
                        mig = (min + max) / 2;
                        if (cotxe[mig].getmarca().equalsIgnoreCase(marcaR) && cotxe[mig].getmodel().equalsIgnoreCase(modelR)) {
                            rival = mig;
                        } else if (cotxe[mig].getmarca().compareToIgnoreCase(marcaR) < 0) {
                            min = mig + 1;
                        } else if (cotxe[mig].getmarca().compareToIgnoreCase(marcaR) > 0) {
                            max = mig - 1;
                        } else if (cotxe[mig].getmarca().compareToIgnoreCase(marcaR) == 0 && cotxe[mig].getmodel().compareToIgnoreCase(modelR) < 0) {
                            min = mig + 1;
                        } else {
                            max = mig - 1;
                        }
                    } else if (cotxe[max].getmarca().equalsIgnoreCase("")) {
                        max = max - 1;
                    }
                }

                if (rival == -1) {
                    System.out.println("El cotxe no està al garatge. Compra'l al mode garatge o escolleix un altre");
                    exit2 = false;
                } else {
                    exit2 = true;
                }
            } while (exit2 == false);
            if (cotxe[rival].getvelm() < 200) {
                System.out.println("El vehicle que has seleccionat no compleix les regles de la carrera");
            }
        }while(cotxe[rival].getvelm() < 200);
    
        System.out.println("===============================================================================");
        System.out.println("El teu rival és el " + Funcar.Blila() + cotxe[rival].getmarca() + " " + cotxe[rival].getmodel() + Funcar.reset());
        System.out.println("===============================================================================");
        int tempsU = 200 / cotxe[resultat].getacc();
        int tempsR = 200 / cotxe[rival].getacc();
        System.out.println(Funcar.Bcian() + "|" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + " |" + Funcar.reset());
        System.out.println(Funcar.Bcian() + "|" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + " |" + Funcar.reset());
        System.out.println(Funcar.Bcian() + "|" + "#" + "_" + "#" + "_" + "#" + "_" + "COMENÇA LA CURSA" + "#" + "_" + "#" + "_" + "#" + " |" + Funcar.reset());
        System.out.println(Funcar.Bcian() + "|" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + " |" + Funcar.reset());
        System.out.println(Funcar.Bcian() + "|" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + " |" + Funcar.reset());
        System.out.println(" ");
        if (tempsU < tempsR) { //Si tempsU és més petit que tempsR vol dir que el rivla triga menys en arribar a 200, per tant guanya el rival
            System.out.println(Funcar.verd() + "EL GUANYADOR ÉS EL " + cotxe[resultat].getmarca() + " " + cotxe[resultat].getmodel() + Funcar.reset());
        } else if (tempsU > tempsR) { //Si tempsU és més gran que tempsR vol dir que ha guanyat el usuari
            System.out.println(Funcar.verd() + "EL GUANYADOR ÉS EL " + cotxe[rival].getmarca() + " " + cotxe[rival].getmodel() + Funcar.reset());
        } else { //Si passa qualsevol altre cosa es dirà que s'ha empatat
            System.out.println(Funcar.Bgroc() + "S'HA PRODUÏT UN EMPAT" + Funcar.reset());
        }
    
    }
    

}
