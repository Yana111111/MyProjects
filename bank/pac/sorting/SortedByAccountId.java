package pac.sorting;


import pac.FactoryAccount;

import java.util.Comparator;
/**
 * This is the class of SortedByAccountId
 *
 * @author Yana Nestsiukovich
 */
public class SortedByAccountId  implements Comparator<FactoryAccount> {
    @Override
    public int compare(FactoryAccount o1, FactoryAccount o2) {
        int owner1 = o1.getId();
        int owner2 = o2.getId();
        if (owner1 > owner2){
            return 1;
        }
        else if (owner1 < owner2){
            return -1;
        }
        else {
            return 0;
        }
    }
}