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
class PortefeuilleTest {
    /**
     * client correct.
    */
    private static final Client CLIENT = new Client("Cardona", "Jean");
    /**
     * test le constructeur, le constructeur doit fonctionner.
    */
     @Test
    final void testConstructorParametersAreCorrectSuccess() {
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
    /**
     * teste l'ajout de fonds dans le solde espèces, il doit fonctionner.
    */
     @Test
    final void testAddFundsInCompteEspece() {
        //Arrange
        final Portefeuille portefeuille = new Portefeuille(CLIENT);
        final double valeurAttendueDansPorteuille = 12;
        final double valeurAjouteeDansPortefeuille = 12;
        //Action
        try {
            portefeuille
                    .provisionnerSoldeEspeces(valeurAjouteeDansPortefeuille);
        } catch (Exception e) {
        }
        //Assert
        Assertions.assertEquals(valeurAttendueDansPorteuille, portefeuille
                .getSoldeEspece(), "Ajout basique dans le portefeuille");
    }
}
