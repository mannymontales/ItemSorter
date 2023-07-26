package rocks.zipcode.io.comparators;

import rocks.zipcode.io.Item;

import java.util.Comparator;

/**
 * @author leon on 30/01/2019.
 */
public class PriceComparator implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {

        //Compares its two arguments for order.
        // Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
//        if (o1.getPrice() < o2.getPrice()){
//            return -1;
//        } else if (o1.getPrice() > o2.getPrice()) {
//            return 1;
//        } else  {
//            return 0;
//        }
        return o1.getPrice().compareTo(o2.getPrice());
        //this didnt work because we casted a double to a int so the program could not tell which one was greater than each other
        //return (int) (o1.getPrice() - o2.getPrice());
    }
}
