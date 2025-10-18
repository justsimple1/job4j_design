package ru.job4j.iterator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ArrayItTest {

    @Test
    void whenMultiCallHasNextThenTrue() {
        /* Arrange - создание объекта и заполнение его данными */
        ArrayIt iterator = new ArrayIt(
                new int[] {1, 2, 3}
        );
        /* Act - выполнение действия и сохранение результата */
        boolean result = iterator.hasNext();
        /* Assert - оценка соответствия результата ожидаемому исходу */
        assertThat(result).isTrue();
        /* этапы Act и Assert могут быть размещены в одной строке кода */
        assertThat(iterator.hasNext()).isTrue();
    }

    @Test
    void whenReadSequence() {
        ArrayIt iterator = new ArrayIt(
                new int[] {1, 2, 3}
        );
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(3);
    }
}