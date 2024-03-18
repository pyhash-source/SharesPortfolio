/*
 * ClientTest.
 * @version 1 18/03/2024
 * @copyright Groupe1
 */
package metier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author elisajean
 */
class ClientTest {
    /**
     * nom du client correct.
    */
    private static final String NOM_OK = "Messi";
    /**
     * prenom du client.
    */
    private static final String PRENOM = "Max";
    /**
     * test le constructeur, le constructeur doit fonctionner.
    */
     @Test
    final void testConstructorParametersAreCorrectSuccess() {
        //Arrange
        final Client client = new Client(NOM_OK, PRENOM);

        //Action
        final String expectedGetNom = "Messi";
        final String expectedGetPrenom = "Max";


        //Assert
        Assertions.assertEquals(expectedGetNom, client.getNom(),
                "Basic construction");
        Assertions.assertEquals(expectedGetPrenom, client.getPrenom(),
                "Basic construction");
    }
}
