/*
 * ActionSimpleTest
 * @version 1 19/03/2024
 * @copyright Groupe1
 * licence http://www.apache.org/licenses/LICENSE-2.0
 */
package metier;

import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Raphael Pauline
 */
class ActionSimpleTest {
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
        boolean equalsSelf = actionSimple.equals(actionSimple);
        Assertions
                .assertTrue(equalsSelf);
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
        boolean equalsNull = actionSimple.equals(object);
        Assertions
                .assertFalse(equalsNull);
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
        boolean equalsDiffClass = actionSimple.equals(obj);
        Assertions
                .assertFalse(equalsDiffClass);
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
        boolean equalsDiffClient = actionSimple1.equals(actionSimple2);
        Assertions
                .assertFalse(equalsDiffClient);
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
        boolean equalsMemeClient = actionSimple1.equals(actionSimple2);
        Assertions
                .assertTrue(equalsMemeClient);
    }
}
