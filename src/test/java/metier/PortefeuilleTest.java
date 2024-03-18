/*
 * Portefeuille
 * @version 1 18/03/2024
 * @copyright Groupe1
 */
package metier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author elisajean
 */
public class PortefeuilleTest {
    /**
     * client correct.
    */
    private static final Client CLIENT = new Client("Cardona", "Jean");
    /**
     * test le constructeur, le constructeur doit fonctionner.
    */
     @Test
    protected final void testConstructorParametersAreCorrectSuccess() {
        //Arrange
        final Portefeuille portefeuille = new Portefeuille(CLIENT);

        //Action
        final String expectedNomClient = "Cardona";
        final String expectedPrenomClient = "Jean";


        //Assert
        Assertions.assertEquals(expectedNomClient, portefeuille.getClient()
                .getNom(), "Basic construction");
        Assertions.assertEquals(expectedPrenomClient, portefeuille.getClient()
                .getPrenom(), "Basic construction");
    }
}
