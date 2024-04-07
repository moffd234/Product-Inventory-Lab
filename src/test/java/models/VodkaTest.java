package models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VodkaTest {
    Vodka vodka;

    @Before
    public void setup() {
        vodka = new Vodka();
    }

    @Test
    public void testGetBrand() {
        String expected = "Absolut";

        vodka.setBrand(expected);
        String actual = vodka.getBrand();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetProof() {
        int expected = 80;

        vodka.setProof(expected);
        int actual = vodka.getProof();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetBottleSize() {
        BottleSize expected = BottleSize.FIFTH;

        vodka.setBottleSize(expected);
        BottleSize actual = vodka.getBottleSize();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetBrand() {
        String expected = "Smirnoff";

        vodka.setBrand(expected);
        String actual = vodka.getBrand();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetProof() {
        int expected = 100;

        vodka.setProof(expected);
        int actual = vodka.getProof();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetBottleSize() {
        BottleSize expected = BottleSize.LITER;

        vodka.setBottleSize(expected);
        BottleSize actual = vodka.getBottleSize();

        Assert.assertEquals(expected, actual);
    }
}
