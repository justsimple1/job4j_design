package ru.job4j.collection;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {

    @Test
    public void whenAddNewElThanTrue() {
        SimpleSet<String> set = new SimpleSet<>();
        assertThat(set.add("first"), is(true));
    }

    @Test
    public void whenAddExistentElThanFalse() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("first");
        assertThat(set.add("first"), is(false));
    }
}