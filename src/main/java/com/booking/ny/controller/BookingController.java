package com.booking.ny.controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;

import com.booking.ny.service.BookingService;
import com.booking.ny.wrapper.ConfirmSeatListBody;
import com.booking.ny.wrapper.ReserveSeatListBody;
import com.booking.ny.error.SeatsNotAvailableException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.booking.ny.entity.Movie;
import com.booking.ny.model.CustomerDTO;

import com.booking.ny.repository.MovieRepository;

import org.springframework.transaction.annotation.Transactional;


@RestController
@Transactional(rollbackFor = Exception.class)
public class BookingController {
    
    @Autowired
    private BookingService bookingService;
    

    @Autowired
    private MovieRepository movieRepository;

    //get all seats for the current movie
    @RequestMapping(value = "booking/getSeatsByMovieId/{movieId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getSeatsByMovieId(@PathVariable("movieId") int movieId){
        JSONObject jsonObject = bookingService.getSeatsByMovieId(movieId);
        return new ResponseEntity<>(jsonObject.toString(),HttpStatus.OK);
    }



    

    //reserve the seat
    @RequestMapping(value = "booking/reserveSeat", method = RequestMethod.POST, produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> reserveSeat(@Valid @RequestBody ReserveSeatListBody reserveSeatListBody) throws SeatsNotAvailableException,Exception{

        JSONObject jsonObject = bookingService.reserveSeat(reserveSeatListBody.getSeats());
        return new ResponseEntity<>(jsonObject.toString(),HttpStatus.OK);
    }




    	
	@Scheduled(cron = "0 0/5 * * * ?")
	public void clearExpiredBlockedReservations() {
		System.out.println("*** Clearing blocked reservations that have expired ***");
		bookingService.clearExpiredBlockedReservations();
        System.out.println("*** Clearing blocked reservations that have expired ***");
	}

    
    //get customer by username
    @RequestMapping(value = "booking/getCustomerByName/{name}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getCustomerByName(@PathVariable("name") String name) throws Exception{
        JSONObject jsonObject = bookingService.getCustomerByName(name);
        return new ResponseEntity<>(jsonObject.toString(),HttpStatus.OK);
    }

    //Confirm Booking
    @RequestMapping(value = "booking/confirm", method = RequestMethod.POST, produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> confirmBooking(@Valid @RequestBody ConfirmSeatListBody confirmSeatListBody) throws Exception{
        JSONObject jsonObject = bookingService.confirmBooking(confirmSeatListBody);
        return new ResponseEntity<>(jsonObject.toString(),HttpStatus.OK);
    }




    //get all customer
    @RequestMapping(value = "booking/getAllCustomers", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getAllCustomers() throws Exception{
        JSONObject jsonObject = bookingService.getAllCustomers();
        return new ResponseEntity<>(jsonObject.toString(),HttpStatus.OK);
    }

    
    @RequestMapping(value = "/movies", method = RequestMethod.GET, produces = "application/json") 
    @ResponseBody 
    public ResponseEntity<?> getMovies() throws Exception{ 
        List<Movie> movieList = new ArrayList<>();
        movieList.addAll(movieRepository.findAll());


        return new ResponseEntity<List<Movie>>(HttpStatus.OK); 
    }

    //get all movies
    @RequestMapping(value = "booking/getAllMovies", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getAllMovies() throws Exception{
        JSONObject jsonObject = bookingService.getAllMovies();
        return new ResponseEntity<>(jsonObject.toString(),HttpStatus.OK);
    }

    
    //get all movies by movie name
    @RequestMapping(value = "booking/getAllMoviesByName/{name}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getAllMoviesByName(@Valid @PathVariable("name") String name) throws Exception{
        JSONObject jsonObject = bookingService.getAllMoviesByName(name);
        return new ResponseEntity<>(jsonObject.toString(),HttpStatus.OK);
    }



}
