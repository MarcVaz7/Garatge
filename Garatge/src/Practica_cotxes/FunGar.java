package Practica_cotxes;

import java.util.Scanner;

public class FunGar {

//Arxiu java on hi ha totes les funcions de la opció del garatge.
//Hi ha la opció on es mostren tots els cotxes, l'opció de comprar cotxes nous, l'opció de vendre els cotxes i 
//finalment l'opció de veure la plaça on està el cotxe
    
    public static void Mostrar(Scanner esc, ObCar[] cotxe) {
        System.out.println(Funcar.Bgroc() + "GARATGE" + Funcar.reset());
        //Iniciem un for per a la funcio 1 del switch, on s'ha de mostrar el contingut de cotxe actual ordenat alfabeticament. 
        for (int i = 0; i < cotxe.length; i++) {
            if (cotxe[i].getvelm() != 0) {
                //Amb aquest if aconseguim que es mostrin les dades dels vehicles que estiguin iniciats
                System.out.println("Marca: " + cotxe[i].getmarca());
                System.out.println("Model: " + cotxe[i].getmodel());
                System.out.println("Velocitat màxima: " + cotxe[i].getvelm());
                System.out.println("Acceleració: " + cotxe[i].getacc());
                System.out.println("===============================================================");
                //Cridem totes les funcions get per a obtenir el valor de la posició "i" del objecte cotxe.    
            } else {
                //En el cas que es trobi un valor igual a 0 fem que i tingui el mateix valor que la longitud de l'array cotxe, així com previament han estat ordenats alfabeticament, no mostrara les posicions que estan buides.
                i = cotxe.length;
            }
        }
    }

    public static void Comprar(Scanner esc, ObCar[] cotxe, String novamarca, String noumodel, int novaspm, int novaacc) {
        System.out.println("=============================================");
        System.out.println("Compra el vehicle dels teus somnis!");
        System.out.println("=============================================");
        if (cotxe[cotxe.length - 1].getvelm() == 0) { //If que es durà a terme en el cas que els valors de l'últim cotxe sigui 0, ja que això voldrà dir que hi han espais lliures per omplir
            System.out.println("Marca del cotxe: ");
            novamarca = esc.nextLine();
            System.out.println("Model del cotxe: ");
            noumodel = esc.nextLine();
            System.out.println("Velocitat màxima: ");
            Funcar.NumCheck(esc);
            novaspm = esc.nextInt();
            System.out.println("Accelarció: ");
            Funcar.NumCheck(esc); //Cridem la funció NumCheck per assegurar-nos que s'ha introduït un numero
            novaacc = esc.nextInt();
        } else {
            System.out.println("El garatge està ple, has de vendre un cotxe abans de comprar un nou.");
        }
        if (cotxe[cotxe.length - 1].getvelm() != 0) {//Amb el if contemplem la possibilitat de que totes les posicions estiguin ocupades
            System.out.println("El garatge està ple, ven algún cotxe per poder-ne comprar un de nou");
        } else {
            for (int i = 0; i < cotxe.length; i++) {
                if (cotxe[i].getvelm() == 0) { //Si el valor dels parametres del cotxe en la posicio "i" es 0 s'omplira amb els valors que s'han demanat prèviament
                    cotxe[i].setmarca(novamarca);
                    cotxe[i].setmodel(noumodel);
                    cotxe[i].setvelm(novaspm);
                    cotxe[i].setacc(novaacc);
                    //Cridem totes les funcions "set" necessaries per a assignar els valors que prèviament hem fet servir
                    i = cotxe.length; //Finalment fem que es surti del loop perquè si no es fa s'omplirien totes les posicions buides amb les maeixes dades
                }
            }
            System.out.println("Has comprat un " + Funcar.Bgroc() + novamarca + " " + noumodel + Funcar.reset() + " felicitats!");
        }

    }

    public static void Vendre(Scanner esc, ObCar[] cotxe, String sell, String sellmod, boolean trobar) {
        System.out.println("=============================================");
        System.out.println("Venda de cotxes.");
        System.out.println("=============================================");
        if (cotxe[0].getvelm() == 0) { //Amb aquest if-else comprovem que el parking no estigui buit
            System.out.println("El parking està buit.");
        } else {
            System.out.println("Quin cotxe vols vendre?");
            System.out.println("Marca: ");
            sell = esc.nextLine();
        } //Si no esta buit es demana la marca d'un cotxe
        System.out.println("Model: ");
        sellmod = esc.nextLine();
        for (int i = 0; i < cotxe.length; i++) {
            if (cotxe[i].getmarca().equalsIgnoreCase(sell) && cotxe[i].getmodel().equalsIgnoreCase(sellmod)) { //Aquest if comprova que la paraula escrita a sell consti al array
                cotxe[i].setmarca("");
                cotxe[i].setmodel("");
                cotxe[i].setvelm(0);
                cotxe[i].setacc(0);
                trobar = true;
                System.out.println("=============================================");
                System.out.println("El cotxe s'ha vengut amb èxit!");
                System.out.println("=============================================");
            } else if ((i == cotxe.length - 1) && trobar == false) { //Si no consta al array i trobar es false voldrà dir que el cotxe no esta en el garatge
                System.out.println("El cotxe no esta en el garatge");
            }
            if (trobar == true) { //Amb aquest "if" fem que no es recorri tota la array
                if (i == cotxe.length - 1) { //Aquest if fara que el loop pari si la i actual està a la ultima posició
                    i = cotxe.length;
                } else if (cotxe[i + 1].getmodel().equals("")) { //En el cas que la següent posició de "i" a la actual estigui buida, fem que el loop pari 
                    i = cotxe.length;
                } else { //Sinó fem una reordenació dels parametres restants.
                    ObCar car = cotxe[i];
                    cotxe[i] = cotxe[i + 1];
                    cotxe[i + 1] = car;
                }
            }
        }
    }

    public static void Plaça(Scanner esc, ObCar[] cotxe) {
        int min;
        int max;
        int resultat;
        int mig;
        String marca = "";
        String model = "";
        //Declarem els valors que es faràn servir al llarg d'aquesta funció
        System.out.println("=============================================");
        System.out.println("Troba la plaça del teu cotxe!");
        System.out.println("=============================================");

        System.out.println("Digues la marca del cotxe:");
        marca = esc.nextLine(); //Demanem la marca del cotxe
        System.out.println("Digues el model del cotxe:");
        model = esc.nextLine(); //I el model
        min = 0;
        max = cotxe.length - 1;
        resultat = -1;
        //Determinem els valors de les variables on "min" serà equivalent a on volem que es comenci a buscar a la serca binaria
        //"max" sera sempre el final de l'array 
        //"resultat" per començar sempre ha de tenir el valor -1
        while (min <= max && resultat == -1) { //Amb el while assegurem que es faci la cerca si el min és igual o més petit que el max i només si el resultat és -1; és a dir només si encara no s'a trobat la plaça
            if (!cotxe[max].getmarca().equalsIgnoreCase("")) { //Aquest if és import sempre que l'array no esta ple del tot i te slots buits. En el cas de que no en tingui durà a terme la cerca binaria
                mig = (min + max) / 2; //Determinem que "mig" es el valor de la mitja inicial
                if (cotxe[mig].getmarca().equalsIgnoreCase(marca) && cotxe[mig].getmodel().equalsIgnoreCase(model)) { //Aquest if permet que si el que s'està buscant es troba a la posició mig ja no es faci res més 
                    resultat = mig;
                } else if (cotxe[mig].getmarca().compareToIgnoreCase(marca) < 0) { //Aquest else if assegura que si el valor de la comparació és més petit que 0, el min ha de ser equivalent al manor mig més 1
                    min = mig + 1; // Com que la comparació ha donat un nombre negatiu, sabem que el cotxe que busquem no es troba a l'esquerra del valor mig, per tant fem que el mínim sigui el nou valor mig + 1. Aquest + 1 es posa ja que el "mig" inicial també havia estat comprovat
                } else if (cotxe[mig].getmarca().compareToIgnoreCase(marca) > 0) { //Per altre banda si la comparació dona un valor positiu més gran que 0 s'ha de donar el valor mig menys 1 al "max" 
                    max = mig - 1; //Otorguem el valor mig menys 1 al máxim ja que el que estem cercant es troba a la esquerra del valor mig
                } else if (cotxe[mig].getmarca().compareToIgnoreCase(marca) == 0 && cotxe[mig].getmodel().compareToIgnoreCase(model) < 0) { //En el cas que la comparació de les marques siqui 0 vol dir que la marca esta repetida, per tant s'ha de comparar amb el model
                    min = mig + 1;
                } else {
                    max = mig - 1;
                }
            } else if (cotxe[max].getmarca().equalsIgnoreCase("")) { //En el cas que en els valors de l'array en la posició màxima sigui 0 o estigui buida es restarà 1 al valor màxim 
                max = max - 1;
            }
        }
        if (resultat != -1) { //Si el valor del resutlat ha variat i és diferent a -1 s'entra al if
            System.out.println("El teu " + Funcar.Bgroc() + marca + Funcar.reset() + " model " + Funcar.Bgroc() + model + Funcar.reset() + " es troba a la plaça " + Funcar.Bgroc() + resultat + Funcar.reset() + " del parking."); //S'imprimeix el valor de la plaça de parking
            System.out.println("=============================================");
            System.out.println("La seva velocitat màxima és de " + cotxe[resultat].getvelm());
            System.out.println("La seva acceleració és de " + cotxe[resultat].getacc());
            System.out.println("=============================================");

        } else if (resultat == - 1) { //Si el resultat no ha canviat vol dir que el cotxe no es troba en el parking i, per tant, entra al else if
            System.out.println("El cotxe no esta al parking.");
            System.out.println("=============================================");

            System.out.println("Pots comprarlo a la secció de concessionari de cotxes.");
            System.out.println("=============================================");

        }

    }
}
