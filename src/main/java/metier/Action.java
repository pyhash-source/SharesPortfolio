/*
 * Portefeuille
 * @version 1 18/03/2024
 * @copyright Groupe1
 */
package metier;

import java.util.Date;

/**
 *
 * @author elisa jean
 */
public abstract class Action {
    /**
    * libelle de l'action.
    */
    private final String libelle;
    /**
     * donne le libelle de l'action.
    * @return libelle de l'action.
    */
    public final String getLibelle() {
        return libelle;
    }
    /**
     * creer une action.
     * @param libelleAction libelle de l'action
    */
    public Action(final String libelleAction) {
        this.libelle = libelleAction;
    }
    /**
    * recuperer la valeu de l'action.
    * @param j date d'ajout du cours
    * @return valeur de l'action
    */
    public abstract double getValeur(final Date j);
}
