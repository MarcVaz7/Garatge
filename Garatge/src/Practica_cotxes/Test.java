/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica_cotxes;

import java.util.Scanner;

/**
 *
 * @author marcv
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner esc = new Scanner(System.in);
        //Declarem la array que tindra la informació dels primers 6 cotxes, ha de tenir les mateixes caracterísitques que les de l'objecte ObCar
        ObCar[] cotxe = new ObCar[15];
        //Fem aquest for per a inciciar les 15 posicions del array cotxe
        for (int i = 0; i < cotxe.length; i++) {
            cotxe[i] = new ObCar("", "", 0, 0, false, 0);
        }
        //Omplim l'array amb 6 cotxes per defecte
        cotxe[0] = new ObCar("Aord", "Focus SR", 100, 4, false, 0);
        cotxe[1] = new ObCar("A", "B", 100, 12, false, 0);
        cotxe[2] = new ObCar("McLaren", "720S", 341, 11, false, 0);
        cotxe[3] = new ObCar("Lamborghini", "Huracan Performante", 325, 10, false, 0);
        cotxe[4] = new ObCar("Fiat", "Panda 1986", 100, 2, false, 0);
        cotxe[5] = new ObCar("Honda", "Civic Type R", 272, 8, false, 0);
        cotxe[6] = new ObCar("", "", 0, 0, false, 0);

        System.out.println(cotxe[0].getmarca().compareToIgnoreCase(cotxe[1].getmarca()));
        System.out.println(cotxe[1].getmarca().compareToIgnoreCase(cotxe[0].getmarca()));
Funcar.Ordenar(cotxe);
        System.out.println("|" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + " |");
        System.out.println("|" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + " |");
        System.out.println("|" + "#" + "_" + "#" + "_"+"#" + "_"  + "COMENÇA LA CURSA" + "#" + "_" + "#" + "_" + "#"  + "|");
        System.out.println("|" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + " |");
        System.out.println("|" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + "_" + "#" + " |");
        System.out.println("1 - Alt");
        System.out.println("2 - Bibe");
        boolean num = esc.hasNextInt();
        while(!num){
            System.out.println("Escriu un numero");
            
        }
        int op = esc.nextInt();
        
        
    }  

}
