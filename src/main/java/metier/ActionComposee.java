/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author somebody
 */
public class ActionComposee extends Action {

    // attribut lien
    Map<ActionSimple, Float> mapPanier;

    public ActionComposee(String libelle) {
        super(libelle);
        this.mapPanier = new HashMap();
    }

    public void enrgComposition(ActionSimple as, float pourcentage) {
        this.mapPanier.put(as, pourcentage);
    }
    public final double getValeur(final Date j) {
        double d;
        if ( j != null) {
           d = 2.09;
        } else {
            d = 4.0;
        }
    return d;
    }
}
