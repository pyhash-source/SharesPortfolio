/*
Jour
@version 1 18/03/2024
@copyright Groupe1
*/
package metier;

/**
 *
 * @author R&P
 */
public class Jour {
    // Attributs
    /** numero de l'annee.*/
    private final int annee;
    /** numero du mois.*/
    private final int mois;
    /** numero du jour.*/
    private final int jour;

    /**
     * Recupere la valeur de l'annee.
     *
     * @return la valeur d'annee.
     */
    public final int getAnnee() {
        return annee;
    }

    /**
     * Recupere la valeur du mois.
     *
     * @return la valeur du mois.
     */
    public final int getMois() {
        return mois;
    }

    /**
     * Recupere la valeur du jour.
     *
     * @return la valeur du jour.
     */
    public final int getJour() {
        return jour;
    }

    /** Constructeur.
    *@param year numero de l'annee.
    *@param month numero du mois.
    *@param day numero du jour.*/
    public Jour(final int year, final int month, final int day) {
        this.annee = year;
        this.mois = month;
        this.jour = day;
    }

    @Override
    public final int hashCode() {
        final int valeur = 7;
        int hash = 1;
        hash = valeur * hash + this.annee;
        hash = valeur * hash + this.mois;
        hash = valeur * hash + this.jour;
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
        final Jour other = (Jour) obj;
        if (this.annee != other.annee) {
            return false;
        }
        if (this.mois != other.mois) {
            return false;
        }
        return this.jour == other.jour;
    }
}
