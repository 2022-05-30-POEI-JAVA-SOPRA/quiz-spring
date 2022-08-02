package com.example.solutionquiz.dao;

import com.example.solutionquiz.business.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    public Optional<Player> findByName(String name);
    public List<Player> findAllByOrderByScoreDesc();
}
