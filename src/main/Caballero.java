package main;

import java.util.List;

public class Caballero implements Unidad{

    private int puntosFuerza;
    private int cantidadCaballero;
    private int costoEntrenar;
    private int costoTransformar;

    public Caballero(int cantidad){
        puntosFuerza = 20;
        cantidadCaballero = cantidad;
        costoEntrenar = 30;
        costoTransformar = 0;
    }

    @Override
    public int getCostoEntrenar() {
        return costoEntrenar;
    }

    @Override
    public void entrenarse() {
        puntosFuerza += 10;
    }

    @Override
    public int getCostoTransformar() {
        return costoTransformar;
    }

    @Override
    public void transformarse(List<Unidad> unidades) throws Exception {
        throw new Exception("El caballero no se puede transformar");
    }

    @Override
    public void obtenerTransformado(int cantidad) {
        cantidadCaballero += cantidad;
    }

    @Override
    public int getPuntos() {
        return puntosFuerza;
    }

    @Override
    public void eliminar() {
        cantidadCaballero = 0;
    }

    @Override
    public int getPuntosEnTotal() {
        return cantidadCaballero * puntosFuerza;
    }
}
