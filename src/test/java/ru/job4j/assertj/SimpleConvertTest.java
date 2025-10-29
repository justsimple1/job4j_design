package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import org.assertj.core.data.Index;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).first().isEqualTo("first");
        assertThat(list).last().isEqualTo("five");
        assertThat(list).filteredOnAssertions(e -> assertThat(e.length()).isLessThan(5))
                .hasSize(2)
                .first().isEqualTo("four");
        assertThat(list).element(2).isEqualTo("three");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "first", "three", "three", "five");
        assertThat(set).isNotNull().hasSize(3)
                .allMatch(e -> e.length() <= 5)
                .allSatisfy(e ->
                    assertThat(e).doesNotContain("second", "four")
        );
        assertThat(set).anySatisfy(e -> assertThat(e).doesNotContain("second", "four"));
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(map).containsValues(1, 4, 2)
                .containsKeys("second", "five", "first")
                .doesNotContainKey("null")
                .containsEntry("four", 3)
                .hasSize(5);
    }
}