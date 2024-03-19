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
    final void enrgCours(final Jour j, final float v) {
        long milliseconds = System.currentTimeMillis();
        final int debutJour = 8;
        final int finJour = 9;
        final int debutMois = 5;
        final int finMois = 6;
        final int debutAnnee = 0;
        final int finAnnee = 3;
        date.setTime(milliseconds);
        int jourActuel;
        jourActuel = Integer.parseInt(date.toString()
                        .substring(debutJour, finJour));
        int moisActuel;
        moisActuel = Integer.parseInt(date.toString()
                        .substring(debutMois, finMois));
        int anneeActuel;
        anneeActuel = Integer.parseInt(date.toString()
                .substring(debutAnnee, finAnnee));
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

    /**
     * Getter de la valeur pour un jour donne.
     * @param j jour
     * @return valeur de l'action
     */
    public final float getValeur(final Jour j) {
        if (this.mapCours.containsKey(j)) {
            return this.mapCours.get(j).getValeur();
        } else {
            return 0; // definition d'une constante possible
        }
    }

    @Override
    public final int hashCode() {
        final int valeur = 29;
        final int constHash = 7;
        int hash = constHash;
        hash = valeur * hash + Objects.hashCode(this.mapCours);
        hash = valeur * hash + Objects.hashCode(this.date);
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
        if (!Objects.equals(this.mapCours, other.mapCours)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }

    @Override
    public float valeur(Jour j) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }
}
