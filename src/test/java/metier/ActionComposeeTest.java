/*
 * ActionSimpleTest
 * @version 1 19/03/2024
 * @copyright Groupe1
 */
package metier;

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
     * Test la methode Equals(), objet null a le resultat False.
     */
    @Test
    final void testDuEqualsNull() {
        // Créer un objet ActionComposee 1 et null
        ActionComposee actionComposee1 =
                new ActionComposee("actionComposee1");
        ActionComposee actionComposee2 = null;
        // test objet ActionComposee 1 equal 2
        boolean testDuEqualsNull = actionComposee1.equals(actionComposee2);
        Assertions.assertFalse(testDuEqualsNull);
    }
    /**
     * Test la methode Equals(), 2 meme objets a le resultat true.
     */
    @Test
    final void testDuEqualsMemeActionComposee() {
        // Créer un objet ActionComposee1
        ActionComposee actionComposee1 =
                new ActionComposee("actionComposee1");
        // Test objet ActionComposee 1 equal 1
        boolean testDuEqualsMemeActionComposee =
                actionComposee1.equals(actionComposee1);
         Assertions.assertTrue(testDuEqualsMemeActionComposee);
    }
    /**
     * Test la methode Equals(),
     *  objet n'est pas le même class a le resultat False.
     */
    @Test
    final void testDuEqualsDifferentClass() {
        // Créer un objet ActionComposee1
        ActionComposee actionComposee1 =
                new ActionComposee("actionComposee1");
        // objet n'est pas le même class
        Object obj = new Object();
        boolean equalsDiffClass = actionComposee1.equals(obj);
        Assertions.assertFalse(equalsDiffClass);
    }
    /**
     * Test la methode Equals(),
     *  2 action composee vide mais libelles diffierentes a le resultat false.
     */
    @Test
    final void testDuEqualsDifferentActionComposee() {
        // Créer un objet ActionComposee 1 et 2
        ActionComposee actionComposee1 =
                new ActionComposee("actionComposee1");
        ActionComposee actionComposee2 =
                new ActionComposee("actionComposee2");
        // Vérifier si les deux AC 1 et 2 sont les mêmes
        boolean testDuEqualsDiffActionComposee =
                actionComposee1.equals(actionComposee2);
        Assertions.assertFalse(testDuEqualsDiffActionComposee);
    }
    /**
     * Test la methode Equals(),
     *  2 action composee avec meme action simple, pourcentage,
     *  libelle a le resultat True.
     */
    @Test
    final void testDuEqualsMemeActionSimleDansMemeActionComposee() {
        // Créer un objet ActionComposee 1 et 2
        ActionComposee actionComposee1 =
                new ActionComposee("actionComposee1");
        ActionComposee actionComposee2 =
                new ActionComposee("actionComposee1");
        // Ajouter les AS dans la AC
        // même libelle et même AS
        actionComposee1.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_50);
        actionComposee1.enrgComposition(ACTION_SIMPLE_2, POURCENTAGE_10);
        actionComposee2.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_50);
        actionComposee2.enrgComposition(ACTION_SIMPLE_2, POURCENTAGE_10);
        // Vérifier si les deux AC sont les mêmes
        boolean testDuEqualsMmActonSimleDansMmActionComposee =
                actionComposee1.equals(actionComposee2);
        Assertions.assertTrue(testDuEqualsMmActonSimleDansMmActionComposee);
    }
    /**
     * Test la methode Equals(), 2 action composee avec meme nom
     *                              mais action simple diff a le resultat False.
     */
    @Test
    final void testDuEqualsDifferentActionSimleDansMemeActionComposee() {
        // mais eff. se diffferent
        ActionComposee actionComposee1 =
                new ActionComposee("actionComposeeMemeNom");
        ActionComposee actionComposee2 =
                new ActionComposee("actionComposeeMemeNom");
        actionComposee1.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_10);
        actionComposee2.enrgComposition(ACTION_SIMPLE_2, POURCENTAGE_10);
        // Vérifier si les deux AC sont les mêmes
        boolean testDuEqualsDiffActionSimleDansMmActionComposee =
                actionComposee1.equals(actionComposee2);
        Assertions.assertFalse(testDuEqualsDiffActionSimleDansMmActionComposee);
    }
    /**
     *  Test la methode Equals(), 2 AC avec même libelle et AS,
     *      mais le pourcentage n'est pas le même a le resultat False.
     */
    @Test
    final void testDuEqualsDiffPourcentageActionSimleDansMemeActionComposee() {
        // 2 AC avec même libelle et AS, mais le pourcentage n'est pas le même
        ActionComposee actionComposee1 =
                new ActionComposee("actionComposeeMemeNom");
        ActionComposee actionComposee2 =
                new ActionComposee("actionComposeeMemeNom");
        actionComposee1.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_10);
        actionComposee2.enrgComposition(ACTION_SIMPLE_1, POURCENTAGE_50);
        // Vérifier si les deux AC sont les mêmes
        boolean testDuEqualsDiffPourcentageActionSimleDansMmActionComposee =
                actionComposee1.equals(actionComposee2);
        Assertions.assertFalse(
                testDuEqualsDiffPourcentageActionSimleDansMmActionComposee);
    }
    /**
     * Tester la methode getValeur.
     */
    @Test
    final void testGetValeur() {
        //Arrange
        final ActionSimple actionSimple1 = new ActionSimple("as1");
        final ActionSimple actionSimple2 = new ActionSimple("as2");
        final double valeurAttendueAujourdhui = 12;
        final Date dateDuJour = new Date();
        try {
           actionSimple1.enrgCours(valeurAttendueAujourdhui);
           actionSimple2.enrgCours(valeurAttendueAujourdhui);
        } catch (Exception e) {
        }
        ActionComposee actionComposee19 =
                new ActionComposee("actionComposee19");
        actionComposee19.enrgComposition(actionSimple1, POURCENTAGE_50);
        actionComposee19.enrgComposition(actionSimple2, POURCENTAGE_50);
        Assertions.assertEquals(valeurAttendueAujourdhui,
                actionComposee19.getValeur(dateDuJour), "Equal");
    }
}