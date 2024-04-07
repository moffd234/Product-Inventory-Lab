package models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KitsTest {
    Kit kit;
    @Before
    public void setup(){
        kit = new Kit();
    }

    @Test
    public void testGetId(){
        int expected = 0;
        int actual = kit.getId();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetKitNum(){
        int expected = 0;
        int actual = kit.getKitNum();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testQuantity(){
        int expected = 0;
        int actual = kit.getQuantity();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPrice() {

        double expected = 0.00;
        double actual = kit.getPrice();

        Assert.assertEquals(expected, actual, 0.009);
    }

    @Test
    public void testGetTeam() {
        String actual = kit.getTeam();
        Assert.assertNull(actual);
    }

    @Test
    public void testGetBrand(){
        String actual = kit.getBrand();
        Assert.assertNull(actual);
    }

    @Test
    public void testGetPlayer(){
        String actual = kit.getPlayer();
        Assert.assertNull(actual);
    }

    @Test
    public void testGetSize() {
        Size expected = Size.SMALL;
        Size actual = kit.getSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetSize() {
        Size expected = Size.MEDIUM;

        kit.setSize(expected);
        Size actual = kit.getSize();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetPlayer() {
        String expected = "Messi";

        kit.setPlayer(expected);
        String actual = kit.getPlayer();

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testSetId() {
        int expected = 1;

        kit.setId(expected);
        int actual = kit.getId();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetKitNum() {
        int expected = 123;

        kit.setKitNum(expected);
        int actual = kit.getKitNum();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetQuantity() {
        int expected = 10;

        kit.setQuantity(expected);
        int actual = kit.getQuantity();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetPrice() {
        double expected = 99.99;

        kit.setPrice(expected);
        double actual = kit.getPrice();

        Assert.assertEquals(expected, actual, 0.009);
    }

    @Test
    public void testSetTeam() {
        String expected = "Barcelona";

        kit.setTeam(expected);
        String actual = kit.getTeam();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetBrand() {
        String expected = "Nike";

        kit.setBrand(expected);
        String actual = kit.getBrand();

        Assert.assertEquals(expected, actual);
    }

}
