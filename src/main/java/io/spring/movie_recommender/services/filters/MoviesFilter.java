package io.spring.movie_recommender.services.filters;



import io.spring.movie_recommender.models.Movie;

import java.util.List;

public interface MoviesFilter {
    public List<Movie> getRecommendations(String movie);

    public Movie getMovie();
}
