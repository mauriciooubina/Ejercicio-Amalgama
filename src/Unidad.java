import java.util.List;

public interface Unidad {


    int getCostoEntrenar();

    void entrenarse();

    int getCostoTransformar();

    void transformarse(List<Unidad> unidades) throws Exception;

    void obtenerTransformado(int cantidad);

    int getPuntos();

    void eliminar();

    int getPuntosEnTotal();
}
