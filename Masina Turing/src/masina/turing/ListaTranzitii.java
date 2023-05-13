
package masina.turing;
import java.util.*;
import java.util.ArrayList;

public class ListaTranzitii {
    private ArrayList<Tranzitie> tranzitii;

    public ListaTranzitii() {
        tranzitii = new ArrayList<Tranzitie>();
    }

    public void adaugaTranzitie(Tranzitie tranzitie) {
        tranzitii.add(tranzitie);
    }

    public Tranzitie getTranzitie(String stareCurenta, char simbolCitit) {
        for (Tranzitie tranzitie : tranzitii) {
            if (tranzitie.getStareCurenta() == stareCurenta && tranzitie.getSimbolCitit() == simbolCitit) {
                return tranzitie;
            }
        }
        return null;
    }
}
    
    
    

