package com.xavigarcia.controller;


import com.xavigarcia.domain.Athlete;
import com.xavigarcia.domain.MedalType;
import com.xavigarcia.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;


@RestController
@RequestMapping("/athletes")
public class AthleteController {
    @Autowired
    private AthleteRepository athleteRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Athlete createAthlete(@RequestBody Athlete athlete){
        return athleteRepository.save(athlete);
    }

    @GetMapping
    public List<Athlete> getAllAthletes(){
        return athleteRepository.findAll();
    }

    @PutMapping
    public Athlete updateAthlete(@RequestBody Athlete athlete){
        return athleteRepository.save(athlete);
    }

    @DeleteMapping("/{id}")
    public void deleteAthleteID(@PathVariable Long id){
        Athlete athlete = athleteRepository.findOne(id);
        if(athlete != null ) athleteRepository.delete(id);
    }


    @GetMapping("/GroupByNacionality")
    public Map<String, List<Athlete>> getAthleteGroupByNacionality(){
        return athleteRepository
                .findAll()
                .parallelStream()
                .collect(groupingBy(Athlete::getNacionality));
    }
    @GetMapping("/ByBirthdayBeforeThan/{birthday}")

    public List<Athlete> getAthleteBirthday(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy")LocalDate birthday){
        return athleteRepository.findByBirthdayBefore(birthday);
    }
    @GetMapping("/ByNacionality/{nacionality}")
    public List<Athlete> getAthleteNacionalityIs(@PathVariable String nacionality){
        return athleteRepository.findByNacionalityIs(nacionality);
    }

    @GetMapping("/GroupByMedalType")
    public Map<MedalType, List<Athlete>> getAthleteGroupByMedalType(){

        return athleteRepository
                .findAll()
                .parallelStream()
                .collect(groupingBy(athlete -> {
                    if(athlete.getMedals().stream().anyMatch(medal -> medal.getMedalType() == MedalType.GOLD)){
                        return MedalType.GOLD;
                    }else if(athlete.getMedals().stream().anyMatch(medal -> medal.getMedalType() == MedalType.SILVER)){
                        return MedalType.SILVER;
                    }else if(athlete.getMedals().stream().anyMatch(medal -> medal.getMedalType() == MedalType.BRONCE)){
                        return MedalType.BRONCE;
                    }else {
                        return MedalType.NONE;
                    }
                }));
    }
}
