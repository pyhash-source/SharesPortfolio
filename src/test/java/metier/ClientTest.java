/*
 * ClientTest.
 * @version 1 18/03/2024
 * @copyright Groupe1
 */
package metier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author elisajean
 */
class ClientTest {
    /**
     * nom du client.
    */
    private static final String NOM = "Messi";
    /**
     * prenom du client.
    */
    private static final String PRENOM = "Max";
    /**
     * nom du client bis.
    */
    private static final String DEUXIEME_NOM = "Iniesta";
    /**
     * prenom du client bis.
    */
    private static final String DEUXIEME_PRENOM = "Charles";
    /**
     * test le constructeur, le constructeur doit fonctionner.
    */
     @Test
    final void testConstructorParametersAreCorrectSuccess() {
        //Arrange
        final Client client = new Client(NOM, PRENOM);

        //Action
        final String expectedGetNom = "Messi";
        final String expectedGetPrenom = "Max";


        //Assert
        Assertions.assertEquals(expectedGetNom, client.getNom(),
                "Basic construction");
        Assertions.assertEquals(expectedGetPrenom, client.getPrenom(),
                "Basic construction");
    }
    /**
     * test le get nom.
    */
    @Test
    final void testGetDuNom() {
        //Arrange
        final Client client = new Client(NOM, PRENOM);

        //Action
        final String expectedGetNom = "Messi";
        //Assert
        Assertions.assertEquals(expectedGetNom, client.getNom(),
                "test du get nom");
    }
    /**
     * test le get prenom.
    */
    @Test
    final void testGetDuPrenom() {
        //Arrange
        final Client client = new Client(NOM, PRENOM);
        //Action
        final String expectedGetPrenom = "Max";
        //Assert
        Assertions.assertEquals(expectedGetPrenom, client.getPrenom(),
                "test du get prenom");
    }
    /**
     * test le set prenom.
    */
    @Test
    final void testSetDuPrenom() {
        //Arrange
        final Client client = new Client(NOM, PRENOM);
        //Action
        final String expectedNouveauPrenom = DEUXIEME_PRENOM;
        client.setPrenom(DEUXIEME_PRENOM);
        //Assert
        Assertions.assertEquals(expectedNouveauPrenom, client.getPrenom(),
                "test du set prenom");
    }
    /**
     * test le set nom.
    */
    @Test
    final void testSetDuNom() {
        //Arrange
        final Client client = new Client(NOM, PRENOM);
        //Action
        final String expectedNouveauNom = DEUXIEME_NOM;
        client.setNom(DEUXIEME_NOM);
        //Assert
        Assertions.assertEquals(expectedNouveauNom, client.getNom(),
                "test du set nom");
    }
    /**
     * test du hashcode.
    */
    @Test
    final void testDuHasCode() {
        //Arrange
        final Client client = new Client(NOM, PRENOM);
        //Action
        int hashCode = client.hashCode();
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
        final Client client = new Client(NOM, PRENOM);
        //Assert
        boolean equalsSelf = client.equals(client);
        Assertions
                .assertTrue(equalsSelf);
    }
    /**
     * test du equals null.
    */
    @Test
    final void testDuEqualsNull() {
        //Arrange
        final Client client = new Client(NOM, PRENOM);
        final Object object = null;
        //Assert
        boolean equalsNull = client.equals(object);
        Assertions
                .assertFalse(equalsNull);
    }
    /**
     * test du equals different classe.
    */
    @Test
    final void testDuEqualsDifferentClass() {
        //Arrange
        final Client client = new Client(NOM, PRENOM);
        Object obj = new Object();
        //Assert
        boolean equalsDiffClass = client.equals(obj);
        Assertions
                .assertFalse(equalsDiffClass);
    }
    /**
     * test du equals differents clients.
    */
    @Test
    final void testDuEqualsDifferentClient() {
        //Arrange
        final Client client1 = new Client(NOM, PRENOM);
        final Client client2 = new Client(DEUXIEME_NOM, DEUXIEME_PRENOM);
        //Assert
        boolean equalsDiffClient = client1.equals(client2);
        Assertions
                .assertFalse(equalsDiffClient);
    }
    /**
     * test du equals client vraiment le même.
    */
    @Test
    final void testDuEqualsMemeClient() {
        //Arrange
        final Client client1 = new Client(NOM, PRENOM);
        final Client client2 = new Client(NOM, PRENOM);
        //Assert
        boolean equalsMemeClient = client1.equals(client2);
        Assertions
                .assertTrue(equalsMemeClient);
    }
}


