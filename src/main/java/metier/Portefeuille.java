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
     * solde du compte espèce.
     */
    private double soldeEspece;
    /**
     * constructeur permettant de creer un portefeuille.
     * @param clientPortefeuille client du portefeuille
    */
    public Portefeuille(final Client clientPortefeuille) {
        this.client = clientPortefeuille;
        this.actions = new HashMap();
        this.soldeEspece = 0;
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
    /**
     * retourne la valeur actuelle du compte espèces.
     * @return solde
    */
    public final double getSoldeEspece() {
        return soldeEspece;
    }
    /**
     * crédite le solde espèces du portefeuille.
     * @param credit valeur à ajouter au solde espèces
     * @throws Exception si une valeur négative ou nulle est ajoutée au solde
    */
    public final void provisionnerSoldeEspeces(final double credit)
            throws Exception {
        if (credit > 0) {
            this.soldeEspece += credit;
        }
    }
    /**
     * retire de l'argent du solde espèces.
     * @param retrait valeur à retirer du solde espèces
     * @throws Exception si une valeur positive ou nulle est retirée du solde
    */
    public final void retirerSoldeEspeces(final double retrait)
            throws Exception {
        if (retrait <= 0 && (this.soldeEspece - retrait >= 0)) {
            this.soldeEspece -= retrait;
        }
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
