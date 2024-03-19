/*
 * MarcheFinancierTest
 * @version 1 19/03/2024
 * @copyright Groupe1
 */
package metier;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

/**
 *
 * @author R&P
 */
public class MarcheFinancierTest {
    
    @Test
    public void testMarcheFinancierConstructor() {
        // Arrange
        MarcheFinancier marcheFinancier;

        // Action
        marcheFinancier = new MarcheFinancier();

        // Assert
        assertNotNull(marcheFinancier);
        assertNotNull(marcheFinancier.getActions());
        assertEquals(0, marcheFinancier.getActions().size());
    }
}
