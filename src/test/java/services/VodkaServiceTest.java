package services;

import models.BottleSize;
import models.Vodka;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VodkaServiceTest {

    VodkaService vs;

    @Before
    public void setup(){
        vs = new VodkaService();
    }

    @Test
    public void createTest(){

        // (1)
        String expectedBrand = "Smirnoff";
        BottleSize expectedSize = BottleSize.HANDLE;
        int expectedQty = 10;
        int expectedProof = 80;
        double expectedPrice = 80.00;

        // (2)
        Vodka testVodka = vs.create(expectedBrand, expectedProof,
                expectedSize, expectedPrice, expectedQty);

        // (3)
        int actualId = testVodka.getId();
        String actualBrand = testVodka.getBrand();
        BottleSize actualSize = testVodka.getBottleSize();
        int actualQty = testVodka.getQuantity();
        int actualProof = testVodka.getProof();
        double actualPrice = testVodka.getPrice();

        // (4)
        Assert.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assert.assertEquals(expectedBrand, actualBrand);
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expectedQty, actualQty);
        Assert.assertEquals(expectedProof, actualProof);
        Assert.assertEquals((Double) expectedPrice, (Double) actualPrice);

    }

    @Test
    public void testRemove(){
        int expectedSize = 9;
        populateInventory();

        boolean deleted = vs.delete(2);
        int actualSize = vs.getInventory().size();

        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertTrue(deleted);
    }
    @Test
    public void testRemoveFalse(){
        int expectedSize = 10;
        populateInventory();

        boolean deleted = vs.delete(2000);
        int actualSize = vs.getInventory().size();

        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertFalse(deleted);
    }

    @Test
    public void testFindNull(){
        Vodka expected = vs.create("Smirnoff", 80, BottleSize.HANDLE, 23.00, 100);

        Vodka actual = vs.find(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFind(){
        Vodka actual = vs.find(1);

        Assert.assertNull(actual);
    }

    @Test
    public void testFindAll(){
        Vodka[] expected = new Vodka[10];
        for(int i = 0; i < 10; i++){
            Vodka vdk = vs.create("Smirnoff", i * 18, BottleSize.HANDLE, i * 15, 100);
            expected[i] = vdk;
        }

        Vodka[] actual = vs.findAll();

        Assert.assertArrayEquals(expected, actual);
    }

    public void populateInventory(){
        for(int i = 0; i < 10; i++){
            vs.create("Smirnoff", i * 18, BottleSize.HANDLE, i * 15, 100);
        }
    }
}
