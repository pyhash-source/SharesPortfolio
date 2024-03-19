/*
 * Client.
 * @version 1 18/03/2024
 * @copyright Groupe1
 */
package metier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author han shan
 */
public class ActionComposee extends Action {
    /**
     * la repatition d'action simple dans l'action composée.
     */
    private Map<Action, Float> mapPanier;
    /**
     * l'état de completute du panier d'action.
     */
    private boolean finished = false;
    /**
     * la date de création d'action composée.
     */
    private final Date dateCreation;
    /**
     * Hash code basis.
     */
    private static final int BASIS = 3;
    /**
     * Hash code multiplicator.
     */
    private static final int MULTIPLICATOR = 12;
    /**
     * Constructeur ActionComposee.
     * @param libelle Nom de l'action
     */
    public ActionComposee(final String libelle) {
        super(libelle);
        this.mapPanier = new HashMap();
        this.dateCreation = new Date();
    }
    /**
     * getter Panier.
     * @return monPanier le nom du panier
     */
    public final Map<Action, Float> getMapPanier() {
        return mapPanier;
    }
    /**
     * getter l'etat d'action.
     * @return isFinished l'etat de l'action
     */
    public final boolean isFinished() {
        return finished;
    }
    /**
     * setter l'etat de action.
     * @param isFinishToSet l'état de l'action
     */
    public final void setIsFinished(final boolean isFinishToSet) {
        this.finished = isFinishToSet;
    }
    /**
     * getter dateCreation.
     * @return date de creation
     */
    public final Date getDateCreation() {
        return dateCreation;
    }
    /**
     * l'insertion d'action simple dans l'action composée.
     * @param as une action simple
     * @param pourcentage le pourcentage de cette action simple
     * @return return l'etat de methode
     */
    public final boolean enrgComposition(
            final ActionSimple as, final float pourcentage) {
        if (pourcentage < 0) {
            return false;
        }
        if (as == null) {
            return false;
        }
        if (this.mapPanier.containsKey(as)) {
            return false;
        }
         // verification : somme de pourcentage
        // somme de pourcentage
        float somme = 0f;
        for (Action action : this.mapPanier.keySet()) {
            float pourcentageActionSimple = this.mapPanier.get(action);
            somme += pourcentageActionSimple;
        }
        if (somme < 1) {
             // verfication: somme + pourcentage > 1 ？
            if ((somme + pourcentage) > 1) {
                return false;
            } else if ((somme + pourcentage) == 1.0f) {
                this.mapPanier.put(as, pourcentage);
                // Quand total = 1, l'action est complet
                this.finished = true;
                return true;
            } else {
               this.mapPanier.put(as, pourcentage);
               return true;
            }
        }
        return false;
    }
    /**
     * récuperer la valeur de la action composée dans une date.
     * @param j une date
     * @return valeurTotal la somme de la valeur de la action
     */
    @Override
    public final double getValeur(final Date j) {
        Double valeurTotal = 0.0;
        for (Action action : this.mapPanier.keySet()) {
            valeurTotal += action.getValeur(j) * this.mapPanier.get(action);
        }
        return valeurTotal;
    }

    @Override
    public final int hashCode() {
        int hash;
        hash = BASIS * MULTIPLICATOR
                + Objects.hashCode(this.mapPanier);
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
        final ActionComposee other = (ActionComposee) obj;
        if (!this.getLibelle().equals(other.getLibelle())) {
            return false;
        }
        for (Action asimple:this.mapPanier.keySet()) {
            float pourcentage = this.mapPanier.get(asimple);
            if (other.mapPanier.containsKey(asimple)) {
                if (pourcentage != other.mapPanier.get(asimple)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}


