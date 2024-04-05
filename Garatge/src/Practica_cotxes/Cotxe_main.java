package Practica_cotxes;

import java.util.Scanner;

public class Cotxe_main {
    
//Aquest arxiu és el main on es cridaràn totes les funcions necessaries. 
//Aquí es pot accedir a les 3 funcions, la de garatge, la de mode pilot i la de cursa
    
    public static void main(String[] args) {
        Scanner esc = new Scanner(System.in);
        //Declarem la array que tindra la informació dels primers 6 cotxes, ha de tenir les mateixes caracterísitques que les de l'objecte ObCar
        ObCar[] cotxe = new ObCar[15];
        //Fem aquest for per a inciciar les 15 posicions del array cotxe
        for (int i = 0; i < cotxe.length; i++) {
            cotxe[i] = new ObCar("", "", 0, 0, false, 0);
        }
        //Omplim l'array amb 6 cotxes per defecte
        cotxe[0] = new ObCar("Ford", "Focus SR", 200, 4, false, 0);
        cotxe[1] = new ObCar("Bugatti", "Chiron", 300, 12, false, 0);
        cotxe[2] = new ObCar("McLaren", "720S", 341, 11, false, 0);
        cotxe[3] = new ObCar("Lamborghini", "Huracan Performante", 325, 10, false, 0);
        cotxe[4] = new ObCar("Fiat", "Panda 1986", 100, 3, false, 0);
        cotxe[5] = new ObCar("Honda", "Civic Type R", 272, 8, false, 0);
        Funcar.Ordenar(cotxe);
        int op = 0;
        int op2 = 0;
        String repe;
        System.out.println("Benvingut al garatge de cotxes! A continuació tria on vols anar: ");
        boolean exit = false;
        do {
            boolean exit2 = false;
            System.out.println("1 - Garatge");
            System.out.println("2 - Provar cotxe");
            System.out.println("3 - Carrera");
            Funcar.NumCheck(esc); //Comprovem que el que s'escriu un numero
            op = esc.nextInt();
            while (op != 1 && op != 2 && op != 3) {
                System.out.println("Escriu un numero entre 1 i 3");
                Funcar.NumCheck(esc);
                op = esc.nextInt();
            } //Comprovem que el nombre escrit estigui entre 1 i 3
            switch (op) {
                case 1:
                    Funcar.Garatge(esc, op2, cotxe);
                    break;
                case 2:
                    FunPil.Pilotar(esc, cotxe);
                    break;
                case 3:
                    FunRace.Race(esc, cotxe);
                    break;
            }
            while (exit2 == false) {
                System.out.println("Vols anar a algún altre lloc?");
                repe = esc.nextLine();
                if (repe.equalsIgnoreCase("no")) {
                    exit = true;
                    exit2 = true;
                } else if (repe.equalsIgnoreCase("si")) {
                    exit = false;
                    exit2 = true;
                } else {
                    System.out.println("Escriu si o no.");
                }
            }
            exit2 = false; //Fem reset al boolean per poder fer tantes voltes al codi com volguem
        } while (exit == false);
    }
}
