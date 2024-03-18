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
    /**
     * la repatition d'action simple dans l'action composée.
     */
    private Map<ActionSimple, Float> mapPanier;
    /**
     * l'état de completute du panier d'action.
     */
    private boolean isFinish = false;
    /**
     * la date de création d'action composée.
     */
    private Jour dateCreation;
    /**
     * Hash code basis.
     */
    private final static int HASH_BASIS = 3;
    /**
     * Hash code multiplicator.
     */
    private final static int HASH_MULTIPLICATOR = 12;
    /**
     * Constructeur ActionComposee.
     * @param libelle Nom de l'action
     */
    public ActionComposee(final String libelle) {
        super(libelle);
        this.mapPanier = new HashMap();
    }
    /**
     * getter Panier.
     * @return monPanier le nom du panier
     */
    public final Map<ActionSimple, Float> getMapPanier() {
        return mapPanier;
    }
    /**
     * Setter Panier.
     * @param mapPanierToSet la map panier à enregistrer
     */
    public final void setMapPanier(final Map<ActionSimple, Float> 
            mapPanierToSet) {
        this.mapPanier = mapPanierToSet;
    }
    /**
     * getter l'etat d'action.
     * @return isIsFinish l'etat de l'action
     */
    public final boolean isIsFinish() {
        return isFinish;
    }
    /**
     * setter l'etat de action.
     * @param isFinishToSet l'état de l'action
     */
    public final void setIsFinish(final boolean isFinishToSet) {
        this.isFinish = isFinishToSet;
    }
    /**
     * getter dateCreation.
     * @return date de creation
     */
    public final Jour getDateCreation() {
        return dateCreation;
    }
    /**
     * setter DateCreation.
     * @param dateCreationToSet la date de creation
     */
    public final void setDateCreation(final Jour dateCreationToSet) {
        this.dateCreation = dateCreationToSet;
    }
    /**
     * l'insertion d'action simple dans l'action composée.
     * @param as une action simple
     * @param pourcentage le pourcentage de cette action simple
     * @throws DoubleActionException
     *  si'l y a 2 meme actions dans un actionComposee
     * @throws PourcentageException
     *  la somme des pourcentages est de 100%
     */
    public final void enrgComposition(final ActionSimple as,
            final float pourcentage)
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
        if (somme < 1) {
             // verfication: somme + pourcentage > 1 ？
            if ((somme + pourcentage) > 1) {
                throw new PourcentageException(
                        "le somme du pourcentage est > 1");
            } else if ((somme + pourcentage) == 1) {
                this.mapPanier.put(as, pourcentage);
                // Quand total = 1, l'action est complet
                this.isFinish = true;
            } else {
               this.mapPanier.put(as, pourcentage);
            }
        }
    }

    @Override
    public final float valeur(final Jour j) {
        float valeur;

        valeur = 0;
        for (ActionSimple as : this.mapPanier.keySet()) {
            valeur = valeur + (as.valeur(j) * this.mapPanier.get(as));
        }

        return valeur;
    }

    @Override
    public final int hashCode() {
        int hash;
        hash = HASH_BASIS * HASH_MULTIPLICATOR
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
        return Objects.equals(this.mapPanier, other.mapPanier);
    }
    /**
     * Créer la classe interne d'erreur pour l'insertion en double d'une action.
     * @throws DoubleActionException si action est existe.
     */
    class DoubleActionException extends Exception {
        /**
         * Constucteur d'exception.
         * @param message le message d'erreur.
         */
        DoubleActionException(final String message) {
        super(message);
        }
    }
    /**
     * Créer une classe interne d'erreur pour verifier la somme d'action.
     * @author han
     * @throws PourcentageException si la somme du pourcentage > 1.
     */
    class PourcentageException extends Exception {
        /**
         * Constructeur d'exception.
         * @param message le message d'erreur.
         */
        PourcentageException(final String message) {
        super(message);
        }
    }
    /**
     * Créer une classe interne d'erreur pour verifier la somme d'action.
     * @author han
     * @throws PourcentageException
     *  l'exception pour vérifier si le pourcentage est positive
     */
    class PourentageInputException extends Exception {
        /**
         * Constructeur d'exception.
         * @param message le message d'erreur.
         */
        PourentageInputException(final String message) {
            super(message);
        }
    }

}

