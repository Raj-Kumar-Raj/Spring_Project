package com.example.raj.watchlist.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.raj.watchlist.entity.Movie;
import com.example.raj.watchlist.service.DataBaseService;

@RestController
public class MovieController {
		@Autowired
		DataBaseService databaseService;
      @GetMapping("/watchlistItemForm")
	public ModelAndView showWatchListForm(@RequestParam(required = false) Integer id) {
		  
		String viewName ="watchlistItemForm";
		Map<String, Object> model = new HashMap<>();
		//Movie dummyMovie = new Movie();
//		dummyMovie.setTitle("dummy");
//		dummyMovie.setRating(0);
//		dummyMovie.setPriority(0);
//		dummyMovie.setComment("Ton and john");
//		model.put("watchlistItem", dummyMovie);
		 if (id == null) {
	         model.put("watchlistItem", new Movie());
	      } else {
	         model.put("watchlistItem", this.databaseService.getMovieById(id));
	      }
	
		
		return new ModelAndView(viewName,model);
	}
      
      // this method post / insert the movie
      @PostMapping("/watchlistItemForm")
      public ModelAndView submitWatchListForm(@Valid @ModelAttribute("watchlistItem") Movie movie, BindingResult bindingResult) {
          if (bindingResult.hasErrors()) {
        	  // if error are ter e, display the form and let user enter again 
             System.out.println(bindingResult.hasErrors());
             return new ModelAndView("watchlistItemForm");
          }else {
    	  Integer id = movie.getId();
          if (id == null) {
             this.databaseService.create(movie);
          } else {
             this.databaseService.update(movie, id);
          }
    	  //redirecting on performing an action lead to other page 
    	  RedirectView rd = new RedirectView();
    	  rd.setUrl("/watchlist");
    	  
    	  return new ModelAndView(rd);
          }  
      }
      @GetMapping("/watchlist")
      public ModelAndView getWatchlist() {
    	  String viewName = "watchlist";
    	  Map<String,Object> model = new HashMap<>();
    	  List<Movie> movieList =databaseService.getAllMovies();
    	  model.put("watchlistrows", movieList);
    	  model.put("noofmovies", movieList.size());
    	  return new ModelAndView(viewName,model);
      }
}
