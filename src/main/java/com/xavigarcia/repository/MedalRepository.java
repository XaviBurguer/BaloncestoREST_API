package com.xavigarcia.repository;

import com.xavigarcia.domain.Medal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedalRepository extends JpaRepository<Medal, Long> {
}
