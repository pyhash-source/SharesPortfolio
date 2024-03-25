/*
ActionSimple
@version 1 18/03/2024
@copyright Groupe1
*/
package metier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Raphael Pauline
 */
public class ActionSimple extends Action {
    /**
    * constante fixe pour le calcul du hashcode.
    */
    private static final int VALEUR = 3;
    /**
    * constante multiplicatrice pour le calcul du hashcode.
    */
    private static final int MULTIPLICATEUR = 42;

    /** attribut mapping du cours selon les jours. */
    private final Map<Date, Double> mapCours;

    /** Constructeur ActionSimple.
     *
     * @param libelle nom de l'action
     */
    public ActionSimple(final String libelle) {
        // Action simple initialisée comme 1 action
        super(libelle);
        // init spécifique
        this.mapCours = new HashMap<>();
    }

    /** enregistrement du cours pour un jour.
     *
     * @param valeur valeur du cours
     */
    public final void enrgCours(final double valeur) {
        Date date = new Date();
        if (valeur <= 0) {
            this.mapCours.put(date, 0.);
        } else {
            this.mapCours.put(date, valeur);
        }
    }

    /**
     * Getter de la valeur pour un jour donne.
     * @param j jour
     * @return valeur de l'action
     */
    @Override
    public final double getValeur(final Date j) {
        if (this.mapCours.containsKey(j)) {
            return this.mapCours.get(j);
        } else {
            return 0; // definition d'une constante possible
        }
    }

    @Override
    public final int hashCode() {
        int hash = VALEUR;
        hash = MULTIPLICATEUR * hash + Objects.hashCode(this.mapCours);
        return hash;
    }

    /**
     * Methode equals.
     * @param obj objet
     * @return boolean si c'est un objet
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
        final ActionSimple other = (ActionSimple) obj;
        return Objects.equals(this.getLibelle(), other.getLibelle());
    }
}