import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;

public class SILab2Test {
    @Test
    public void testEveryBranch() {
        RuntimeException ex1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(), 50));
        assertEquals("allItems listata e prazna!", ex1.getMessage());
        List<Item> items2 = Arrays.asList(new Item(null, "123", 10, 0));
        boolean result2 = SILab2.checkCart(items2, 50);
        assertEquals("unknown", items2.get(0).getName());
        List<Item> items3 = Arrays.asList(new Item("Proizvod1", "12345", 50, 0));
        boolean result3 = SILab2.checkCart(items3, 50);
        assertTrue(result3);
        List<Item> items4 = Arrays.asList(new Item(null, "12345", 50, 0));
        boolean result4 = SILab2.checkCart(items4, 100);
        assertEquals("unknown", items4.get(0).getName());
        assertTrue(result4);
        List<Item> items5 = Arrays.asList(new Item("Proizvod2", "12A45", 50, 0));
        RuntimeException ex5 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items5, 100));
        assertEquals("Invalid character in item barcode!", ex5.getMessage());
        List<Item> items6 = Arrays.asList(new Item("Proizvod3", null, 50, 0));
        RuntimeException ex6 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items6, 100));
        assertEquals("No barcode!", ex6.getMessage());
        List<Item> items7 = Arrays.asList(new Item("Proizvod4", "12345", 100, 0.2F));
        boolean result7 = SILab2.checkCart(items7, 80);
        assertTrue(result7);
        List<Item> items8 = Arrays.asList(new Item("Рroizvod5", "12345", 60, 0));
        boolean result8 = SILab2.checkCart(items8, 50);
        assertFalse(result8);
        List<Item> items9 = Arrays.asList(new Item("Proizvod6", "012345", 400, 0.1F));
        boolean result9 = SILab2.checkCart(items9, 500);
        assertTrue(result9);
    }
    @Test
    public void testMultipleCondition() {
        List<Item> items1 = Arrays.asList(new Item("item1", "0123456789", 350, 10));
        boolean result1 = SILab2.checkCart(items1, 500);
        assertTrue(result1);
        List<Item> items2 = Arrays.asList(new Item("item2", "1234567890", 350, 10));
        boolean result2 = SILab2.checkCart(items2, 500);
        assertFalse(result2);
        List<Item> items3 = Arrays.asList(new Item("item3", "0123456789", 350, 0));
        boolean result3 = SILab2.checkCart(items3, 500);
        assertFalse(result3);
        List<Item> items4 = Arrays.asList(new Item("item4", "1234567890", 350, 0));
        boolean result4 = SILab2.checkCart(items4, 500);
        assertFalse(result4);
        List<Item> items5 = Arrays.asList(new Item("item5", "0123456789", 250, 10));
        boolean result5 = SILab2.checkCart(items5, 500);
        assertFalse(result5);
        List<Item> items6 = Arrays.asList(new Item("item6", "1234567890", 250, 10));
        boolean result6 = SILab2.checkCart(items6, 500);
        assertFalse(result6);
        List<Item> items7 = Arrays.asList(new Item("item7", "0123456789", 250, 0));
        boolean result7 = SILab2.checkCart(items7, 500);
        assertFalse(result7);
        List<Item> items8 = Arrays.asList(new Item("item8", "1234567890", 250, 0));
        boolean result8 = SILab2.checkCart(items8, 500);
        assertFalse(result8);
    }
}