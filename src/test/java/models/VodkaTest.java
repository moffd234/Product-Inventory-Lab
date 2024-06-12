package models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VodkaTest {
    Vodka vodka;

    @Before
    public void setup() {
        vodka = new Vodka("Grey Goose", 100, BottleSize.HANDLE, 80.00, 10, 1);
    }

    @Test
    public void testConstructor() {
        Assert.assertEquals("Grey Goose", vodka.getBrand());
        Assert.assertEquals(100, vodka.getProof());
        Assert.assertEquals(BottleSize.HANDLE, vodka.getBottleSize());
    }

    @Test
    public void testGetBrand() {
        String expected = "Grey Goose";
        String actual = vodka.getBrand();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetProof() {
        int expected = 100;

        int actual = vodka.getProof();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetBottleSize() {
        BottleSize expected = BottleSize.HANDLE;

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
    @Test
    public void testGetPrice() {
        double expected = 80.00;
        double actual = vodka.getPrice();
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testSetPrice() {
        double expected = 90.50;
        vodka.setPrice(expected);
        double actual = vodka.getPrice();
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testGetQuantity() {
        int expected = 10;
        int actual = vodka.getQuantity();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetQuantity() {
        int expected = 15;
        vodka.setQuantity(expected);
        int actual = vodka.getQuantity();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetId() {
        int expected = 1;
        int actual = vodka.getId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetId() {
        int expected = 2;
        vodka.setId(expected);
        int actual = vodka.getId();
        Assert.assertEquals(expected, actual);
    }

}
