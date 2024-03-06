package ru.netology.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {

    @Test
    public void testAddMovieAndFindAll() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Чужой");
        manager.addMovie("Чужие ");
        manager.addMovie("Чужой  3");

        String[] expected = {"Чужой", "Чужие ", "Чужой  3"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void testFindLastDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Чужой");
        manager.addMovie("Чужие ");
        manager.addMovie("Чужой  3");
        manager.addMovie("Чужой Воскрешение");
        manager.addMovie("Прометей");
        manager.addMovie("Завет");

        String[] expected = {"Завет", "Прометей", "Чужой Воскрешение", "Чужой  3", "Чужие "};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void testFindLastCustomLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Чужой");
        manager.addMovie("Чужие ");
        manager.addMovie("Чужой  3");
        manager.addMovie("Чужой Воскрешение");

        String[] expected = {"Чужой Воскрешение", "Чужой  3", "Чужие "};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void testFindLastLessThanLimit() {
        MovieManager manager = new MovieManager(5);
        manager.addMovie("Чужой");

        String[] expected = {"Чужой"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void testFindLastEqualToLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Чужой");
        manager.addMovie("Чужие ");
        manager.addMovie("Чужой  3");

        String[] expected = {"Чужой  3", "Чужие ", "Чужой"};
        assertArrayEquals(expected, manager.findLast());
    }
}





