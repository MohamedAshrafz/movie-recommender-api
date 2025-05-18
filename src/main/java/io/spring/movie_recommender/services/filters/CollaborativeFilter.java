package io.spring.movie_recommender.services.filters;


import io.spring.movie_recommender.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(MovieFiltersNames.COLLABORATIVE_FILTER_BEAN_NAME)
public class CollaborativeFilter implements MoviesFilter {
    public CollaborativeFilter() {
        System.out.println("The CollaborativeFilter bean constructor was called, creating the bean ..");
    }

    public List<Movie> getRecommendations(String movie) {
        return List.of(new Movie(7, "Finding Nemo", 8.5),
                new Movie(8, "Ice Age", 8.7),
                new Movie(9, "Toy Story", 8.1));
    }

    @Autowired
    private Movie movie;

    @Override
    public Movie getMovie() {
        return movie;
    }
}
