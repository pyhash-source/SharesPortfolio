/*
ActionSimpleTest
@version 1 18/03/2024
@copyright Groupe1
*/
package metier;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Pauline
 */
public class ActionSimpleTest {

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    /**
     * Test of enrgCours method, of class ActionSimple.
     */
    @Test
    public void testEnrgCours() {
        System.out.println("enrgCours");
        Jour j = null;
        float v = 0.0F;
        ActionSimple instance = null;
        instance.enrgCours(j, v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValeur method, of class ActionSimple.
     */
    @Test
    public void testGetValeur() {
        System.out.println("getValeur");
        Jour j = null;
        ActionSimple instance = null;
        float expResult = 0.0F;
        float result = instance.getValeur(j);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class ActionSimple.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ActionSimple instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class ActionSimple.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        ActionSimple instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
