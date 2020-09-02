package main;

public class Moneda {

    private int monedasOro;

    public Moneda(int cantidad){
        monedasOro = cantidad;
    }

    public void disminuir(int cantidad) {
        monedasOro -= cantidad;
    }

    public void comprobarMonedasSuficientes(int costoEntrenar) throws Exception {
        if(costoEntrenar>monedasOro){
            throw new Exception("No posee monedas suficientes");
        }
    }

    public void aumentar(int cantidad) {
        monedasOro += cantidad;
    }

    public int getTotal() {
        return monedasOro;
    }
}
