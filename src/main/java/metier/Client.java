/*
 * Client.
 * @version 1 18/03/2024
 * @copyright Groupe1
 */
package metier;

import java.util.Objects;

/**
 *
 * @author elisajean
 */
public class Client {
    /**
     * constante fixe pour le calcul du hashcode.
    */
    private static final int VALEUR = 3;
    /**
     * constante multiplicatrice pour le calcul du hashcode.
    */
    private static final int MULTIPLICATEUR = 42;
    /**
     * nom du client.
    */
    private String nom;
    /**
     * prenom du client.
    */
    private String prenom;

    /**
     * constructeur permettant de creer un client.
     * @param nomClient nom du client
     * @param prenomClient prenom du client
    */
    public Client(final String nomClient, final String prenomClient) {
        this.nom = nomClient;
        this.prenom = prenomClient;
    }

    /**
     * retourne le nom du client.
     * @return nom du client
    */
    public final String getNom() {
        return nom;
    }
    /**
     * retourne le prenom du client.
     * @return prenom du client
    */
    public final String getPrenom() {
        return prenom;
    }

    /**
     * changer le nom du client.
     * @param nomClient nom du client
    */
    public final void setNom(final String nomClient) {
        this.nom = nomClient;
    }

    /**
     * changer le prenom du client.
     * @param prenomClient prenom du client
    */
    public final void setPrenom(final String prenomClient) {
        this.prenom = prenomClient;
    }

    /**
     * retourne l'hashcode du client.
     * @return hashcode du client
    */
    @Override
    public final int hashCode() {
        int hash = VALEUR;
        hash = MULTIPLICATEUR * hash + Objects.hashCode(this.nom);
        hash = MULTIPLICATEUR * hash + Objects.hashCode(this.prenom);
        return hash;
    }

    /**
     * retourne si les deux clients sont les mêmes.
     * @param obj un objet à comparer
     * @return booleen
    */
    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return Objects.equals(this.prenom, other.prenom);
    }
}
