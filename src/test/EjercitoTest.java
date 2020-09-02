package test;

import main.Arquero;
import main.Caballero;
import main.Ejercito;
import main.Piquero;
import org.junit.Assert;
import org.junit.Test;

public class EjercitoTest {

    @Test
    public void test(){

        Piquero piqueroChino = new Piquero(2);
        Arquero arqueroChino = new Arquero(25);
        Caballero caballeroChino = new Caballero(2);

        Piquero piqueroIngles = new Piquero(10);
        Arquero arqueroIngles = new Arquero(10);
        Caballero caballeroIngles = new Caballero(10);

        Ejercito chinos = new Ejercito(piqueroChino,arqueroChino,caballeroChino);
        Ejercito ingleses = new Ejercito(piqueroIngles,arqueroIngles,caballeroIngles);

        Assert.assertEquals(300,chinos.getPuntosTotales());
        Assert.assertEquals(350,ingleses.getPuntosTotales());

        chinos.entrenar(piqueroChino);
        ingleses.entrenar(caballeroIngles);

        Assert.assertEquals(990,chinos.getMonedasDeOro());
        Assert.assertEquals(970,ingleses.getMonedasDeOro());
        Assert.assertEquals(306,chinos.getPuntosTotales());
        Assert.assertEquals(450,ingleses.getPuntosTotales());

        chinos.transformar(piqueroChino);
        ingleses.transformar(caballeroChino);

        Assert.assertEquals(310,chinos.getPuntosTotales());
        Assert.assertEquals(450,ingleses.getPuntosTotales()); //NO CAMBIA PORQUE NO PUEDEN TRANSFORMARSE

        chinos.batallar(ingleses);
        Assert.assertEquals(ingleses,chinos.getGanadorPrimeraBatallaBatalla());
        Assert.assertEquals(0,chinos.getPuntosTotales()); //YA QUE LOS PIQUEROS SE HABIAN TRANSFORMADO TODOS Y AL PERDER LAS BATALLA PERDIO SUS 2 UNIDADES
        Assert.assertEquals(1070,ingleses.getMonedasDeOro());

    }
}
