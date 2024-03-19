/*
 * Portefeuille
 * @version 1 18/03/2024
 * @copyright Groupe1
 */
package metier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author elisajean
 */
public class Portefeuille {
    /**
     * constante fixe pour le calcul du hashcode.
    */
    private static final int VALEUR = 3;
    /**
     * constante multiplicatrice pour le calcul du hashcode.
    */
    private static final int MULTIPLICATEUR = 42;
    /**
     * client a qui appartient le portefeuiile.
     */
    private final Client client;
    /**
     * liste des actions possédées.
     */
    private final HashMap<Action, Integer> actions;
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
        this.actions = new HashMap<>();
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
    public final Map<Action, Integer> getActions() {
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
     * @return retourne true si l'operation s'est bien passée, false sinon
    */
    public final boolean provisionnerSoldeEspeces(final double credit) {
        if (credit > 0) {
            this.soldeEspece += credit;
            return true;
        }
        return false;
    }
    /**
     * retire de l'argent du solde espèces.
     * @param retrait valeur à retirer du solde espèces
     * @return retourne true si l'operation s'est bien passée, false sinon
    */
    public final boolean retirerSoldeEspeces(final double retrait) {
        if (retrait > 0 && (this.soldeEspece - retrait >= 0)) {
            this.soldeEspece -= retrait;
            return true;
        }
        return false;
    }
    /**
     *
     * @param action action voulant être achetee
     * @param nombre nombre de l'action voulant etre acheter
     * @return le resultat de l'operation: true commit, false pas d'opération
     */
    public final boolean acheterDesActions(final Action action,
            final int nombre) {
        Date dateJour = new Date();
        Double montantTotal = nombre * action.getValeur(dateJour);
        if (this.soldeEspece >= montantTotal) {
            this.soldeEspece -= montantTotal;
            if (this.actions.containsKey(action)) {
                this.actions.put(action, this.actions.get(action) + nombre);
            } else {
                this.actions.put(action, nombre);
            }
            return true;
        }
        return false;
    }
    /**
     * retourne l'hashcode du portefeuille.
     * @return hashcode du portefeuille
    */
    @Override
    public final int hashCode() {
        int hash = VALEUR;
        hash = MULTIPLICATEUR * hash + Objects.hashCode(this.client);
        hash = MULTIPLICATEUR * hash + Objects.hashCode(this.actions);
        return hash;
    }

    /**
     * retourne si les deux portefeuilles sont les mêmes.
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
        final Portefeuille other = (Portefeuille) obj;
        if (!Objects.equals(this.client, other.client)) {
            return false;
        }
        return Objects.equals(this.actions, other.actions);
    }
}
