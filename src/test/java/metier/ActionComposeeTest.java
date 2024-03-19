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
     * Construre ActionSimple ACTION_SIMPLE_2.
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
     * pourcentage de ActionSimple 20%.
     */
    private static final float POURCENTAGE_20 = 0.2f;
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
     */
    @Test
    final void testExistanceDeActionSimpleAdded() {
        // Création de une action
        ActionComposee actionComposee1 =
            new ActionComposee("ActionComposee1");
        // Création de cas de test
        Assertions.assertFalse(actionComposee1.enrgComposition(
                ACTION_SIMPLR_NULL, POURCENTAGE_90));
    }
    /**
     * @author han
     * Test: Si deux actions identiques sont ajoutées,
    */
    @Test
    final void testActionsAddedNotSame() {
        // Création de une action
        ActionComposee actionComposee2 =
            new ActionComposee("ActionComposee2");
        // Création de cas de test
        actionComposee2.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_50);
        // Si une erreur est générée, vérifiez
        Assertions.assertFalse(actionComposee2.enrgComposition(
                ACTION_SIMPLE_1, POURCENTAGE_50));
    }
    /**
     * Tester la somme des pourcentages est de 100%.
     */
    @Test
    final void testSommePourcentage() {
        // Création de une action
        ActionComposee actionComposee3 =
            new ActionComposee("ActionComposee3");
        // Création de cas de test
        actionComposee3.enrgComposition(ACTION_SIMPLE_2, POURCENTAGE_50);
        Assertions.assertFalse(actionComposee3.enrgComposition(
            ACTION_SIMPLE_1, POURCENTAGE_90));
        }
    /**
     * Tester Quand le pourcentage est 100%, l'etat d'action est true.
     */
    @Test
    final void testEtatDeAction() {
        ActionComposee actionComposee4 =
            new ActionComposee("ActionComposee4");
        // Création de cas de test
        actionComposee4.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_50);
        // Tester l'etat d'acton
        Assertions.assertTrue(actionComposee4.enrgComposition(
                ACTION_SIMPLE_2, POURCENTAGE_50));
    }
    /**
     * Tester la somme des pourcentages est de 100%.
    */
    @Test
    final void testPourcentageInputNotNegatif() {
        ActionComposee actionC = new ActionComposee("ActionComposee");
        // verifier l'etat de la methode
         Assertions.assertFalse(actionC.enrgComposition(
                 ACTION_SIMPLE_1, POURCENTAGE_NEGATIF));
      }
}