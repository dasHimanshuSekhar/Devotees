package com.example.practiceapi.repository;

import com.example.practiceapi.entity.Devotee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DevoteeRepo extends JpaRepository<Devotee, Long> {

    Boolean existsByDevoteeUserName(String userName);

    Optional<Devotee> findByDevoteeUserName(String devoteeUserName);
}
