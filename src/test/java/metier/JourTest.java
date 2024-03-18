/*
JourTest
@version 1 18/03/2024
@copyright Groupe1
*/
package metier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author David Navarre &lt;David.Navarre at irit.fr&gt & R&P;
 */
public class JourTest {
    /** jour valide par defaut.*/
    private static final int DEFAULT_DAY = 1;
    /** mois valide par defaut.*/
    private static final int DEFAULT_MONTH = 1;
    /** annee valide par defaut.*/
    private static final int DEFAULT_YEAR = 1;
    /** jour invalide par defaut.*/
    private static final int INCORRECT_DAY = 0;
    /** mois invalide par defaut.*/
    private static final int INCORRECT_MONTH = 0;
    /** annee invalide par defaut.*/
    private static final int INCORRECT_YEAR = 0;

    /**
     * Constructeur par defaut.
     */
    public JourTest() {
    }

    /**
     * Methode pour tester si les parametres du constructeur sont valides
     * et permettent la creation de l'objet.
     */
    @Test
    final void testConstructorParametersAreCorrectSuccess() {
        //Arrange
        final Jour jour;
        jour = new Jour(DEFAULT_YEAR, DEFAULT_MONTH, DEFAULT_DAY);

        //Action
        final String expectedToString;
        expectedToString = "Jour{"
                + "annee="
                + DEFAULT_YEAR
                + ", mois=" + DEFAULT_MONTH + " , jour=" + DEFAULT_DAY + '}';
        final String currentToString = jour.toString();

        //Assert
        Assertions.assertEquals(expectedToString, currentToString,
                "Basic construction");
    }
    
    /**
     * Methode pour tester si les parametres du constructeur sont invalides
     * et bloquent la creation de l'objet.
     */
    @Test
    final void testConstructorDayIncorrectShouldFail() {
        //Arrange
        final String expectedMessage = "0 must not be used as a valid Day";
        //Action and asserts
        IllegalArgumentException assertThrowsExactly;
        assertThrowsExactly
                = Assertions.assertThrowsExactly(IllegalArgumentException.class,
                        () -> {
                    new Jour(DEFAULT_YEAR, DEFAULT_MONTH, INCORRECT_DAY);
                }, "0 must not be used as a valid Day");
        final String currentMessage = assertThrowsExactly.getMessage();
        Assertions.assertEquals(expectedMessage, currentMessage,
                "Expected error message");

    }
}
