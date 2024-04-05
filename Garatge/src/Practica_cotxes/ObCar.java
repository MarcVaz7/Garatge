
package Practica_cotxes;

public class ObCar {
    
    //Arxiu que contè l'objecte del cotxe on es declaren els seus atributs
    
    //Declarem els atributs que tindra l'objecte cotxe
    String marca;
    String model;
    int velm;
    int acc;
    boolean on;
    int vela;
        public ObCar(){
            //Aqui definim els valors que tindran els atributs base
            marca = "";
             model = "";
             velm = 0;
             acc = 0;
             on = false;
             vela = 0;
    }
        public ObCar(String mrc, String mod, int vm, int ac, boolean ences, int va){
            //Aquí es fa amb el mètode sorecarregat per evitar que el programa tingui errors
            marca = mrc;
            model = mod;
            velm = vm;
            acc = ac;
            on = ences;
            vela = va;
        }
        public String getmarca(){
            //Amb el getmarca quan cridem aquesta funcio obtindrem el nom que esta unit al parametre marca
        return marca;
        }
        public String getmodel(){
            //Amb el getmodel quan cridem aquesta funcio obtindrem el nom que esta unit al parametre model
        return model;
        }
        public int getvelm(){
            //Amb el getvelm quan cridem aquesta funcio obtindrem el nom que esta unit al parametre velm
        return velm;
        }
        public int getacc(){
            //Amb el getacc quan cridem aquesta funcio obtindrem el nom que esta unit al parametre acc
        return acc;
        }
        public boolean geton(){
            //Amb el geton quan cridem aquesta funcio obtindrem el nom que esta unit al parametre on
        return on;
        }
        public int getvela(){
                        //Amb el getvela quan cridem aquesta funcio obtindrem el nom que esta unit al parametre vela
        return vela;
        }
            public ObCar setmarca(String novamarca){
                    //Amb setmarca quan es cridi aquesta funció en el programa es podra establir una marca nova
                this.marca = novamarca;
                return null;
            }
            public ObCar setmodel(String noumodel){
                    //Amb setmodel quan es cridi aquesta funció en el programa es podra establir un model nou
                this.model = noumodel;
                return null;
            }
            public ObCar setvelm(int novaspm){
                    //Amb setvelm quan es cridi aquesta funció en el programa es podra establir una velm nova
                this.velm = novaspm;
                return null;
            }
            public ObCar setacc(int novaacc){
                    //Amb setacc quan es cridi aquesta funció en el programa es podra establir una acc nova
                this.acc = novaacc;
                return null;
            }
            public ObCar seton(boolean nouences){
                    //Amb seton quan es cridi aquesta funció en el programa es podra establir un on nou
                this.on = nouences;
                return null;
            }
            public ObCar setvela(int novaspa){
                    //Amb setvela quan es cridi aquesta funció en el programa es podra establir una vela nova
                this.vela = novaspa;
                return null;
            }
}
