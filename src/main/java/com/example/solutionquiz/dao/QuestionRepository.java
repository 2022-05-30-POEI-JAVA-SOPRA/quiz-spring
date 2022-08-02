package com.example.solutionquiz.dao;

import com.example.solutionquiz.business.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value="SELECT * FROM questions ORDER BY RAND() LIMIT 1", nativeQuery=true)
    public Question findRandomQuestion();
}
