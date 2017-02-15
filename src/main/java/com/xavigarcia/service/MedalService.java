package com.xavigarcia.service;

import com.xavigarcia.domain.Medal;
import com.xavigarcia.domain.MedalType;
import com.xavigarcia.repository.AthleteRepository;
import com.xavigarcia.repository.MedalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedalService {
    @Autowired
    private MedalRepository medalRepository;
    @Autowired
    private AthleteRepository athleteRepository;

    public void createMedal(){
        Medal medal1 = new Medal(MedalType.GOLD, "Lol", "Camp nou");
        medal1.setAthlete(athleteRepository.findByNameIs("Xavi"));
        medalRepository.save(medal1);
        Medal medal2= new Medal(MedalType.GOLD, "Futbol", "Bernabeu");
        medal2.setAthlete(athleteRepository.findByNameIs("Maria"));
        medalRepository.save(medal2);
        Medal medal3 = new Medal(MedalType.SILVER, "Basquet", "Bernabeu");
        medal3.setAthlete(athleteRepository.findByNameIs("Marc"));
        medalRepository.save(medal3);
        Medal medal4 = new Medal(MedalType.SILVER, "Tennis", "Camp nou");
        medal4.setAthlete(athleteRepository.findByNameIs("Guille"));
        medalRepository.save(medal4);
        Medal medal5 = new Medal(MedalType.BRONCE, "Futbol", "Bernabeu");
        medal5.setAthlete(athleteRepository.findByNameIs("Alex"));
        medalRepository.save(medal5);
        Medal medal6 = new Medal(MedalType.BRONCE, "Lol", "Camp nou");
        medal6.setAthlete(athleteRepository.findByNameIs("Jan"));
        medalRepository.save(medal6);

    }
    public void testMedal(){

    }
}
