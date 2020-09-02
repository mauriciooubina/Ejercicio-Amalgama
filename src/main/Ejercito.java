package main;

import java.util.ArrayList;
import java.util.List;

public class Ejercito {

    private Moneda monedas;
    private List<Batalla> historialBatallas;
    private List<Unidad> unidades;

    public Ejercito(Piquero piquero, Arquero arquero, Caballero caballero){
        monedas = new Moneda(1000);
        historialBatallas = new ArrayList<>();
        unidades = new ArrayList<>();
        unidades.add(piquero);
        unidades.add(arquero);
        unidades.add(caballero);
    }

    public void entrenar(Unidad unidadAEntrenar){
        try{
            monedas.comprobarMonedasSuficientes(unidadAEntrenar.getCostoEntrenar());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        unidadAEntrenar.entrenarse();
        monedas.disminuir(unidadAEntrenar.getCostoEntrenar());
    }


    public void transformar(Unidad unidadATransformar) {
        try{
            monedas.comprobarMonedasSuficientes(unidadATransformar.getCostoTransformar());
            unidadATransformar.transformarse(unidades);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        monedas.disminuir(unidadATransformar.getCostoTransformar());
    }

    public void batallar(Ejercito ejercito){
        Batalla batalla = new Batalla(this,ejercito);
        batalla.combatir();
        historialBatallas.add(batalla);
    }

    public int getPuntosTotales(){
        int total = 0;
        for(Unidad unidad: unidades){
            total += unidad.getPuntosEnTotal();
        }
        return total;
    }

    public void victoria() {
        monedas.aumentar(100);
    }

    public void derrota() {
        this.eliminarUnidadConMasPuntos();
        this.eliminarUnidadConMasPuntos();
    }

    public void eliminarUnidadConMasPuntos() {
        Unidad unidadConMasPuntos = unidades.get(0);
        for(Unidad unidad: unidades){
            if(unidad.getPuntosEnTotal() > unidadConMasPuntos.getPuntosEnTotal()){
                unidadConMasPuntos = unidad;
            }
        }
        unidadConMasPuntos.eliminar();
    }

    public int getMonedasDeOro(){
        return monedas.getTotal();
    }


    public Ejercito getGanadorPrimeraBatallaBatalla(){
        return historialBatallas.get(0).getEjercitoGanador();
    }
}
