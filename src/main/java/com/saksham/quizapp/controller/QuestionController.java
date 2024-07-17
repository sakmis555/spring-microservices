package com.saksham.quizapp.controller;

import com.saksham.quizapp.model.Question;
import com.saksham.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    };

    @GetMapping("{questionId}")
    public Question getQuestion(@PathVariable int questionId) {
        return questionService.getQuestionById(questionId);
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    };

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
        return "Question added successfully";
    }

    @PutMapping("update")
    public Question updateQuestion(@RequestBody Question question) {
        questionService.updateQuestion(question);
        return questionService.getQuestionById(question.getId());
    };

    @DeleteMapping("delete/{questionId}")
    public Question deleteQuestion(@PathVariable int questionId) {
        Question question = questionService.getQuestionById(questionId);
        questionService.deleteQuestion(questionId);
        return question;
    }
}
