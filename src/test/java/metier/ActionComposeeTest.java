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
     * Une ActionComposee vide.
     */
    private static final ActionComposee ACTION_COMPOSEE_1 =
            new ActionComposee("ActionComposee1");
    /**
     * Travail SetUp
     * Une ActionComposee vide.
     */
    private static final ActionComposee ACTION_COMPOSEE_2 =
            new ActionComposee("ActionComposee2");
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
     * @author Shan
     * Test si une ActionSimple est existé
     * lors de les ajoutée dans une ActionComposée.
     */
    @Test
    final void testExistanceDeActionSimpleAdded()throws DoubleActionException {
        ACTION_COMPOSEE_1.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_90);
        final String expectedMessage = "ActionSimple is null";
        NullPointerException assertThrowsExactly = Assertions
                .assertThrowsExactly(NullPointerException.class, () -> {
            ACTION_COMPOSEE_1.
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
    */
    @Test
    final void testActionsAddedNotSame() throws DoubleActionException {
        // Création de cas de test
        ACTION_COMPOSEE_2.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_50);
        // Si une erreur est générée, vérifiez
        //que l'erreur est la même que celle attendue.
        // message attendu
        final String expectedMessage = "Cette action est existe.";
        DoubleActionException assertThrowsExactly = Assertions
                .assertThrowsExactly(DoubleActionException.class, () -> {
            ACTION_COMPOSEE_2.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_50);
        }, "Cette action est existe.");
        // message d'erreur
        final String currentMessage = assertThrowsExactly.getMessage();
        // verifier si ils sont même
        Assertions.assertEquals(expectedMessage, currentMessage,
                "Expected error message");
    }
    /**
     * Tester la somme des pourcentages est de 100%.
     */
    @Test
    protected void testSommePourcentage()
        throws DoubleActionException, PourcentageException {
        
    } 
}