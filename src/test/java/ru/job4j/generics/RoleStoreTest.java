package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class RoleStoreTest {

    private  RoleStore roleStore = new RoleStore();
    private Role actor =  new Role("first");
    private Role policeman = new Role("second");
    private Role doctor = new Role("third");

    @Before
    public void setUp() {
        roleStore.add(actor);
        roleStore.add(policeman);
        roleStore.add(doctor);
    }

    @Test
    public void whenReplaceThanTrue() {
        boolean rsl = roleStore.replace("third", new Role("fourth"));
        assertThat(rsl, is(true));
    }

    @Test
    public void whenFindExistentEl() {
        assertThat(roleStore.findById("third"), is(doctor));
    }

    @Test
    public void whenDeleteExistentElThanTrue() {
        assertThat(roleStore.delete("second"), is(true));
    }

    @Test
    public void whenDeleteElAndFindHimThanNull() {
        roleStore.delete("second");
        assertEquals(roleStore.findById("second"), null);
    }

}