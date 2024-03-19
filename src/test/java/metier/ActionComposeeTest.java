/*
 * Copyright 2024 saanw.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package metier;

//import metier.ActionComposee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import metier.ActionComposee.DoubleActionException;
import metier.ActionComposee.PourcentageException;
import metier.ActionComposee.PourentageInputException;

/**
* Tester class ActionComposee.
*/
public class ActionComposeeTest {
     /**
     * Travail SetUp
     * Construre ActionSimple ACTION_SIMPLE_1.
     */
    private static final ActionSimple ACTION_SIMPLE_1 =
        new ActionSimple("ActionSimple1");
    /**
     * Travail SetUp
     * Construre ActionSimple ACTION_SIMPLE_1.
     */
    private static final ActionSimple ACTION_SIMPLE_2 =
        new ActionSimple("ActionSimple2");
    /**
     * Travail SetUp
     * Une ActionSimple null.
     */
    private static final ActionSimple ACTION_SIMPLR_NULL = null;
    /**
     * Travail SetUp
     * pourcentage de ActionSimple 10%.
     */
    private static final float POURCENTAGE_10 = 0.1f;
    /**
     * Travail SetUp
     * pourcentage de ActionSimple 90%.
     */
    private static final float POURCENTAGE_90 = 0.9f;
    /**
     * Travail SetUp
     * pourcentage de ActionSimple 50%.
     */
    private static final float POURCENTAGE_50 = 0.5f;
    /**
     * Travail SetUp
     * pourcentage de ActionSimple -50%.
     */
    private static final float POURCENTAGE_NEGATIF =
            -0.5f;

    /**
     * @author Shan
     * Test si une ActionSimple est existé
     * lors de les ajoutée dans une ActionComposée.
     * @throws DoubleActionException
     *  si'l y a 2 meme actions dans un actionComposee
     * @throws PourcentageException
     *  la somme des pourcentages est de 100%
     * @throws PourentageInputException
     *  Vérification de pourcentage est positive
     */
    @Test
    final void testExistanceDeActionSimpleAdded()
            throws DoubleActionException, PourcentageException,
            PourentageInputException {
        // Création de une action
        ActionComposee actionComposee1 =
            new ActionComposee("ActionComposee1");
        // Création de cas de test
        actionComposee1.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_90);
        final String expectedMessage = "ActionSimple is null";
        NullPointerException assertThrowsExactly = Assertions
                .assertThrowsExactly(NullPointerException.class, () -> {
            actionComposee1.
                    enrgComposition(ACTION_SIMPLR_NULL, POURCENTAGE_10);
        }, "ActionSimple is null");
        final String currentMessage = assertThrowsExactly.getMessage();
        Assertions.assertEquals(
                expectedMessage, currentMessage, "Expected error message");
    }
    /**
     * @author han
     * Test: Si deux actions identiques sont ajoutées,
     * une exception personnalisée est levée.
     * @throws DoubleActionException
     *  si'l y a 2 meme actions dans un actionComposee
     * @throws PourcentageException
     *  la somme des pourcentages est de 100%
     * @throws PourentageInputException
     *  Vérification de pourcentage est positive
    */
    @Test
    final void testActionsAddedNotSame()
            throws DoubleActionException, PourcentageException,
            PourentageInputException {
        // Création de une action
        ActionComposee actionComposee2 =
            new ActionComposee("ActionComposee2");
        // Création de cas de test
        actionComposee2.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_50);
        // Si une erreur est générée, vérifiez
        //que l'erreur est la même que celle attendue.
        // message attendu
        final String expectedMessage = "Cette action est existe.";
        DoubleActionException assertThrowsExactly = Assertions
                .assertThrowsExactly(DoubleActionException.class, () -> {
            actionComposee2.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_50);
        }, "Cette action est existe.");
        // message d'erreur
        final String currentMessage = assertThrowsExactly.getMessage();
        // verifier si ils sont même
        Assertions.assertEquals(expectedMessage, currentMessage,
                "Expected error message");
    }
    /**
     * Tester la somme des pourcentages est de 100%.
     * @throws DoubleActionException
     *  si'l y a 2 meme actions dans un actionComposee
     * @throws PourcentageException
     *  la somme des pourcentages est de 100%
     * @throws PourentageInputException
     *  Vérification de pourcentage est positive
     */
    @Test
    final void testSommePourcentage()
        throws DoubleActionException, PourcentageException,
            PourentageInputException {
        // Création de une action
        ActionComposee actionComposee3 =
            new ActionComposee("ActionComposee3");
        // Création de cas de test
        actionComposee3.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_50);
        // Si une erreur est générée, vérifiez que
        // l'erreur est la même que celle attendue.
        // message attendu
        final String expectedMessage = "le somme du pourcentage est > 1";
        PourcentageException assertThrowsExactly = Assertions
                .assertThrowsExactly(PourcentageException.class, () -> {
            actionComposee3.enrgComposition(ACTION_SIMPLE_2, POURCENTAGE_90);
        }, "le somme du pourcentage est > 1");
        // message d'erreur
        final String currentMessage = assertThrowsExactly.getMessage();
        // verifier si ils sont même
        Assertions.assertEquals(
                expectedMessage, currentMessage, "Expected error message");
    }
    /**
     * Tester Quand le pourcentage est 100%, l'etat d'action est true.
     * @throws DoubleActionException
     *  si'l y a 2 meme actions dans un actionComposee
     * @throws PourcentageException
     *  la somme des pourcentages est de 100%
     * @throws PourentageInputException
     *  Vérification de pourcentage est positive
     */
    @Test
    final void testEtatDeAction()
        throws DoubleActionException, PourcentageException,
            PourentageInputException {
        ActionComposee actionComposee4 =
            new ActionComposee("ActionComposee4");
        // Création de cas de test
        actionComposee4.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_50);
        actionComposee4.enrgComposition(ACTION_SIMPLE_2, POURCENTAGE_50);
        // Tester l'etat d'acton
        Assertions.assertEquals(
                true, actionComposee4.isFinished(), "Expected statut");
    }
    /**
     * Tester la somme des pourcentages est de 100%.
     * @throws DoubleActionException
     *  si'l y a 2 meme actions dans un actionComposee
     * @throws PourcentageException
     *  la somme des pourcentages est de 100%
     * @throws PourentageInputException
     *  Vérification de pourcentage est positive
    */
    @Test
    final void testPourcentageInputNotNegatif()
        throws DoubleActionException, PourcentageException,
            PourentageInputException {
        ActionComposee actionC = new ActionComposee("ActionComposee4");
        final String expectedMessage = "Pourcentage input est negatif.";
        PourentageInputException assertThrowsExactly =
                Assertions.assertThrowsExactly(PourentageInputException.class,
                        () -> { actionC.enrgComposition(
                                ACTION_SIMPLE_1, POURCENTAGE_NEGATIF);
                               }, "Pourentage input est negatif.");
        // message d'erreur
        // verifier si ils sont même
        final String currentMessage = assertThrowsExactly.getMessage();
        Assertions.assertEquals(expectedMessage, currentMessage,
                "Expected error message"); }
}