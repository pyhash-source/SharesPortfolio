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

/**
 *
 * @author saanw
 */

public class ActionComposeeTest {

    private static final String LIB_ACTION_SIMPLE_1 = "ActionSimple1";
    private static final String LIB_ACTION_SIMPLE_2 = "ActionSimple2";
    private static final String LIB_ACTION_COMPOSEE_1 = "ActionComposee1";
    private static final String LIB_ACTION_COMPOSEE_2 = "ActionSimple2";
    
    private static final ActionSimple acS1 = new ActionSimple(LIB_ACTION_SIMPLE_1);
    private static final ActionSimple acS2 = new ActionSimple(LIB_ACTION_SIMPLE_2);
    private static final ActionSimple actionSimpleNull = null;

    public ActionComposeeTest() {
    }

    @Test
    protected void testExistanceDeActionSimpleAdded() throws DoubleActionException {    
        final ActionComposee acC1=new ActionComposee(LIB_ACTION_COMPOSEE_1);
        acC1.enrgComposition(acS1, (float)0.90);
        final String expectedMessage = "ActionSimple is null";
        NullPointerException assertThrowsExactly = Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            acC1.enrgComposition(null, (float)0.1);
        },"ActionSimple is null");
        final String currentMessage = assertThrowsExactly.getMessage();
        Assertions.assertEquals(expectedMessage, currentMessage, "Expected error message");
    }
    
    /**
     * @author han
     * Test: Si deux actions identiques sont ajoutées, une exception personnalisée est levée.
    */
    @Test
    protected void testActionsAddedNotSame() throws DoubleActionException {
        // Création de cas de test
        final ActionComposee acC2 = new ActionComposee(LIB_ACTION_COMPOSEE_2);
        acC2.enrgComposition(acS1, 0.5f);
        
        // Si une erreur est générée, vérifiez que l'erreur est la même que celle attendue.
        // message attendu
        final String expectedMessage = "Cette action est existe.";
        
        DoubleActionException assertThrowsExactly = Assertions.assertThrowsExactly(DoubleActionException.class, () -> {
            acC2.enrgComposition(acS1, 0.5f);
        },"Cette action est existe.");
        
        // message d'erreur
        final String currentMessage = assertThrowsExactly.getMessage();
        
        // verifier si ils sont même
        Assertions.assertEquals(expectedMessage, currentMessage, "Expected error message");
      
    }
    
    
    /**
     * Tester la somme des pourcentages est de 100%
     */
    @Test
    protected void testSommePourcentage(){
        
    }
        

}