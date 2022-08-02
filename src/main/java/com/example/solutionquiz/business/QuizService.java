package com.example.solutionquiz.business;

import com.example.solutionquiz.dao.AnswerRepository;
import com.example.solutionquiz.dao.PlayerRepository;
import com.example.solutionquiz.dao.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    PlayerRepository playerRepository;

    public void initQuiz() {
        Question question = new Question("Qui est le chanteur du groupe Queen ?");
        Answer a1 = new Answer("Mick Jagger", false);
        question.addAnswer(a1);
        Answer a2 = new Answer("Freddie Mercury", true);
        question.addAnswer(a2);
        Answer a3 = new Answer("Claude Francois", false);
        question.addAnswer(a3);
        System.out.println(question);

        questionRepository.save(question);
    }

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

    public Question getRandomQuestion() {

        return questionRepository.findRandomQuestion();
    }

    public void validateScore(String pseudo, Long questionId, Long answerId) {

        boolean scored = validateAnswer(questionId, answerId);

        Optional<Player> optional = playerRepository.findByName(pseudo);
        if(optional.isPresent()){
            Player player = optional.get();
            if(scored) {
                player.setScore(player.getScore() + 1);
                playerRepository.save(player);
            }
        } else {
            Player player = new Player(pseudo);
            if(scored) {
                player.setScore(1);
            } else {
                player.setScore(0);
            }
            playerRepository.save(player);
        }
    }

    public List<Player> getScores() {
        List<Player> players = playerRepository.findAllByOrderByScoreDesc();
        return players;
    }
}
