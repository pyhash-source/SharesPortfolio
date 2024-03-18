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
     * client.
    */
    private static final Client CLIENT = new Client("Cardona", "Jean");
    /**
     * deuxieme client.
    */
    private static final Client DEUXIEME_CLIENT = new Client("Cueille", "Elisa");
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
    final void testProvisionnerCompteEspecesShouldPass() {
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
    /**
     * teste l'ajout de fonds dans le solde espèces, doit echouer.
    */
     @Test
    final void testProvisionnerCompteEspecesShouldFail() {
        //Arrange
        final Portefeuille portefeuille = new Portefeuille(CLIENT);
        final double valeurAttendueDansPorteuille = 0;
        final double valeurAjouteeDansPortefeuille = -2;
        //Action
        boolean success = portefeuille
                .provisionnerSoldeEspeces(valeurAjouteeDansPortefeuille);
        //Assert
        Assertions.assertEquals(valeurAttendueDansPorteuille, portefeuille
                .getSoldeEspece(), "Ajout basique dans le portefeuille");
        Assertions.assertFalse(success);
    }
    //todo faire teste qund credit <0 return false/true
    /**
     * teste le retrait du compte especes, doit passer.
    */
     @Test
    final void testRetirerSoldeEspecesSuccess() {
        //Arrange
        final Portefeuille portefeuille = new Portefeuille(CLIENT);
        final double valeurAttendueDansPorteuille = 0;
        final double valeurAjouteeDansPortefeuille = 12;
        final double valeurARetirerDuPortefeuille = 12;

        //Action
            boolean success = portefeuille
                    .provisionnerSoldeEspeces(valeurAjouteeDansPortefeuille);
        portefeuille.retirerSoldeEspeces(valeurARetirerDuPortefeuille);
        //Assert
        Assertions.assertEquals(valeurAttendueDansPorteuille, portefeuille
                .getSoldeEspece(), "Retrait basique dans le portefeuille");
        Assertions.assertTrue(success);
    }
    /**
     * teste le retrait du compte especes, ne doit pas passer.
    */
     @Test
    final void testRetirerSoldeEspecesFail() {
        //Arrange
        final Portefeuille portefeuille = new Portefeuille(CLIENT);
        final double valeurAjouteeDansPortefeuille = 12;
        final double valeurARetirerDuPortefeuille = 15;
        final double valeurAttenduePortefeuille = 12;

        //Action
        boolean successProvisionner = portefeuille
                .provisionnerSoldeEspeces(valeurAjouteeDansPortefeuille);
        boolean successRetrait = portefeuille
                .retirerSoldeEspeces(valeurARetirerDuPortefeuille);
        Assertions.assertEquals(valeurAttenduePortefeuille,
                portefeuille.getSoldeEspece(), "test fail du retrait");
        Assertions.assertTrue(successProvisionner);
        Assertions.assertFalse(successRetrait);
    }
    /**
     * test du hashcode.
    */
    @Test
    final void testDuHasCode() {
        //Arrange
        final Portefeuille portefeuille = new Portefeuille(CLIENT);
        //Action
        int hashCode = portefeuille.hashCode();
        //Assert
        Assertions
                .assertInstanceOf(Integer.class, hashCode, "test du hashcode");
    }
    /**
     * test du equals self.
    */
    @Test
    final void testDuEqualsSelf() {
        //Arrange
        final Portefeuille portefeuille = new Portefeuille(CLIENT);
        //Assert
        Assertions
                .assertTrue(portefeuille.equals(portefeuille), "test du equals self");
    }
    /**
     * test du equals null.
    */
    @Test
    final void testDuEqualsNull() {
        //Arrange
        final Portefeuille portefeuille = new Portefeuille(CLIENT);
        final Object object = null;
        //Assert
        Assertions
                .assertFalse(portefeuille.equals(object), "test du equals null");
    }
    /**
     * test du equals different classe.
    */
    @Test
    final void testDuEqualsDifferentClass() {
        //Arrange
        final Portefeuille portefeuille = new Portefeuille(CLIENT);
        Object obj = new Object();
        //Assert
        Assertions
                .assertFalse(portefeuille.equals(obj),
                        "test du equals autre classe");
    }
    /**
     * test du equals differents portefeuille.
    */
    @Test
    final void testDuEqualsDifferentClient() {
        //Arrange
        final Portefeuille portefeuille1 = new Portefeuille(CLIENT);
        final Portefeuille portefeuille2 = new Portefeuille(DEUXIEME_CLIENT);
        //Assert
        Assertions
                .assertFalse(portefeuille1.equals(portefeuille2),
                        "test du equals autre classe");
    }
    /**
     * test du equals portefeuille vraiment le même.
    */
    @Test
    final void testDuEqualsMemeClient() {
        //Arrange
        final Portefeuille portefeuille1 = new Portefeuille(CLIENT);
        final Portefeuille portefeuille2 = new Portefeuille(CLIENT);
        //Assert
        Assertions
                .assertTrue(portefeuille1.equals(portefeuille2),
                        "test du equals même portefeuille");
    }
}