package ru.job4j.it;

import org.hamcrest.core.Is;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2));
        ListUtils.addAfter(input, 1, 3);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenDeleteWithMethodRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListUtils.removeIf(input, e -> (e % 2 == 0));
        assertThat(Arrays.asList(1, 3, 5), Is.is(input));
    }

    @Test
    public void whenReplaceWithMethodReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListUtils.replaceIf(input, e -> (e % 2 == 0), 7);
        assertThat(Arrays.asList(1, 7, 3, 7, 5, 7), Is.is(input));
    }

    @Test
    public void whenReplaceWithMethodRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 9, 2, 145, 77, 33, 3, 145, 4, 5, 6));
        List<Integer> remove = new ArrayList<>(Arrays.asList(9, 145, 77, 33, 145, 6));
        ListUtils.removeAll(input, remove);
        assertThat(Arrays.asList(1, 2, 3, 4, 5), Is.is(input));
    }
}