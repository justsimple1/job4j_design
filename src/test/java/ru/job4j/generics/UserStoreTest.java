package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class UserStoreTest {

    private  UserStore userStore = new UserStore();
    private User actor =  new User("first");
    private User policeman = new User("second");
    private User doctor = new User("third");

    @Before
    public void setUp() {
        userStore.add(actor);
        userStore.add(policeman);
        userStore.add(doctor);
    }

    @Test
    public void whenReplaceThanTrue() {
        boolean rsl = userStore.replace("third", new User("fourth"));
        assertThat(rsl, is(true));
    }

    @Test
    public void whenFindExistentEl() {
        assertThat(userStore.findById("third"), is(doctor));
    }

    @Test
    public void whenDeleteExistentElThanTrue() {
        assertThat(userStore.delete("second"), is(true));
    }

    @Test
    public void whenDeleteElAndFindHimThanNull() {
        userStore.delete("second");
        assertEquals(userStore.findById("second"), null);
    }

}