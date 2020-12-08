package ru.job4j.generics;

import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {

    @Test
    public void whenAddToArray() {
        SimpleArray<Integer> numbers = new SimpleArray(5);
        Iterator<Integer> it = numbers.iterator();
        assertThat(numbers.add(13), is(true));
        assertThat(it.next(), is(13));
    }

    @Test
    public void whenSetThanTrue() {
        SimpleArray<Integer> numbers = new SimpleArray(5);
        Iterator<Integer> it = numbers.iterator();
        numbers.add(13);
        assertThat(numbers.set(0, 15), is(true));
        assertThat(it.next(), is(15));
    }

    @Test
    public void whenRemoveThanTrue() {
        SimpleArray<String> numbers = new SimpleArray(5);
        Iterator<String> it = numbers.iterator();
        numbers.add("first");
        numbers.add("second");
        numbers.add("third");
        assertThat(numbers.remove(1), is(true));
        assertThat(it.next(), is("first"));
        assertThat(it.next(), is("third"));
    }
}