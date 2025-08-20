import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MainTest {
    @Test
    public void testAreAnagram() {
        Assertions.assertTrue(Main.areAnagram("банка", "кабан"));
        Assertions.assertTrue(Main.areAnagram("мышка", "камыш"));
        Assertions.assertFalse(Main.areAnagram("ааа", "ооо"));
    }

    @Test void hasDuplicates() {
        Assertions.assertTrue(Main.hasDuplicates(new ArrayList<>(List.of(1, 2, 3, 4, 2, 3))));
        Assertions.assertFalse(Main.hasDuplicates(new ArrayList<>(List.of(1, 2, 3, 4))));
    }
}