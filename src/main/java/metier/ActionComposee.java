/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author somebody
 */
public class ActionComposee extends Action {

    // attribut lien
    Map<ActionSimple, Float> mapPanier;

    public ActionComposee(String libelle) {
        super(libelle);
        this.mapPanier = new HashMap();
    }

    public void enrgComposition(ActionSimple as, float pourcentage)
            throws DoubleActionException, PourcentageException {
        if (as == null) {
            throw new NullPointerException("ActionSimple is null");
        }
        if (this.mapPanier.containsKey(as)) {
            throw new DoubleActionException("Cette action est existe.");
        }
        // verification : somme de pourcentage
        // somme de pourcentage
        float somme = 0f;
        for (ActionSimple actionsimple : this.mapPanier.keySet()) {
            float pourcentageActionSimple = this.mapPanier.get(actionsimple);
            somme += pourcentageActionSimple;
        }
        // verfication: somme + pourcentage > 1 ？
        if ((somme + pourcentage) > 1) {
            throw new PourcentageException("le somme du pourcentage est > 1");
        }      

        this.mapPanier.put(as, pourcentage);
    }

    @Override
    public float valeur(Jour j) {
        float valeur;

        valeur = 0;
        for (ActionSimple as : this.mapPanier.keySet()) {
            valeur = valeur + (as.valeur(j) * this.mapPanier.get(as));
        }

        return valeur;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.mapPanier);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
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
        return Objects.equals(this.mapPanier, other.mapPanier);
    }
    
    /**
     * Créer une classe interne d'erreur pour l'insertion en double d'une action
     * @throws DoubleActionException si action est existe
     */
    class DoubleActionException extends Exception {
        /**
         * Constucteur d'exception
         * @param message le message d'erreur
         */
        DoubleActionException(final String message) {
        super(message);
        }
    }
    /**
     * Créer une classe interne d'erreur pour verifier la somme d'action
     * @author han
     * @throws PourcentageException si la somme du pourcentage > 1
     */
    class PourcentageException extends Exception {
        /**
         * Constructeur d'exception
         * @param message le message d'erreur
         */
        PourcentageException(final String message) {
        super(message);
        }
    }

}

