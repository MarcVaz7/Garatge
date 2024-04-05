package Practica_cotxes;

import java.util.Scanner;

public class FunPil {

    //Arxiu de java que contè les funcions necessaries per a realitzar l'opció de pilotar on s'encen el motor, es pot accelerar, es pot frenar,
    // es pot apagar el motor i finalment permet sortir del mode pilot
    
    public static void Pilotar(Scanner esc, ObCar[] cotxe) {
        boolean exit = false;
        boolean exit2 = true;
        int op = 0;
        int min;
        int max;
        int resultat;
        int mig;
        String marca;
        String model;
        System.out.println("Benvingut al mode pilotatge!");
        FunGar.Mostrar(esc, cotxe);
        esc.nextLine();
        do {
            System.out.println("Escull un dels teus cotxes del garatge");
            System.out.println("Marca:");
            marca = esc.nextLine(); //Demanem la marca del cotxe
            System.out.println("Model:");
            model = esc.nextLine(); //I el model
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
            if (resultat == -1) { //En el cas que el resultat sigui -1 s'informarà que el cotxe no està al garatge i per tant s'haurà d'escollir de nou
                System.out.println("El cotxe no està al garatge. Compra'l al mode garatge o escolleix un altre");
                exit2 = false;
            } else {
                exit2 = true;
            }
        } while (exit2 == false);
        do {
            System.out.println("Dins el cotxe");
            System.out.println("Opcions a fer: ");
            System.out.println("1 - Arrencar");
            System.out.println("2 - Accelerar");
            System.out.println("3 - Frenar");
            System.out.println("4 - Aturar motor");
            System.out.println("5 - Sortir del cotxe");
            Funcar.NumCheck(esc);
            op = esc.nextInt();
            while (op != 1 && op != 2 && op != 3 && op != 4 && op != 5) {
                System.out.println("Escriu un numero entre 1 i 5");
                Funcar.NumCheck(esc);
                op = esc.nextInt();
            }
            switch (op) {
                case 1:
                    FunPil.Arrencar(esc, cotxe, resultat); //Es crida la funció d'arrencar
                    break;
                case 2:
                    FunPil.Acc(esc, cotxe, resultat); //Es crida la funció d'accelerar
                    break;
                case 3:
                    FunPil.Fren(esc, cotxe, resultat); //Es crida la funció de frenar
                    break;
                case 4:
                    FunPil.Atu(esc, cotxe, resultat); //Es crida la funció d'aturar el motor
                    break;
                case 5:
                    if (cotxe[resultat].geton() == false) { //En el cas de que "on" sigui false (el motor estaria apagat) exit es true i per tant es surt del while 
                        exit = true;
                    } else {
                        System.out.println("El motor encara esta ences, apaga el motor abans de marxar");
                    } //Si per contra "on" segueix en true (el motor està ences) 
                    break;
            }
        } while (exit == false);
        esc.nextLine();
    }

    public static void Arrencar(Scanner esc, ObCar[] cotxe, int resultat) {
        cotxe[resultat].seton(true); //Posem el valor on en true per representar que el motor s'ha ences
        System.out.println("Motor ences");
    }

    public static void Acc(Scanner esc, ObCar[] cotxe, int resultat) {
        int velact = cotxe[resultat].getvela(); //Variable amb la valocitat actual del cotxe
        int acce = cotxe[resultat].getacc(); //Variable amb l'acceleració del cotxe
        int velmax = cotxe[resultat].getvelm(); //Variable amb la velocitat màxima del cotxe
        int resta; //Variable on anirà la diferencia de velocitat que queda per assolir la velocitat màxima
        boolean stop = false; //Variable per sortir del while
        if (cotxe[resultat].geton() == true) { //Només es realitzarà el contingut del if si "on" és true
                System.out.println("Accelerar: 'W'");
                System.out.println("Per sortir del mode acceleració frena una vegada amb 'S' ");
            while (stop == false) { //Mentres "stop" sigui false es farà el while sense parar               
                String go = esc.nextLine(); //Es demana al usuari que escrigui "w" o "s" per accelerar o frenar
                if (go.equalsIgnoreCase("w")) { //Si el usuari ha escrit "W" s'executarà el contingut del if
                    int vel = velact + acce; //Es crea una variable que es equivalent a la suma de la velocitat actual sumada a la acceleració
                    if (vel >= cotxe[resultat].getvelm()) {//Si la "vel" és més gran que la velocitat màxima s'executa el if
                        resta = velmax - velact; //La diferència de la velocitat màxima i la velocitat actual
                        cotxe[resultat].setvela(velact + resta); //Es suma a la velocitat actual el que falta per assolir la velocitat màxima per evitar que es sobrepassi aquesta
                        System.out.println("Velocitat màxima assolida, no es pot accelerar més");
                        stop = true; //Com que ja s'ha assolit la velocitat màxima "stop" passa a ser true i es surt del while
                    } else if (vel < cotxe[resultat].getvelm()) { //Si "vel" és més petita que la velocitat màxima s'executa el contingut del else if
                        velact = vel; //S'actualitza la velocitat actual
                        cotxe[resultat].setvela(velact); //S'actualitza la "vela" amb la suma de la "velact" i la "acce"
                        System.out.println(cotxe[resultat].getvela());
                    }
                } else if (go.equalsIgnoreCase("s")) { //Si el usuari escriu "s" es surt del while
                    stop = true;
                } else if (!go.equalsIgnoreCase("W") || !go.equalsIgnoreCase("S")) {
                    System.out.println("Accelera escribint 'W'");
                }
            }

        } else { //En el cas que "on" sigui false s'informarà al usuari
            System.out.println("El cotxe esta aturat, per accelerar primer l'has d'encendre");
        }
    }

    public static void Fren(Scanner esc, ObCar[] cotxe, int resultat) {
        //Aquesta funció és molt semblant a l'anterior però restant sempre 20
        int velact = cotxe[resultat].getvela();
        int velmax = cotxe[resultat].getvelm();
        int resta;
        boolean stop = false;
        if (cotxe[resultat].geton() == true) {
            System.out.println("Frenar: S");
            System.out.println("Per sortir del mode frenar accelera una vegada amb 'W'");
            while (stop == false) {
                String go = esc.nextLine();
                if (go.equalsIgnoreCase("s")) {
                    int vel = velact - 20; //Es resta 20 a la veloscitat actual
                    if (vel <= 0) { //Si al "vel" és 0 o més petita que 0 executa el if
                        resta = velmax - velact;
                        cotxe[resultat].setvela(velact + resta);
                        System.out.println("El cotxe ja està aturat, seguir frenant no serveix de res.");
                        if (cotxe[resultat].getvela() != 0) {
                            cotxe[resultat].setvela(0); //En el cas que la velocitat no acabi en 0 la posem nosaltres manualment.
                        }
                        stop = true; //Sortim del while
                    } else if (vel <= cotxe[resultat].getvelm()) {
                        velact = vel;
                        cotxe[resultat].setvela(velact);
                        System.out.println(cotxe[resultat].getvela());
                    }
                } else if (go.equalsIgnoreCase("W")) {
                    stop = true;
                } else if (!go.equalsIgnoreCase("W") || !go.equalsIgnoreCase("S")) {
                    System.out.println("Frena escribint 'S'");
                }
            }

        } else {
            System.out.println("El cotxe esta aturat, per frenar primer has d'accelerar");
        }
    }

    public static void Atu(Scanner esc, ObCar[] cotxe, int resultat) {
        //Funció per posar "on" false (motor aturat)
        if (cotxe[resultat].geton() == false) {
            System.out.println("El cotxe ja està apagat");
        } else {
            if (cotxe[resultat].getvela() == 0) { //En el cas que la "vela" sigui 0 es pot assignar false a "on"
                cotxe[resultat].seton(false);
                System.out.println("Motor apagat");
            } else {
                System.out.println("El cotxe encara esta en moviment, frena del tot per apagar el motor");
            }
        }
    }
}
