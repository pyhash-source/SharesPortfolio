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
import java.util.Date;
import java.util.Map;
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
        //  Création de une action ActionComposee3_1
         ActionComposee actionComposee13 =
            new ActionComposee("actionComposee13");
         actionComposee13.enrgComposition(ACTION_SIMPLE_2, POURCENTAGE_50);
         actionComposee13.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_50);
         Assertions.assertFalse(actionComposee13.enrgComposition(
            new ActionSimple("actionSimple3"), POURCENTAGE_90));
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
    /**
     * Tester la getter getMapPanier.
     */
    @Test
    final void testGetMapPanier() {
        // Créer un objet ActionComposee
        ActionComposee actionComposee5 = new ActionComposee("actionComposee5");
        actionComposee5.enrgComposition(
                ACTION_SIMPLE_2, POURCENTAGE_50);
        Map<Action, Float> mapPanier = actionComposee5.getMapPanier();
        // Affirme que mapPanier n'est pas nul.
        Assertions.assertNotNull(mapPanier);
    }
    /**
     * Tester le methode isFinished.
     */
    @Test
    final void testIsFinished() {
        // Créer un objet ActionComposee7
        ActionComposee actionComposee7 = new ActionComposee("actionComposee7");
        // Vérifier que maintenant l'état de AC est false
        Assertions.assertFalse(actionComposee7.isFinished());
        actionComposee7.setIsFinished(true);
        // Vérifier que maintenant l'état de AC est true
        Assertions.assertTrue(actionComposee7.isFinished());
    }
    /**
     * Tester la méthode getDateCreation.
     */
    @Test
    final void testGetDateCreation() {
        // Créer un objet ActionComposee8
        ActionComposee actionComposee8 = new ActionComposee("actionComposee8");
        // Récuperer la date
        Date dateCreation = actionComposee8.getDateCreation();
        // Vérification de date n'est pas null
        Assertions.assertNotNull(dateCreation);
    }
    /**
     * Tester la méthode HashCode().
     */
    @Test
    final void testHashCode() {
        // Hash code basis.
        final int basis = 3;
        // Hash code multiplicator.
        final int multiplicator = 12;
        // Créer un objet ActionComposee9
        ActionComposee actionComposee9 = new ActionComposee("actionComposee9");
        // Créer HashCode par nous même
        int expectedHashCode = basis * multiplicator;
        // Tester si les hashcode sont le même
        Assertions.assertEquals(expectedHashCode, actionComposee9.hashCode());
    }
     /**
     * Tester la methode Equals().
     */
    @Test
    final void testEquals() {
        // Créer un objet ActionComposee10 et 11
        ActionComposee actionComposee10 =
                new ActionComposee("actionComposee10");
        ActionComposee actionComposee11 =
                new ActionComposee("actionComposee11");
        // même objet
        Assertions.assertTrue(actionComposee10.equals(actionComposee10));
        // objet null
        ActionComposee actionComposee14 = null;
        Assertions.assertFalse(actionComposee10.equals(actionComposee14));
        // objet n'est pas le même class
        Assertions.assertFalse(actionComposee10.equals(new ActionSimple("as")));
        // Vérifier si les deux AC 10 et 11 sont les mêmes
        Assertions.assertFalse(actionComposee10.equals(actionComposee11));
        // Ajouter les AS dans la AC
        // même libelle et même AS
        actionComposee11.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_50);
        actionComposee11.enrgComposition(ACTION_SIMPLE_2, POURCENTAGE_10);
        ActionComposee actionComposee12 =
                new ActionComposee("actionComposee11");
        actionComposee12.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_50);
        actionComposee12.enrgComposition(ACTION_SIMPLE_2, POURCENTAGE_10);
        // Vérifier si les deux AC sont les mêmes
        Assertions.assertTrue(actionComposee11.equals(actionComposee12));
        // 2 test equal le cas actions composantes sont identiques
        // mais eff. se diffferent
        ActionComposee actionComposee15 =
                new ActionComposee("actionComposeeMemeNom");
        ActionComposee actionComposee16 =
                new ActionComposee("actionComposeeMemeNom");
        actionComposee15.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_10);
        actionComposee16.enrgComposition(ACTION_SIMPLE_2, POURCENTAGE_10);
        Assertions.assertFalse(actionComposee15.equals(actionComposee16));
        // 2 AC avec même libelle et AS, mais le pourcentage n'est pas le même
        ActionComposee actionComposee17 =
                new ActionComposee("actionComposeeMemeNom2");
        ActionComposee actionComposee18 =
                new ActionComposee("actionComposeeMemeNom2");
        actionComposee17.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_10);
        actionComposee18.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_50);
        Assertions.assertFalse(actionComposee17.equals(actionComposee18));
    }
    /**
     * Tester la methode getValeur
     */
//    @Test
//    final void testGetValeur() {
//        // Creer 2 actions simples et 1 action composee
//        ActionSimple as1 = new ActionSimple("as1");
//        ActionSimple as2 = new ActionSimple("as2");
//        final double coursAs1 = 20.0;
//        final double coursAs2 = 20.0;
//        as1.enrgCours(coursAs1);
//        as2.enrgCours(coursAs2);
//        // enregistrer la as
//        ActionComposee actionComposee =
//                new ActionComposee("actionComposee19");
//        actionComposee.enrgComposition(as1, POURCENTAGE_50);
//        actionComposee.enrgComposition(as2, POURCENTAGE_50);
//        // obtenir la date de as
//        for (Action as : actionComposee.getMapPanier().keySet()) {
//            float pourcentage = actionComposee.getMapPanier().get(as);
//            double valeur
//        }
//    }
}