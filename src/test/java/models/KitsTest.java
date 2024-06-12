package models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KitsTest {
    Kit kit;
    @Before
    public void setup(){
        kit = new Kit(0, 10, 1, 100.00, "Philadelphia Union",
        "Nike", "Gazdag", KitSize.LARGE);


    }

    @Test
    public void testConstructor() {
        Assert.assertEquals(0, kit.getId());
        Assert.assertEquals(10, kit.getKitNum());
        Assert.assertEquals(1, kit.getQuantity());
        Assert.assertEquals((Double) 100.00, (Double) kit.getPrice());
        Assert.assertEquals("Philadelphia Union", kit.getTeam());
        Assert.assertEquals("Nike", kit.getBrand());
        Assert.assertEquals("Gazdag", kit.getPlayer());
        Assert.assertEquals(KitSize.LARGE, kit.getSize());
    }

    @Test
    public void testGetId(){
        int expected = 0;
        int actual = kit.getId();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetKitNum(){
        int expected = 10;
        int actual = kit.getKitNum();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testQuantity(){
        int expected = 1;
        int actual = kit.getQuantity();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPrice() {

        double expected = 100.00;
        double actual = kit.getPrice();

        Assert.assertEquals(expected, actual, 0.009);
    }

    @Test
    public void testGetTeam() {
        String expected = "Philadelphia Union";
        String actual = kit.getTeam();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetBrand(){
        String expected = "Nike";
        String actual = kit.getBrand();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPlayer(){
        String expected = "Gazdag";
        String actual = kit.getPlayer();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetSize() {
        KitSize expected = KitSize.LARGE;
        KitSize actual = kit.getSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetSize() {
        KitSize expected = KitSize.MEDIUM;

        kit.setSize(expected);
        KitSize actual = kit.getSize();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetSize1() {
        KitSize expected = KitSize.LARGE;

        kit.setSize(expected);
        KitSize actual = kit.getSize();

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
