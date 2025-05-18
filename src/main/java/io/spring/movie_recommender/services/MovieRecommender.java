package io.spring.movie_recommender.services;


import io.spring.movie_recommender.models.Movie;
import io.spring.movie_recommender.services.filters.MovieFiltersNames;
import io.spring.movie_recommender.services.filters.MoviesFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieRecommender {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // wiring by names

    private MoviesFilter filter;

    @Autowired
    public void setFilter(@Qualifier(MovieFiltersNames.CONTENT_BASED_FILTER_BEAN_NAME) MoviesFilter filter) {
        logger.info("In RecommenderImplementation setter method..dependency injection");
        this.filter = filter;
    }

    public MoviesFilter getFilter() {
        return filter;
    }

    public List<Movie> recommendMovies(String movie) {
        System.out.printf("The filter used in recommending is: [%s]\n", filter.getClass().getSimpleName());

        return filter.getRecommendations(movie);
    }

    // ${name of the parameter in the app properties file:default value if there's no entry}
    @Value("${recommender.favoriteMovie:Finding Dory}")
    private String favMovie;

    public String getFavMovie() {
        return favMovie;
    }
}
