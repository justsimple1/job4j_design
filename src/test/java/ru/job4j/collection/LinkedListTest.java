package ru.job4j.collection;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class LinkedListTest {
    @Test
    public void whenAddThenGet() {
        LinkedList<String> array = new LinkedList<>();
        array.add("first");
        String rsl = array.get(0);
        assertThat(rsl, is("first"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetNonExistentThenIndexOutOfBoundsException() {
        LinkedList<String> array = new LinkedList<>();
        array.add("first");
        array.get(1);
    }


}