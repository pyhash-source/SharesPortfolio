/*
 * Portefeuille
 * @version 1 18/03/2024
 * @copyright Groupe1
 * licence http://www.apache.org/licenses/LICENSE-2.0
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
    private static final Client DEUXIEME_CLIENT = new Client("Cueille",
            "Elisa");
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
     * test le get actions.
    */
    @Test
    final void testGetDeActions() {
        //Arrange
        final double valeurAjouteeDansPortefeuille = 12;
        final double valeurCours = 1;
        ActionSimple action = new ActionSimple("FCB");
        action.enrgCours(valeurCours);
        final Portefeuille portefeuille = new Portefeuille(CLIENT);
        portefeuille
            .provisionnerSoldeEspeces(valeurAjouteeDansPortefeuille);
        portefeuille.acheterDesActions(action, 1);
        //Assert
        Assertions.assertTrue(portefeuille.getActions().containsKey(action),
                "test du get action");
    }
    /**
     * test l achat avec un solde pas suffisant.
    */
    @Test
    final void testAchatEchourCarSoldePasSuffisant() {
        //Arrange
        final double valeurAjouteeDansPortefeuille = 12;
        final double valeurCours = 1800000000;
        ActionSimple action = new ActionSimple("FCB");
        action.enrgCours(valeurCours);
        final Portefeuille portefeuille = new Portefeuille(CLIENT);
        portefeuille
            .provisionnerSoldeEspeces(valeurAjouteeDansPortefeuille);
        boolean success = portefeuille.acheterDesActions(action, 1);
        //Assert
        Assertions.assertFalse(success,
                "test du achat avec solde pas suffisant");
    }
    /**
     * test l achat avec un nombre negatif.
    */
    @Test
    final void testAchatEchourCarNombreNegatif() {
        //Arrange
        final double valeurAjouteeDansPortefeuille = 12;
        final double valeurCours = 1800000000;
        ActionSimple action = new ActionSimple("FCB");
        action.enrgCours(valeurCours);
        final Portefeuille portefeuille = new Portefeuille(CLIENT);
        portefeuille
            .provisionnerSoldeEspeces(valeurAjouteeDansPortefeuille);
        boolean success = portefeuille.acheterDesActions(action, -1);
        //Assert
        Assertions.assertFalse(success,
                "test du achat avec solde pas suffisant");
    }
    /**
     * test quand l'on achete deux fois la meme action.
    */
    @Test
    final void testAchatDeuxFoisLaMemeAction() {
        //Arrange
        final double valeurAjouteeDansPortefeuille = 12;
        final double valeurCours = 1;
        ActionSimple action = new ActionSimple("FCB");
        action.enrgCours(valeurCours);
        final Portefeuille portefeuille = new Portefeuille(CLIENT);
        portefeuille
            .provisionnerSoldeEspeces(valeurAjouteeDansPortefeuille);
        portefeuille.acheterDesActions(action, 1);
        portefeuille.acheterDesActions(action, 1);
        //Expected
        Integer nombreActionAttendu = 2;
        //Assert
        Assertions.assertEquals(nombreActionAttendu,
                portefeuille.getActions().get(action),
                "test du get action");
    }
    /**
     * test la recuperation de la valeur du portefeuille.
    */
    @Test
    final void testRecuperationValeurPortefeuille() {
        //Arrange
        final double valeurAjouteeDansPortefeuille = 12;
        final double valeurCours = 1;
        ActionSimple action = new ActionSimple("FCB");
        action.enrgCours(valeurCours);
        final Portefeuille portefeuille = new Portefeuille(CLIENT);
        portefeuille
            .provisionnerSoldeEspeces(valeurAjouteeDansPortefeuille);
        portefeuille.acheterDesActions(action, 1);
        portefeuille.acheterDesActions(action, 1);
        //Expected
        double valeurPortefeuilleAttendue = valeurCours * 2;
        //Assert
        Assertions.assertEquals(valeurPortefeuilleAttendue,
                portefeuille.valeurDuPortefeuille(),
                "test du get action");
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
        portefeuille
            .provisionnerSoldeEspeces(valeurAjouteeDansPortefeuille);

        //Assert
        Assertions.assertEquals(valeurAttendueDansPorteuille, portefeuille
                .getSoldeEspece(), "Ajout basique dans le portefeuille");
    }
    /**
     * test la vente reussie des actions.
    */
    @Test
    final void testVenteActionsReussie() {
        //Arrange
        final double valeurAjouteeDansPortefeuille = 12;
        final double valeurCours = 1;
        final Integer nombreActionsAttendu = 0;

        ActionSimple action = new ActionSimple("FCB");
        action.enrgCours(valeurCours);
        final Portefeuille portefeuille = new Portefeuille(CLIENT);
        portefeuille
            .provisionnerSoldeEspeces(valeurAjouteeDansPortefeuille);
        portefeuille.acheterDesActions(action, 1);
        boolean venteSucces = portefeuille.vendreDesActions(action, 1);
        //Assert
        Assertions.assertTrue(venteSucces, "test du succès de l'opération "
                + "de vente");
        Assertions.assertEquals(nombreActionsAttendu,
                portefeuille.getActions().get(action),
                "Succès de la suppression des actions");
    }
    /**
     * test la vente non reussie des actions car on ne possede pas l'action.
    */
    @Test
    final void venteActionNonPossedee() {
        //Arrange
        final double valeurAjouteeDansPortefeuille = 12;
        final double valeurCours = 1;

        ActionSimple action = new ActionSimple("FCB");
        action.enrgCours(valeurCours);
        final Portefeuille portefeuille = new Portefeuille(CLIENT);
        portefeuille
            .provisionnerSoldeEspeces(valeurAjouteeDansPortefeuille);
        boolean venteAction = portefeuille.vendreDesActions(action, 2);
        //Assert
        Assertions.assertFalse(venteAction, "test du non succès de l'opération "
                + "de vente");
    }
    /**
     * test la vente non reussie des actions car on vend un nombre negatif.
    */
    @Test
    final void testVenteNombreNegatifAction() {
        //Arrange
        final double valeurAjouteeDansPortefeuille = 12;
        final double valeurCours = 1;
        final int nombreDeVentes = -1;
        final int nombreAchat = 1;


        ActionSimple action = new ActionSimple("FCB");
        action.enrgCours(valeurCours);
        final Portefeuille portefeuille = new Portefeuille(CLIENT);
        portefeuille
            .provisionnerSoldeEspeces(valeurAjouteeDansPortefeuille);
        portefeuille.acheterDesActions(action, nombreAchat);
        boolean venteAction = portefeuille.vendreDesActions(action,
                nombreDeVentes);
        //Assert
        Assertions.assertFalse(venteAction, "test du non succès de l'opération "
                + "de vente");
    }
    /**
     * test la vente non reussie des actions car on vend plus que ce que l'on a.
    */
    @Test
    final void testVendrePluDactionQuePossedees() {
        //Arrange
        final double valeurAjouteeDansPortefeuille = 12;
        final double valeurCours = 1;
        final int nombreDeVentes = 2;


        ActionSimple action = new ActionSimple("FCB");
        action.enrgCours(valeurCours);
        final Portefeuille portefeuille = new Portefeuille(CLIENT);
        portefeuille
            .provisionnerSoldeEspeces(valeurAjouteeDansPortefeuille);
        portefeuille.acheterDesActions(action, 1);
        boolean venteAction = portefeuille.vendreDesActions(action,
                nombreDeVentes);
        //Assert
        Assertions.assertFalse(venteAction, "test du non succès de l'opération "
                + "de vente");
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
     * teste le retrait du compte especes, retrait negatif.
    */
     @Test
    final void testRetirerSoldeEspecesRetraitNegatifFail() {
        //Arrange
        final Portefeuille portefeuille = new Portefeuille(CLIENT);
        final double valeurAjouteeDansPortefeuille = 12;
        final double valeurARetirerDuPortefeuille = -22;
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
        boolean equalsSelf = portefeuille.equals(portefeuille);
        Assertions.assertTrue(equalsSelf);
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
        boolean equalsNull = portefeuille.equals(object);
        Assertions
                .assertFalse(equalsNull);
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
        boolean equalsDiffClass = portefeuille.equals(obj);
        Assertions
                .assertFalse(equalsDiffClass);
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
        boolean equalsDiffClient = portefeuille1.equals(portefeuille2);
        Assertions
                .assertFalse(equalsDiffClient);
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
        boolean equalsMemeClient = portefeuille1.equals(portefeuille2);
        Assertions
                .assertTrue(equalsMemeClient);
    }
}