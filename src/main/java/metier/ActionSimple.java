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
 * @author R&P
 */
public class ActionSimple extends Action {

    /** attribut mapping du cours selon les jours. */
    private final Map<Jour, Cours> mapCours;
    /** attribut date du jour. */
    private final Date date;

    /** Constructeur ActionSimple.
     *
     * @param libelle nom de l'action
     */
    public ActionSimple(final String libelle) {
        // Action simple initialisée comme 1 action
        super(libelle);
        // init spécifique
        date = new Date();
        this.mapCours = new HashMap<>();
    }

    /** enregistrement du cours pour un jour.
     *
     * @param j jour mois annee
     * @param v valeur du cours
     */
    public void enrgCours(Jour j, float v) {
        long milliseconds = System.currentTimeMillis();
        date.setTime(milliseconds);
        int jourActuel = Integer.valueOf(date.toString().substring(8, 9));
        int moisActuel = Integer.valueOf(date.toString().substring(5, 6));
        int anneeActuel = Integer.valueOf(date.toString().substring(0, 3));
        
        if (anneeActuel <= j.getAnnee()) {
            if (moisActuel <= j.getMois()) {
                if (jourActuel <= j.getJour()) {
                    if (v <= 0 || this.mapCours.containsKey(j)) {
                        System.out.println("Il y a déjà une valeur pour "
                                + "ce jour");
                    } else {
                        this.mapCours.put(j, new Cours(j, v));
                    }
                }
            }
        }
        

    }

    @Override
    public float valeur(Jour j) {
        if (this.mapCours.containsKey(j) == true) {
            return this.mapCours.get(j).getValeur();
        } else {
            return 0; // definition d'une constante possible
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.mapCours);
        hash = 29 * hash + Objects.hashCode(this.date);
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
        final ActionSimple other = (ActionSimple) obj;
        if (!Objects.equals(this.mapCours, other.mapCours)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }
}
