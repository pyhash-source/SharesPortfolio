
package metier;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author somebody
 */
public class ActionSimple extends Action {

    /** attribut lien.*/
    private Map<Jour, Cours> mapCours;

    /**
     * constructeur.
     * @param libelle
     */
    public ActionSimple(final String libelle) {
        // Action simple initialisée comme 1 action
        super(libelle);
        // init spécifique
    }
}
