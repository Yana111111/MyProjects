package pac.sorting;

import pac.FactoryAccount;

import java.util.Comparator;
/**
 * This is the class of SortedByAmountOfMoney
 *
 * @author Yana Nestsiukovich
 */
public class SortedByAmountOfMoney implements Comparator<FactoryAccount> {
    @Override
    public int compare(FactoryAccount o1, FactoryAccount o2) {
        double money1 = o1.getAmountOfMoney();
        double money2 = o2.getAmountOfMoney();

        if (money1 > money2){
            return 1;
        }
        else if (money1 < money2){
            return -1;
        }
        else {
            return 0;
        }
    }
}