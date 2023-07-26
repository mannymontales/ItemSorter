package rocks.zipcode.io.itemsorter;

import org.junit.Assert;
import org.junit.Test;
import rocks.zipcode.io.Item;
import rocks.zipcode.io.ItemSorter;
import rocks.zipcode.io.comparators.IdComparator;
import rocks.zipcode.io.comparators.PriceComparator;

import java.util.Comparator;

/**
 * @author leon on 30/01/2019.
 */
public class SortByPriceTest {

    @Test
    public void test1() {
        // given
        Item item3 = new Item(0L, "Apple", 1.0);
        Item item2 = new Item(1L, "Banana", 3.0);
        Item item1 = new Item(2L, "Cherry", 2.0);
        Item[] itemsToSort = {item3, item2, item1};
        Item[] expected = {item3, item1, item2};
        ItemSorter itemSorter = new ItemSorter(itemsToSort);
        Comparator<Item> comparator = (Comparator<Item>) new PriceComparator();

        // when
        Item[] actual = itemSorter.sort(comparator);

        // then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        // given
        Item item3 = new Item(0L, "Apple", 1.0);
        Item item2 = new Item(1L, "Banana", 3.0);
        Item item1 = new Item(2L, "Cherry", 2.0);
        Item item4 = new Item(2L, "Cherry", 2.0);
        Item item5 = new Item(2L, "Cherry", 2.0);

        //If the comparator sets two objects as equal it stores them in the order they were added in ex itemsToSort = 1, 5, 4
        Item[] itemsToSort = {item3, item2, item1, item5, item4};
        Item[] expected = {item3, item1, item5, item4, item2};


        ItemSorter itemSorter = new ItemSorter(itemsToSort);
        Comparator<Item> comparator = (Comparator<Item>) new PriceComparator();

        // when
        Item[] actual = itemSorter.sort(comparator);

        // then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void test3() {
        // given
        Item item3 = new Item(0L, "Apple", 1.0);
        Item item2 = new Item(1L, "Banana", 3.0);
        Item item1 = new Item(2L, "Cherry", 2.0);
        Item item4 = new Item(2L, "Cherry", 2.0);
        Item item5 = new Item(2L, "Cherry", 2.0);
        Item item6 = new Item();

        //instances of objects with values? come in the start
        Item[] itemsToSort = {item3, item2, item1, item5, item4, item6};
        Item[] expected = {item6, item3, item1, item5, item4, item2};


        ItemSorter itemSorter = new ItemSorter(itemsToSort);
        Comparator<Item> comparator = (Comparator<Item>) new PriceComparator();

        // when
        Item[] actual = itemSorter.sort(comparator);

        // then
        //System.out.println(String.valueOf(item6));
        Assert.assertArrayEquals(expected, actual);
    }
}
