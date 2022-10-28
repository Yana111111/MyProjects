package pac.sorting;

import pac.Client;
import pac.FactoryAccount;

import java.util.Comparator;
/**
 * This is the class of SortedByClientId
 *
 * @author Yana Nestsiukovich
 */
public class SortedByClientId  implements Comparator<Client> {
    @Override
    public int compare(Client o1, Client o2) {
        int client1 = o1.getId();
        int client2 = o2.getId();
        if (client1 > client2){
            return 1;
        }
        else if (client1 < client2){
            return -1;
        }
        else {
            return 0;
        }
    }
}
