package com.example.solutionquiz.api;

import com.example.solutionquiz.business.Question;
import com.example.solutionquiz.business.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("questions")
    public void createQuestion(@RequestBody Question question){
            quizService.createQuestion(question);
    }

    @PostMapping("questions/{questionId}/play/{answerId}")
    public Boolean validateAnswer(@PathVariable("questionId") Long questionId,
                                         @PathVariable("answerId") Long answerId){
            return quizService.validateAnswer(questionId, answerId);
    }
}
