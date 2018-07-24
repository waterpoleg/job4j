package ru.job4j.calculate.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;

public class ArrayDuplicateTest {
    @Test
    public void whenArrayHasDuplicatesThenRemoveThemAll() {
        String[] array = {"a", "a", "b", "b", "c", "d", "e", "e", "e"};
        String[] expect = {"a", "b", "c", "d", "e"};
        ArrayDuplicate dup = new ArrayDuplicate();
        String[] result = dup.remove(array);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}