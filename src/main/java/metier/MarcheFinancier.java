/*
MarcheFinancier
@version 1 18/03/2024
@copyright Groupe1
*/

package metier;

import java.util.ArrayList;

/**
 *
 * @author R&P
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
    public final ArrayList<Action> getActions() {
        return actions;
    }

     /**
     * Setter de la liste des actions.
     * @param action action à ajouter
     */
    public final void setActions(final Action action) {
        this.actions.add(action);
    }
}
