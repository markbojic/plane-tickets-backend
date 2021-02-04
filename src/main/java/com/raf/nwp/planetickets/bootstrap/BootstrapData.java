package com.raf.nwp.planetickets.bootstrap;

import com.raf.nwp.planetickets.model.*;
import com.raf.nwp.planetickets.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AirlineRepository airlineRepository;
    private final CityRepository cityRepository;
    private final FlightRepository flightRepository;
    private final ReservationRepository reservationRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public BootstrapData(AirlineRepository airlineRepository, CityRepository cityRepository, FlightRepository flightRepository, ReservationRepository reservationRepository, TicketRepository ticketRepository, UserRepository userRepository) {
        this.airlineRepository = airlineRepository;
        this.cityRepository = cityRepository;
        this.flightRepository = flightRepository;
        this.reservationRepository = reservationRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();

        Airline airline = new Airline();
        airline.setName("AirSerbia");
        Airline airline2 = new Airline();
        airline2.setName("WizzAir");
        Airline airline3 = new Airline();
        airline3.setName("United Airlines");
        Airline airline4 = new Airline();
        airline4.setName("Lufthansa");
        airlineRepository.save(airline);
        airlineRepository.save(airline2);
        airlineRepository.save(airline3);
        airlineRepository.save(airline4);

        City city1 = new City();
        city1.setName("Belgrade");
        City city2 = new City();
        city2.setName("New York");
        City city3 = new City();
        city3.setName("London");
        City city4 = new City();
        city4.setName("Los Angeles");
        City city5 = new City();
        city5.setName("Amsterdam");
        City city6 = new City();
        city6.setName("Berlin");
        City city7 = new City();
        city7.setName("Barcelona");
        cityRepository.save(city1);
        cityRepository.save(city2);
        cityRepository.save(city3);
        cityRepository.save(city4);
        cityRepository.save(city5);
        cityRepository.save(city6);
        cityRepository.save(city7);

        MyUser myUser = new MyUser();
        myUser.setUsername("elonmusk");
        myUser.setUserType(UserType.USER);
        myUser.setPassword(passEncoder.encode("Mars2030"));
        userRepository.save(myUser);
        MyUser admin = new MyUser();
        admin.setUsername("admin");
        admin.setPassword(passEncoder.encode("Passw0rd"));
        admin.setUserType(UserType.ADMIN);
        userRepository.save(admin);

        Flight flight1 = new Flight();
        flight1.setOrigin(city1);
        flight1.setDestination(city2);
        flightRepository.save(flight1);
        Flight flight2 = new Flight();
        flight2.setOrigin(city3);
        flight2.setDestination(city1);
        flightRepository.save(flight2);
        Flight flight3 = new Flight();
        flight3.setOrigin(city4);
        flight3.setDestination(city2);
        flightRepository.save(flight3);
        Flight flight4 = new Flight();
        flight4.setOrigin(city4);
        flight4.setDestination(city3);
        flightRepository.save(flight4);
        Flight flight5 = new Flight();
        flight5.setOrigin(city1);
        flight5.setDestination(city5);
        flightRepository.save(flight5);
        Flight flight6 = new Flight();
        flight6.setOrigin(city6);
        flight6.setDestination(city7);
        flightRepository.save(flight6);
        Flight flight7 = new Flight();
        flight7.setOrigin(city7);
        flight7.setDestination(city1);
        flightRepository.save(flight7);

        Ticket tck1 = new Ticket();
        tck1.setAirline(airline);
        tck1.setCount(Long.parseLong("10"));
        tck1.setOneWay(false);
        tck1.setDepartOn(sdf.parse("10-12-2021"));
        tck1.setReturnOn(sdf.parse("12-12-2021"));
        tck1.setFlight(flight1);
        ticketRepository.save(tck1);
        Ticket tck2 = new Ticket();
        tck2.setAirline(airline3);
        tck2.setCount(Long.parseLong("50"));
        tck2.setOneWay(false);
        tck2.setDepartOn(sdf.parse("3-3-2021"));
        tck2.setReturnOn(sdf.parse("10-3-2021"));
        tck2.setFlight(flight3);
        ticketRepository.save(tck2);
        Ticket tck3 = new Ticket();
        tck3.setAirline(airline2);
        tck3.setCount(Long.parseLong("50"));
        tck3.setOneWay(true);
        tck3.setDepartOn(sdf.parse("6-6-2021"));
        tck3.setFlight(flight2);
        ticketRepository.save(tck3);
        Ticket tck4 = new Ticket();
        tck4.setAirline(airline3);
        tck4.setCount(Long.parseLong("40"));
        tck4.setOneWay(true);
        tck4.setDepartOn(sdf.parse("10-7-2021"));
        tck4.setFlight(flight4);
        ticketRepository.save(tck4);
        Ticket tck5 = new Ticket();
        tck5.setAirline(airline);
        tck5.setCount(Long.parseLong("40"));
        tck5.setOneWay(false);
        tck5.setDepartOn(sdf.parse("31-4-2021"));
        tck5.setReturnOn(sdf.parse("13-5-2021"));
        tck5.setFlight(flight5);
        ticketRepository.save(tck5);
        Ticket tck6 = new Ticket();
        tck6.setAirline(airline4);
        tck6.setCount(Long.parseLong("120"));
        tck6.setOneWay(false);
        tck6.setDepartOn(sdf.parse("6-6-2021"));
        tck6.setReturnOn(sdf.parse("1-7-2021"));
        tck6.setFlight(flight6);
        ticketRepository.save(tck6);
        Ticket tck7 = new Ticket();
        tck7.setAirline(airline2);
        tck7.setCount(Long.parseLong("160"));
        tck7.setOneWay(true);
        tck7.setDepartOn(sdf.parse("18-8-2022"));
        tck7.setFlight(flight7);
        ticketRepository.save(tck7);

        flight1.addTicket(tck1);
        flightRepository.save(flight1);
        //System.out.println(flight1.getSize());
        //System.out.println(flightRepository.findById(Long.parseLong("1")).get().getTickets().size());
        flight3.addTicket(tck2);
        flightRepository.save(flight3);
        flight2.addTicket(tck3);
        flightRepository.save(flight2);
        flight4.addTicket(tck4);
        flightRepository.save(flight4);
        flight5.addTicket(tck5);
        flightRepository.save(flight5);
        flight6.addTicket(tck6);
        flightRepository.save(flight6);
        flight7.addTicket(tck7);
        flightRepository.save(flight7);

        Reservation rsvr = new Reservation();
        rsvr.setAvailable(true);
        rsvr.setTicket(tck1);
        rsvr.setFlight(flight1);
        reservationRepository.save(rsvr);

        myUser.addBooking(rsvr);
        userRepository.save(myUser);
        //System.out.println(userRepository.findById(Long.parseLong("1")).get().getBookings().size());

        System.out.println("Data loaded!");
    }
}
