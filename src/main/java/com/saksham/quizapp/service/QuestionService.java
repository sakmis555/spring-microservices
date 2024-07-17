package com.saksham.quizapp.service;

import com.saksham.quizapp.dao.QuestionDao;
import com.saksham.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    };

    public Question getQuestionById(int questionId) {
        return questionDao.findById(questionId).orElse(new Question());
    };

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findAllByCategory(category);
    }

    public void addQuestion(Question question) {
        questionDao.save(question);
    }

    public void updateQuestion(Question question) {
        questionDao.save(question);
    }

    public void deleteQuestion(int questionId) {
        questionDao.deleteById(questionId);
    }
}
