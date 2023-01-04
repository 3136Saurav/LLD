package controller;

import entity.City;
import entity.Movie;
import entity.Show;
import entity.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> cityVsTheatreMap;
    List<Theatre> allTheatres;

    public TheatreController() {
        this.cityVsTheatreMap = new HashMap<>();
        this.allTheatres = new ArrayList<>();
    }

    public void addTheatre(Theatre theatre, City city) {
        allTheatres.add(theatre);
        List<Theatre> theatresInACity = cityVsTheatreMap.getOrDefault(city, new ArrayList<>());
        theatresInACity.add(theatre);
        cityVsTheatreMap.put(city, theatresInACity);
    }

    public Map<Theatre, List<Show>> getAllShows(Movie movie, City city) {
        Map<Theatre, List<Show>> showsInATheatre = new HashMap<>();
        List<Theatre> theatres = cityVsTheatreMap.get(city);

        for (Theatre theatre : theatres) {
            List<Show> shows = theatre.getShowList();
            List<Show> showsOfAMovie = new ArrayList<>();

            for (Show show : shows) {
                if (show.getMovie().equals(movie)) {
                    showsOfAMovie.add(show);
                }
            }

            if (!showsOfAMovie.isEmpty()) {
                showsInATheatre.put(theatre, showsOfAMovie);
            }

        }

        return showsInATheatre;
    }
}
