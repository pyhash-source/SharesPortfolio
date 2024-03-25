/*
MarcheFinancier
@version 1 18/03/2024
@copyright Groupe1
*/

package metier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raphael Pauline
 */
public class MarcheFinancier {

    /**
     * Liste d'actions.
     */
    private final ArrayList<Action> actions;

    /**
     * Constructeur par défaut.
     */
    public MarcheFinancier() {
        this.actions = new ArrayList<>();
    }

    /**
     * Getter de la liste des actions.
     * @return actions
     */
    public final List<Action> getActions() {
        return actions;
    }

     /**
     * Setter de la liste des actions.
     * @param action action à ajouter
     */
    public final void setAction(final Action action) {
        this.actions.add(action);
    }
}
