package com.example.solutionquiz;

import com.example.solutionquiz.business.Answer;
import com.example.solutionquiz.business.Question;
import org.junit.jupiter.api.Test;

class UnitTests {


//    @Test
//    void testMultiParam() {
//
//        Question question = new Question("Qui est le chanteur du groupe Queen ?");
//        Answer a1 = new Answer("Mick Jagger", false);
//        Answer a2 = new Answer("Freddie Mercury", true);
//        Answer a3 = new Answer("Claude Francois", false);
//        question.addAnswers(a1, a2, a3);
//        System.out.println(question);
//
//    }

    @Test
    void testAddAnswer() {

        Question question = new Question("Qui est le chanteur du groupe Queen ?");
        Answer a1 = new Answer("Mick Jagger", false);
        question.addAnswer(a1);
        Answer a2 = new Answer("Freddie Mercury", true);
        question.addAnswer(a2);
        Answer a3 = new Answer("Claude Francois", false);
        question.addAnswer(a3);
        System.out.println(question);



    }

}
