package com.example.solutionquiz.controller;

import com.example.solutionquiz.business.Player;
import com.example.solutionquiz.business.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HtmlQuizController {

    @Autowired
    QuizService quizService;

    @GetMapping("/play")
    public String getQuiz(Model model){

        quizService.initQuiz();

        model.addAttribute("question", quizService.getRandomQuestion());
        return "play.html";
    }

    @PostMapping("/play")
    public String play(Model model, @RequestParam("pseudo") String pseudo, @RequestParam("questionId") Long questionId, @RequestParam("answerId") Long answerId){

        if(pseudo.length() > 0)
            quizService.validateScore(pseudo, questionId, answerId);

        List<Player> players = quizService.getScores();
        model.addAttribute("players", players);
        return "scores.html";
    }

    @GetMapping("/scores")
    public String getScore(Model model){

        List<Player> players = quizService.getScores();
        model.addAttribute("players", players);
        return "scores.html";
    }
}
