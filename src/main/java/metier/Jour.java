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
     * Recupere la valeur de annee.
     *
     * @return la valeur d'annee.
     */
    public final int getAnnee() {
        return annee;
    }

    /**
     * Recupere la valeur de mois.
     *
     * @return la valeur de mois.
     */
    public final int getMois() {
        return mois;
    }

    /**
     * Recupere la valeur de jour.
     *
     * @return la valeur de jour.
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
}
