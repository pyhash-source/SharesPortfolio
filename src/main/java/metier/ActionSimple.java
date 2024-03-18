/* 
ActionSimple
@version 1 18/03/2024
@copyright Groupe1
*/
package metier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author R&P
 */
public class ActionSimple extends Action {

    // attribut lien
    private Map<Jour, Cours> mapCours; 
    // attribut date du jour
    private Date date = new Date();

    // constructeur
    public ActionSimple(String libelle) {
        // Action simple initialisée comme 1 action
        super(libelle);
        // init spécifique
        this.mapCours = new HashMap();
    }

    // enrg possible si pas de cours pour ce jour
    public void enrgCours(Jour j, float v) {
        long milliseconds = System.currentTimeMillis();
        date.setTime(milliseconds);
        date.
         if (this.mapCours.containsKey(j) == false && v > 0 ) {
            this.mapCours.put(j, new Cours(j, v));
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
}
