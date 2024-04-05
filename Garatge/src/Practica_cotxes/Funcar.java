package Practica_cotxes;

import java.util.Scanner;

public class Funcar {
    
//En aquest arxiu java hi ha les funcions generals com per exemple la de comprovar si s'ha escrit un numero.
//També hi ha la funció de garatge on hi ha les opcions de mostrar cotxes, comprar cotxes, vendre cotxes i buscar la plaça.    
 
    public static void NumCheck(Scanner esc) {
        //Funcio que comprova que op sigui un numero
        while (!esc.hasNextInt()) {
            System.out.println("Escriu un numero enter");
            esc.nextLine();
        }
    }

    public static void Garatge(Scanner esc, int op2, ObCar[] cotxe) {
        String noumodel = "";
        String novamarca = "";
        String sell = "";
        int novaspm = 0;
        int novaacc = 0;
        boolean trobar = false;
        boolean exit = false;
        boolean exit2 = false;
        System.out.println("============================================================================================");
        System.out.println("Benvingut al garatge! Aqui podras gestionar els cotxes que hi ha o afgir-ne més.");
        System.out.println("============================================================================================");
        do {
            System.out.println("Que vols fer a continuació?");
            System.out.println("1 - Mostrar cotxes");
            System.out.println("2 - Comprar cotxe");
            System.out.println("3 - Vendre cotxe");
            System.out.println("4 - Buscar plaça de parking del cotxe");
            Funcar.NumCheck(esc);
            op2 = esc.nextInt();
            while (op2 != 1 && op2 != 2 && op2 != 3 && op2 != 4) {
                System.out.println("Escriu un numero entre 1 i 4");
                            Funcar.NumCheck(esc);
                op2 = esc.nextInt();
            }
            String repe = "";
            //Cridem a la funcio Ordenar per a que s'ordeni alfabeticament al inici de la funció garatge
            Funcar.Ordenar(cotxe);
            switch (op2) {
                case 1:
                    FunGar.Mostrar(esc, cotxe);//Cridem la funció que ens permet mostrar el garatge
                    esc.nextLine();
                    break;
                case 2:
                    esc.nextLine();
                    do {  // Do-while que permet executar tantes vegades com es vulgui el cotingut del do, en aquest cas es poder afegir dades noves al objecte cotxe
                        FunGar.Comprar(esc, cotxe, novamarca, noumodel, novaspm, novaacc);//Cridem la funció que ens permet comprar un cotxe nou
                        esc.nextLine();
                        while (exit2 == false) {
                            System.out.println("Vols comprar un altre cotxe?");
                            repe = esc.nextLine();
                            if (repe.equalsIgnoreCase("no")) {
                                exit = true;
                                exit2 = true;
                            } else if (repe.equalsIgnoreCase("si")) {
                                exit = false;
                                exit2 = true;
                            } else {
                                System.out.println("Escriu si o no");
                            }
                        }
                        exit2 = false;
                    } while (exit == false);
                    Funcar.Ordenar(cotxe); //Ordenem els nous vehicles alfabeticament 
                    break;
                case 3:
                    esc.nextLine();
                    do {                        
                        FunGar.Vendre(esc, cotxe, sell, sell, trobar); //Cridem la funció vendre
                        while (exit2 == false) {
                            System.out.println("Vols vendre un altre cotxe?");
                            repe = esc.nextLine();
                            if (repe.equalsIgnoreCase("no")) {
                                exit = true;
                                exit2 = true;
                            } else if (repe.equalsIgnoreCase("si")) {
                                exit = false;
                                exit2 = true;
                            } else {
                                System.out.println("Escriu si o no");
                            }
                        }
                        exit2 = false;
                    } while (exit == false);
                    Funcar.Ordenar(cotxe); //Ordenem els nous vehicles alfabeticament 
                    break;
                case 4:
                    esc.nextLine();
                    do {
                        Funcar.Ordenar(cotxe); //Ordenem l'array
                        FunGar.Plaça(esc, cotxe); //Cridem la funcio de cerca binaria
                        while (exit2 == false) {
                            System.out.println("Vols consultar la plaça d'un altre cotxe?");
                            repe = esc.nextLine();
                            if (repe.equalsIgnoreCase("no")) {
                                exit = true;
                                exit2 = true;
                            } else if (repe.equalsIgnoreCase("si")) {
                                exit = false;
                                exit2 = true;
                            } else {
                                System.out.println("Escriu si o no");
                            }
                        }
                        exit2 = false;
                    } while (exit == false);
                    break;
            }
            exit = false;
            repe = ""; //Posem el valor repe a 0 per evitar possibles errors
            while (exit2 == false) {
                System.out.println("Vols fer alguna altre cosa al garatge?");
                repe = esc.nextLine();
                if (repe.equalsIgnoreCase("no")) {
                    exit = true;
                    exit2 = true;
                } else if (repe.equalsIgnoreCase("si")) {
                    exit = false;
                    exit2 = true;
                } else {
                    System.out.println("Escriu si o no");
                }
            }
            exit2 = false;
        } while (exit == false);

    }

    public static void Ordenar(ObCar[] cotxe) {
        for (int i = 0; i < cotxe.length; i++) {
            for (int j = 0; j < (cotxe.length - 1) - i; j++) {
                if (cotxe[j].getmarca().compareToIgnoreCase(cotxe[j + 1].getmarca()) > 0) {
                    ObCar temp = cotxe[j];
                    cotxe[j] = cotxe[j + 1];
                    cotxe[j + 1] = temp;
                } else if (cotxe[j].getmarca().compareToIgnoreCase(cotxe[j + 1].getmarca()) == 0 && cotxe[j].getmodel().compareToIgnoreCase(cotxe[j + 1].getmodel()) > 0) {
                    ObCar temp = cotxe[j];
                    cotxe[j] = cotxe[j + 1];
                    cotxe[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < cotxe.length; i++) {
            for (int j = 0; j < (cotxe.length - 1) - i; j++) {
                if (cotxe[j].getvelm() == 0) {
                    ObCar temp = cotxe[j];
                    cotxe[j] = cotxe[j + 1];
                    cotxe[j + 1] = temp;
                }
            }
        }
    }

    public static String reset() {
        String reset = "\u001B[0m";
        return reset;
    }

    public static String verd() {
        String Bverd = "\u001B[42m";
        return Bverd;
    }

    public static String Bnegre() {
        String Bnegre = "\u001B[40m";
        return Bnegre;
    }

    public static String Bgroc() {
        String Bgroc = "\u001B[43m";
        return Bgroc;
    }

    public static String Blila() {
        String Blila = "\u001B[45m";
        return Blila;
    }

    public static String Bcian() {
        String Bcian = "\u001B[46m";
        return Bcian;
    }
}
