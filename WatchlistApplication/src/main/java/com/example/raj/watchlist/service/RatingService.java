package com.example.raj.watchlist.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RatingService {
   String apiUrl = "https://www.omdbapi.com/?apikey=a8431cee&t=";

   public String getMovieRating(String title) {
      try { // try to fetch rating by calling ombd api
    	  // Rest templete is used to call API and act as postman 
         RestTemplate template = new RestTemplate();
         // response entity wrap json object the , jaon object came as respone after requesting 
         ResponseEntity<ObjectNode> response = template.getForEntity(this.apiUrl + title, ObjectNode.class, new Object[0]);
         // response object me se json object ki body nikal liya 
         ObjectNode jsonObject = (ObjectNode)response.getBody();
         System.out.println(jsonObject.path("imdbRating").asText());
         return jsonObject.path("imdbRating").asText();
      } catch (Exception var5) {
    	  // to user eneterd rating will taken 
         System.out.println("Either movie name not available or api is down" + var5.getMessage());
         return null;
      }
   }
}