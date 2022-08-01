package com.example.solutionquiz.business;

import com.example.solutionquiz.dao.AnswerRepository;
import com.example.solutionquiz.dao.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    public void createQuestion(Question question){
        for(Answer answer : question.getAnswers()){
            answer.setQuestion(question);
        }
        questionRepository.save(question);
    }

    // Est ce qu'on accorde le point ou pas ?
    public boolean validateAnswer(Long questionId, Long answerId) {

        Optional<Answer> answerOptional = answerRepository.findById(answerId);
        if(answerOptional.isPresent()){
            Answer answer = answerOptional.get();
            if(answer.getQuestion().getId().equals(questionId)){
                return answer.isCorrectAnswer();
            }
        }

        return false;
    }

}
