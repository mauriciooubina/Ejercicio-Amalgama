import java.util.List;

public class Arquero implements Unidad{

    private int puntosFuerza;
    private int cantidadArqueros;
    private int costoEntrenar;
    private int costoTransformar;
    private Unidad unidadDeTransformacion;

    public Arquero(int cantidad){
        puntosFuerza = 10;
        cantidadArqueros = cantidad;
        costoEntrenar = 20;
        costoTransformar = 40;
        unidadDeTransformacion = new Caballero(cantidadArqueros);
    }

    @Override
    public int getCostoEntrenar() {
        return costoEntrenar;
    }

    @Override
    public void entrenarse() {
        puntosFuerza += 7;
    }

    @Override
    public int getCostoTransformar() {
        return costoTransformar;
    }

    @Override
    public void transformarse(List<Unidad> unidades) {
        for(Unidad unidad: unidades){
            if (unidad.getClass() == unidadDeTransformacion.getClass()){
                unidad.obtenerTransformado(cantidadArqueros);
            }
        }
        cantidadArqueros = 0;
    }

    @Override
    public void obtenerTransformado(int cantidad) {
        cantidadArqueros += cantidad;
    }

    @Override
    public int getPuntos() {
        return puntosFuerza;
    }

    @Override
    public void eliminar() {
        cantidadArqueros = 0;
    }

    @Override
    public int getPuntosEnTotal() {
        return cantidadArqueros * puntosFuerza;
    }

}
