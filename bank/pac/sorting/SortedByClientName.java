package pac.sorting;

import pac.Client;

import java.util.Comparator;
/**
 * This is the class of SortedByClientName
 *
 * @author Yana Nestsiukovich
 */
public class SortedByClientName  implements Comparator<Client> {
    @Override
    public int compare(Client o1, Client o2) {
        String owner1 = o1.getFIO();
        String owner2 = o2.getFIO();
        return owner1.compareTo(owner2);
    }
}
