import java.util.List;

public class Piquero implements Unidad{

    private int puntosFuerza;
    private int cantidadPiqueros;
    private int costoEntrenar;
    private int costoTransformar;
    private Unidad unidadDeTransformacion;

    public Piquero(int cantidad){
        puntosFuerza = 5;
        cantidadPiqueros = cantidad;
        costoEntrenar = 10;
        costoTransformar = 30;
        unidadDeTransformacion = new Arquero(cantidadPiqueros);
    }

    @Override
    public int getCostoEntrenar() {
        return costoEntrenar;
    }

    @Override
    public void entrenarse() {
        puntosFuerza += 3;
    }

    @Override
    public int getCostoTransformar() {
        return costoTransformar;
    }

    @Override
    public void transformarse(List<Unidad> unidades) {
        for(Unidad unidad: unidades){
            if (unidad.getClass() == unidadDeTransformacion.getClass()){
                unidad.obtenerTransformado(cantidadPiqueros);
            }
        }
        cantidadPiqueros = 0;
    }

    @Override
    public void obtenerTransformado(int cantidad) {
        cantidadPiqueros += 0;
    }

    @Override
    public int getPuntos() {
        return puntosFuerza;
    }

    @Override
    public void eliminar() {
        cantidadPiqueros = 0;
    }

    @Override
    public int getPuntosEnTotal() {
        return cantidadPiqueros * puntosFuerza;
    }
}
