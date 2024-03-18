/*
 * Portefeuille
 * @version 1 18/03/2024
 * @copyright Groupe1
 */
package metier;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author elisajean
 */
public class Portefeuille {
    /**
     * constante fixe pour le calcul du hashcode.
    */
    private final int valeur = 3;
    /**
     * constante multiplicatrice pour le calcul du hashcode.
    */
    private final int multiplicateur = 42;
    /**
     * client a qui appartient le portefeuiile.
     */
    private final Client client;
    /**
     * liste des actions possédées.
     */
    private HashMap<Action, Integer> actions;

    /**
     * constructeur permettant de creer un portefeuille.
     * @param clientPortefeuille client du portefeuille
    */
    public Portefeuille(final Client clientPortefeuille) {
        this.client = clientPortefeuille;
        this.actions = new HashMap();
    }
    /**
     * retourne le client.
     * @return client
    */
    public final Client getClient() {
        return client;
    }
    /**
     * retourne les actions.
     * @return actions
    */
    public final HashMap<Action, Integer> getActions() {
        return actions;
    }


    @Override
    public final int hashCode() {
        int hash = this.valeur;
        hash = this.multiplicateur * hash + Objects.hashCode(this.client);
        hash = this.multiplicateur * hash + Objects.hashCode(this.actions);
        return hash;
    }

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
        final Portefeuille other = (Portefeuille) obj;
        if (!Objects.equals(this.client, other.client)) {
            return false;
        }
        return Objects.equals(this.actions, other.actions);
    }
}
