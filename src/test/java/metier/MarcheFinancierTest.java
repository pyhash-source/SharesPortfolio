/*
 * MarcheFinancierTest
 * @version 1 19/03/2024
 * @copyright Groupe1
 */
package metier;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

/**
 *
 * @author R&P
 */
class MarcheFinancierTest {
    /**
    * test le constructeur, le constructeur doit fonctionner.
    */
    @Test
    final void testMarcheFinancierConstructor() {
        // Arrange
        MarcheFinancier marcheFinancier = new MarcheFinancier();

        // Assert
        assertNotNull(marcheFinancier);
        assertNotNull(marcheFinancier.getActions());
        assertEquals(0, marcheFinancier.getActions().size());
    }

    /**
    * test récupération des actions du marché.
    */
    @Test
    final void testGetActions() {
        ActionSimple action1 = new ActionSimple("Action1");
        ActionSimple action2 = new ActionSimple("Action2");
        // Arrange
        MarcheFinancier marcheFinancier = new MarcheFinancier();
        ArrayList<Action> expectedActions = new ArrayList<>();
        expectedActions.add(action1);
        expectedActions.add(action2);

        // Action
        marcheFinancier.getActions().add(action1);
        marcheFinancier.getActions().add(action2);

        // Assert
        assertNotNull(marcheFinancier);
        assertEquals(expectedActions.size(), marcheFinancier.getActions()
                .size());

    }
    /**
     * test du setter d'une action dans le marche financier.
     */
     @Test
    final void testSetActions() {
        // Arrange
        MarcheFinancier marcheFinancier = new MarcheFinancier();
        ArrayList<Action> expectedActions = new ArrayList<>();
        ActionSimple action1 = new ActionSimple("Action1");

        // Action
        expectedActions.add(action1);
        marcheFinancier.setAction(action1);

        // Assert
        assertNotNull(marcheFinancier.getActions());
        assertEquals(expectedActions.size(), marcheFinancier.getActions()
                .size());
    }
}
