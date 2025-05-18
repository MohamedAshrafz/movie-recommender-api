package io.spring.movie_recommender.controllers;

import io.spring.movie_recommender.services.MovieRecommender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationsController {

    private final MovieRecommender movieRecommender;

    @Autowired
    public RecommendationsController(MovieRecommender movieRecommender) {
        this.movieRecommender = movieRecommender;
    }

//    @RequestMapping(method = RequestMethod.GET, value = "recommendation")
    //OR
    @GetMapping("recommendations")
    public String getRecommendations() {
        return String.format("Your Fav movie is: [%s], The recommended movies are: %s",
                movieRecommender.getFavMovie(),
                movieRecommender.recommendMovies("Dora"));
    }
}
