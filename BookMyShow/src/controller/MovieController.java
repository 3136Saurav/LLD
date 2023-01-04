package controller;

import entity.City;
import entity.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> cityVsMovie;
    List<Movie> allMovies;

    public MovieController() {
        this.cityVsMovie = new HashMap<>();
        this.allMovies = new ArrayList<>();
    }

    public void addMovie(Movie movie, City city) {
        allMovies.add(movie);
        List<Movie> moviesInACity = cityVsMovie.getOrDefault(city, new ArrayList<>());
        moviesInACity.add(movie);
        cityVsMovie.put(city, moviesInACity);
    }

    public Movie getMovieByName(String movieName) {
        for (Movie movie : allMovies) {
            if (movie.getMovieName().equals(movieName)) {
                return movie;
            }
        }

        return null;
    }
}
