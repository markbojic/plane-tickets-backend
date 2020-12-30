package com.raf.nwp.planetickets.bootstrap;

import com.raf.nwp.planetickets.model.*;
import com.raf.nwp.planetickets.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        Airline airline = new Airline();
        airline.setName("AirSerbia");
        Airline airline2 = new Airline();
        airline2.setName("WizzAir");
        airlineRepository.save(airline);
        airlineRepository.save(airline2);

        City city1 = new City();
        city1.setName("Belgrade");
        City city2 = new City();
        city2.setName("New York");
        City city3 = new City();
        city3.setName("London");
        cityRepository.save(city1);
        cityRepository.save(city2);
        cityRepository.save(city3);

        User user = new User();
        user.setUsername("test");
        user.setUserType(UserType.USER);
        user.setPassword("Abc1234");
        userRepository.save(user);
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("Passw0rd");
        admin.setUserType(UserType.ADMIN);
        userRepository.save(admin);

        Flight flight1 = new Flight();
        flight1.setOrigin(city1);
        flight1.setDestination(city2);
        flightRepository.save(flight1);

        Ticket tck1 = new Ticket();
        tck1.setAirline(airline);
        tck1.setCount(Long.parseLong("10"));
        tck1.setOneWay(false);
        tck1.setDepartOn(new Date("10/12/2021"));
        tck1.setReturnOn(new Date("12/12/2021"));
        tck1.setFlight(flight1);
        ticketRepository.save(tck1);

        flight1.addTicket(tck1);
        flightRepository.save(flight1);
        System.out.println(flight1.getSize());
        System.out.println(flightRepository.findById(Long.parseLong("1")).get().getTickets().size());

        Reservation rsvr = new Reservation();
        rsvr.setAvailable(true);
        rsvr.setTicket(tck1);
        rsvr.setFlight(flight1);
        reservationRepository.save(rsvr);

        user.addBooking(rsvr);
        userRepository.save(user);
        System.out.println(userRepository.findById(Long.parseLong("1")).get().getBookings().size());

        System.out.println("Data loaded!");
    }
}
