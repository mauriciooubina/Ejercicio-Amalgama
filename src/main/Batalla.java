package main;

public class Batalla {

    private Ejercito ejercito1;
    private Ejercito ejercito2;
    private Ejercito ejercitoGanador;
    private Ejercito ejercitoPerdedor;

    public Batalla(Ejercito ejercito1, Ejercito ejercito2){
        this.ejercito1 = ejercito1;
        this.ejercito2 = ejercito2;
    }

    public Ejercito getEjercitoGanador(){return ejercitoGanador;}

    public Ejercito getEjercitoPerdedor(){return ejercitoPerdedor;}


    public void combatir() {
        if(ejercito1.getPuntosTotales() > ejercito2.getPuntosTotales()){
            ejercito1.victoria();
            ejercito2.derrota();
            ejercitoGanador = ejercito1;
            ejercitoPerdedor = ejercito2;
        }
        if(ejercito1.getPuntosTotales() < ejercito2.getPuntosTotales()){
            ejercito2.victoria();
            ejercito1.derrota();
            ejercitoGanador = ejercito2;
            ejercitoPerdedor = ejercito1;
        }
        if(ejercito1.getPuntosTotales() == ejercito2.getPuntosTotales()){
            ejercito1.eliminarUnidadConMasPuntos();
            ejercito2.eliminarUnidadConMasPuntos();
        }
    }
}
