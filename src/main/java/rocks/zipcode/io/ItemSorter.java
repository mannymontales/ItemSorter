package rocks.zipcode.io;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author leon on 30/01/2019.
 */
public class ItemSorter {

    private Item[] items;
    public ItemSorter(Item[] items) {
        this.items = items;
    }

    public Item[] sort(Comparator<Item> comparator) {
        //could not sort original Item[] array because it is not a collection
        //creating new list with items as elements
        List<Item> itemsAsList = Arrays.asList(items);
        //call sort method based on the comparator, all three classes id, name, and price all implement comparator that is why the line of code below is not getting mad
        //because it knows that whatever is getting passed into itemsAsList.sort(x) is comparable
        itemsAsList.sort(comparator);
        return items;
    }
}
