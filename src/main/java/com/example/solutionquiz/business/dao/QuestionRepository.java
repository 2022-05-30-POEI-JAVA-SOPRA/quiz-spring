package com.example.solutionquiz.business.dao;

import com.example.solutionquiz.business.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
