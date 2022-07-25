package com.example.solutionquiz;

import com.example.solutionquiz.business.Answer;
import com.example.solutionquiz.business.Question;
import com.example.solutionquiz.business.dao.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SolutionquizApplicationTests {

    @Autowired
    QuestionRepository questionRepository;

    @Test
    void testCreateQuestionCascadeMode() {

        Question question = new Question("Qui est le chanteur du groupe Queen ?");
        Answer a1 = new Answer("Mick Jagger", false);
        question.addAnswer(a1);
        Answer a2 = new Answer("Freddie Mercury", true);
        question.addAnswer(a2);
        Answer a3 = new Answer("Claude Francois", false);
        question.addAnswer(a3);
        System.out.println(question);

        questionRepository.save(question);

        Assertions.assertEquals("Qui est le chanteur du groupe Queen ?", a1.getQuestion().getTitle());

    }

}
