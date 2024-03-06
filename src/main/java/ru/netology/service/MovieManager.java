package ru.netology.service;

import java.util.Arrays;

public class MovieManager {


    private String[] movies;
    private int limit;

    public MovieManager() {
        this.movies = new String[0];
        this.limit = 5;
    }

    public MovieManager(int limit) {
        this.movies = new String[0];
        this.limit = limit;
    }


    public void addMovie(String movie) {
        String[] newMovies = Arrays.copyOf(movies, movies.length + 1);
        newMovies[movies.length] = movie;
        movies = newMovies;
    }


    public String[] findAll() {
        return movies;
    }


    public String[] findLast() {
        int resultLength = Math.min(limit, movies.length);
        String[] result = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }
}


