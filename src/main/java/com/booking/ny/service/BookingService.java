package com.booking.ny.service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.booking.ny.entity.Customer;
import com.booking.ny.entity.Movie;
import com.booking.ny.entity.Seat;
import com.booking.ny.entity.Reservation;
// import com.booking.ny.entity.SeatReserved;

import com.booking.ny.model.CustomerDTO;
import com.booking.ny.model.MovieDTO;
// import com.booking.ny.model.SeatReservedDTO;

import com.booking.ny.repository.CustomerRepository;
import com.booking.ny.repository.MovieRepository;
import com.booking.ny.repository.SeatRepository;
import com.booking.ny.wrapper.ConfirmSeatListBody;
import com.booking.ny.repository.ReservationRepository;
import com.booking.ny.error.MissingCustomerError;
// import com.booking.ny.repository.SeatReservedRepository;
import com.booking.ny.error.SeatsNotAvailableException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;

@Service
@Transactional(rollbackFor = Exception.class)
public class BookingService {
    
    @Autowired
    private SeatRepository seatRepository;
    
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    // @Autowired
    // private SeatReservedRepository seatReservedRepository;
    @Autowired
    private EmailSendService emailService;
    
    ModelMapper modelMapper = new ModelMapper();

    
    public JSONObject getSeatsByMovieId(int movieId)throws JSONException {
        List<Seat> seatList =seatRepository.getSeatsByMovieId(movieId);

        JSONObject returnJSONObject = new JSONObject();
        JSONArray seatArray = new JSONArray();

        if(seatList!=null||seatList.size()>0 ) {
            for(Seat seat : seatList){
                JSONObject seatObj = new JSONObject();
                seatObj.put("Seat ID No." , seat.getSeatId());
                seatObj.put("Seat Type" , seat.getSeatType());
                seatObj.put("Seat Number" , seat.getSeatNumber());
                seatObj.put("Seat price" , seat.getPrice());
                seatObj.put("Seat Name" , seat.getSeatName());
                if(seat.getReservation()!=null){
                    
                    List<Reservation> reservationList = seat.getReservation();
                    JSONArray resArray = new JSONArray();
                    for(Reservation reservation : reservationList){
                        JSONObject resObj = new JSONObject();
                        resObj.put("Reservation ID No." , reservation.getReservationId());
                        resObj.put("Reservation Status" , reservation.getReservationStatus());
                        resArray.put(resObj);
                    }
                    seatObj.put("reservationList",resArray);

                }
                seatArray.put(seatObj);
            }
        }
        returnJSONObject.put("List of Seats",seatArray);
        return returnJSONObject;
    }


    public void clearExpiredBlockedReservations(){
        reservationRepository.clearExpiredBlockedReservations();
    }
    


    @Transactional(rollbackFor = Exception.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW)
     public JSONObject reserveSeat(List<Long> seatIdList) throws Exception{
        

         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

         List<Reservation> selectedSeats = reservationRepository.lockSeatsForUpdate(seatIdList);
        
         if(selectedSeats.size() != seatIdList.size()){
            //lock seats for up
           throw new SeatsNotAvailableException();
         }
         long currentTime = System.currentTimeMillis();
         Timestamp now = new Timestamp(currentTime);
         Timestamp expire = new Timestamp(currentTime + TimeUnit.MINUTES.toMillis(10));

         reservationRepository.updateSeatsToBlocked(seatIdList,now,expire);


         JSONObject returnJSONObject = new JSONObject();
         returnJSONObject.put("Success",seatIdList);
         return returnJSONObject;
     }




    public JSONObject getCustomerByName(String name)throws JSONException {

        JSONObject returnJSONObject = new JSONObject();
        
        Customer customer =customerRepository.findByCustomerName(name);
        if(customer!=null) {
            returnJSONObject.put("Customer ID No." , customer.getCustomerId());
            returnJSONObject.put("name" , customer.getCustomerName());
            returnJSONObject.put("Contact Number" , customer.getContactNumber());
            returnJSONObject.put("email" , customer.getEmail());
        }
        
        return returnJSONObject;
    }




    public JSONObject getAllCustomers()throws JSONException {

        JSONObject returnJSONObject = new JSONObject();
        
        List<Customer> customerList =customerRepository.findAll();

        JSONArray customerArray = new JSONArray();

        if(customerList.size()>0||customerList!=null ) {
            for(Customer customer : customerList){
                JSONObject customerObj = new JSONObject();
                customerObj.put("Customer ID No." , customer.getCustomerId());
                customerObj.put("name" , customer.getCustomerName());
                customerObj.put("Contact Number" , customer.getContactNumber());
                customerObj.put("email" , customer.getEmail());
                customerArray.put(customerObj);
            }
            
        }
        returnJSONObject.put("List of Customers", customerArray);
        return returnJSONObject;
    }


    public JSONObject getAllMovies()throws JSONException {

        JSONObject returnJSONObject = new JSONObject();
        
        List<Movie> movieList =movieRepository.findAll();

        JSONArray movieArray = new JSONArray();

        if(movieList.size()>0 ||movieList!=null) {
            for(Movie movie : movieList){
                JSONObject movieObj = new JSONObject();
                movieObj.put("Movie ID No." , movie.getMovieId());
                movieObj.put("name" , movie.getMovieName());
                movieObj.put("description" , movie.getDescription());
                movieObj.put("duration" , movie.getDuration());
                movieObj.put("genre" , movie.getGenre());
                movieObj.put("release date" , movie.getReleaseDate());
                movieObj.put("start time" , movie.getStartTime());
                movieObj.put("poster link" , movie.getMoviePosterLink());
                movieArray.put(movieObj);
            }
            
        }
        returnJSONObject.put("List of Movies", movieArray);
        return returnJSONObject;
    }

    public JSONObject getAllMoviesByName(String name)throws JSONException {

        JSONObject returnJSONObject = new JSONObject();
        
        List<Movie> movieList =movieRepository.findMovieByName(name);

        JSONArray movieArray = new JSONArray();

        if(movieList.size()>0 ||movieList!=null) {
            for(Movie movie : movieList){
                JSONObject movieObj = new JSONObject();
                movieObj.put("Movie ID No." , movie.getMovieId());
                movieObj.put("name" , movie.getMovieName());
                movieObj.put("description" , movie.getDescription());
                movieObj.put("duration" , movie.getDuration());
                movieObj.put("genre" , movie.getGenre());
                movieObj.put("release date" , movie.getReleaseDate());
                movieObj.put("start time" , movie.getStartTime());
                movieObj.put("poster link" , movie.getMoviePosterLink());
                if(movie.getSeats()!=null){
                    
                    List<Seat> seatList = movie.getSeats();
                    JSONArray seatArray = new JSONArray();
                    for(Seat seat : seatList){
                        JSONObject seatObj = new JSONObject();
                        seatObj.put("Seat ID No." , seat.getSeatId());
                        seatObj.put("Seat Type" , seat.getSeatType());
                        seatObj.put("Seat Number" , seat.getSeatNumber());
                        seatObj.put("Seat price" , seat.getPrice());
                        seatObj.put("Seat Name" , seat.getSeatName());
                        seatArray.put(seatObj);
                    }
                    movieObj.put("reservationList",seatArray);
    
                }
                movieArray.put(movieObj);
            }
            
        }
        returnJSONObject.put("List of Movies", movieArray);
        return returnJSONObject;
    }


    @Transactional(rollbackFor = Exception.class)
    public JSONObject confirmBooking(ConfirmSeatListBody confirmSeatListBody) throws Exception{
        JSONObject returnJSONObject = new JSONObject();
        ModelMapper modelMapper = new ModelMapper();
        CustomerDTO customerDTO = confirmSeatListBody.getCustomerDTO();
        List<Long> seatIdList = confirmSeatListBody.getSeats();
        String[] seatNames = confirmSeatListBody.getSeatNames();
        double totalAmount = confirmSeatListBody.getTotalAmount();
        String movieName = confirmSeatListBody.getMovieName();
        String movieLink = confirmSeatListBody.getMoviePosterlink();



        if(customerDTO!=null){
            Customer customer = modelMapper.map(customerDTO, Customer.class);
            //Customer customer = new Customer(customerDTO.getCustomerName(),customerDTO.getUserName(),customerDTO.getEmail());
            
            Customer customerSaved= customerRepository.saveAndFlush(customer);
            Timestamp now = new Timestamp(System.currentTimeMillis());
            reservationRepository.confirmBooking(seatIdList,customerSaved.getCustomerId(),now);
            emailService.sendEmail(seatNames, totalAmount, movieName, movieLink,customerSaved.getCustomerName(),customerSaved.getEmail());
        }else{
            throw new MissingCustomerError(); 
        }
        
        
        return returnJSONObject;
    }
    


    


}
