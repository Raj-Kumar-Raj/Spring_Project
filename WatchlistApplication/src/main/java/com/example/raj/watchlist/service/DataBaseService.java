package com.example.raj.watchlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.raj.watchlist.entity.Movie;
import com.example.raj.watchlist.repository.MovieRepository;
@Service
public class DataBaseService {
     @Autowired
    MovieRepository movieRepo;
     @Autowired
     RatingService ratingservice;
	public void create(Movie movie) {
		String rating=ratingservice.getMovieRating(movie.getTitle());
		if(rating!=null) {
			movie.setRating(Float.parseFloat(rating));
		}
		movieRepo.save(movie);
	}
	
	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
	}

	public Movie getMovieById(Integer id) {
	      return movieRepo.findById(id).get();
	   }
	public void update(Movie movie, Integer id) {
	      Movie toBeUpdated = this.getMovieById(id);
	      toBeUpdated.setTitle(movie.getTitle());
	      toBeUpdated.setRating(movie.getRating());
	      toBeUpdated.setComment(movie.getComment());
	      toBeUpdated.setPriority(movie.getPriority());
	      this.movieRepo.save(toBeUpdated);
	   }
}
