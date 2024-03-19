/*
 * ActionSimpleTest
 * @version 1 19/03/2024
 * @copyright Groupe1
 */
package metier;

import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author R&P
 */
public class ActionSimpleTest {
    /**
     * Lib action1.
     */
    private static final String ACTION1 = "action1";

     /**
     * Lib action2.
     */
    private static final String ACTION2 = "action2";

    /**
     * test le constructeur, le constructeur doit fonctionner.
    */
     @Test
    final void testConstructorParametersAreCorrectSuccess() {
        //Arrange
        final ActionSimple actionSimple = new ActionSimple(ACTION1);

        //Action
        final String expectedLibAction = "action1";

        //Assert
        Assertions.assertEquals(expectedLibAction, actionSimple.getLibelle(),
                "Basic construction");
    }

    /**
     * test enregistrement cours doit fonctionner.
     */
    @Test
    final void testAjoutValeurJourActionSimpleShouldPass() {
        //Arrange
        final ActionSimple actionSimple = new ActionSimple(ACTION1);
        final double valeurAttendueAujourdhui = 12;
        final Date dateDuJour = new Date();

        try {
           actionSimple.enrgCours(valeurAttendueAujourdhui);
        } catch (Exception e) {
        }

        //Assert
        Assertions.assertEquals(valeurAttendueAujourdhui, actionSimple
                .getValeur(dateDuJour),
                "Ajout basique d'un cours pour une action");
    }
    /**
     * test enregistrement cours valeur négative ne doit pas fonctionner.
     */
    @Test
    final void testAjoutValeurJourActionSimpleFail() {
        //Arrange
        final ActionSimple actionSimple = new ActionSimple(ACTION1);
        final double valeurAjouteeNegative = -12;
        final double valeurAttendue = 0;
        final Date dateDuJour = new Date();

        //Action
        try {
           actionSimple.enrgCours(valeurAjouteeNegative);
        } catch (Exception e) {
        }

        //Assert
        Assertions.assertEquals(valeurAttendue, actionSimple
                .getValeur(dateDuJour),
                "Ajout d'une d'une valeur négative pour une action");
    }

     /**
     * test récupération d'une valeur pour un jour ou on n'en a pas attribuer.
     */
    @Test
    final void testGetValeurJourActionSimpleFail() {
        //Arrange
        final ActionSimple actionSimple = new ActionSimple(ACTION1);
        final Date dateDuJour = new Date();
        final double valeurAttendue = 0.;

        //Assert
        Assertions.assertEquals(valeurAttendue, actionSimple
                .getValeur(dateDuJour),
                "Lecture d'une valeur pour un jour qui n'a pas été enregistré");
    }

    /**
    * test du hashcode.
    */
    @Test
    final void testDuHasCode() {
        //Arrange
        final ActionSimple actionSimple = new ActionSimple(ACTION1);
        //Action
        int hashCode = actionSimple.hashCode();
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
        final ActionSimple actionSimple = new ActionSimple(ACTION1);
        //Assert
        Assertions
                .assertTrue(actionSimple.equals(actionSimple),
                        "test du equals self");
    }

    /**
     * test du equals null.
    */
    @Test
    final void testDuEqualsNull() {
        //Arrange
        final ActionSimple actionSimple = new ActionSimple(ACTION1);
        final Object object = null;
        //Assert
        Assertions
                .assertFalse(actionSimple.equals(object),
                        "test du equals null");
    }

    /**
     * test du equals different classe.
    */
    @Test
    final void testDuEqualsDifferentClass() {
        //Arrange
        final ActionSimple actionSimple = new ActionSimple(ACTION1);
        Object obj = new Object();
        //Assert
        Assertions
                .assertFalse(actionSimple.equals(obj),
                        "test du equals autre classe");
    }

    /**
     * test du equals differents portefeuille.
    */
    @Test
    final void testDuEqualsDifferentClient() {
        //Arrange
        final ActionSimple actionSimple1 = new ActionSimple(ACTION1);
        final ActionSimple actionSimple2 = new ActionSimple(ACTION2);
        //Assert
        Assertions
                .assertFalse(actionSimple1.equals(actionSimple2),
                        "test du equals autre client");
    }

    /**
     * test du equals portefeuille vraiment le même.
    */
    @Test
    final void testDuEqualsMemeClient() {
        //Arrange
        final ActionSimple actionSimple1 = new ActionSimple(ACTION1);
        final ActionSimple actionSimple2 = new ActionSimple(ACTION1);
        //Assert
        Assertions
                .assertTrue(actionSimple1.equals(actionSimple2),
                        "test du equals même client");
    }
}
