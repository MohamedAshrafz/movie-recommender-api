package io.spring.movie_recommender.services.filters;


import io.spring.movie_recommender.models.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(MovieFiltersNames.CONTENT_BASED_FILTER_BEAN_NAME)
/** Important Note:

 Spring creates a singleton bean even before we ask for it,
 while a prototype bean is not created till we request Spring for the bean. In the code widget below */
@Primary
public class ContentBasedFilter implements MoviesFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //for keeping track of instances created
    private static int instances = 0;

    @Autowired
    private Movie movie;

    public ContentBasedFilter() {
        instances++;
        logger.info("In ContentBasedFilter constructor method");
    }

    public static int getInstances() {
        return ContentBasedFilter.instances;
    }

    public List<Movie> getRecommendations(String movie) {
        return List.of(new Movie(1, "Happy Feet", 7.1),
                new Movie(2, "Ice Age", 7.3),
                new Movie(3, "Shark Tale", 7.7));
    }

    @Override
    public Movie getMovie() {
        return movie;
    }
}
