package com.xavigarcia.repository;


import com.xavigarcia.domain.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    List<Athlete> findByNacionalityIs(String nacionality);
    List<Athlete> findByBirthdayBefore(LocalDate birthday);
    Athlete findByNameIs(String name);
}
