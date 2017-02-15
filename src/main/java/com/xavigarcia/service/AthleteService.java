package com.xavigarcia.service;

import com.xavigarcia.domain.Athlete;
import com.xavigarcia.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class AthleteService {
    @Autowired
    private AthleteRepository athleteRepository;

    public void createAthlete(){
        Athlete athlete1 = new Athlete("Xavi", "Garcia", "Espanol", LocalDate.of(1997, 10, 29));
        athleteRepository.save(athlete1);
        Athlete athlete2 = new Athlete("Alex", "Garcia", "Espanol", LocalDate.of( 1963, 3, 1));
        athleteRepository.save(athlete2);
        Athlete athlete3 = new Athlete("Guille", "Sanchez", "Americano", LocalDate.of( 1941, 3, 1));
        athleteRepository.save(athlete3);
        Athlete athlete4 = new Athlete("Marc", "Bonastre", "Frances", LocalDate.of(1965,5,1));
        athleteRepository.save(athlete4);
        Athlete athlete5 = new Athlete("Maria", "Lapiedra", "Ingles", LocalDate.of( 1964, 4, 1));
        athleteRepository.save(athlete5);
        Athlete athlete6 = new Athlete("Jan", "Gomez", "Ingles", LocalDate.of( 1962, 5, 1));
        athleteRepository.save(athlete6);
    }
    public void testAthlete(){
        System.out.println(athleteRepository.findByNacionalityIs("Espanol"));
        System.out.println(athleteRepository.findByBirthdayBefore(LocalDate.of(1997, 12, 1)));
    }
}

