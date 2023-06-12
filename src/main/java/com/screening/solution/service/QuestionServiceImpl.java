package com.screening.solution.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.screening.solution.dao.QuestionDAO;
import com.screening.solution.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService{

    private QuestionDAO questionDAO;

    // objectMapper for mapping JSON data to our Question object
    private  ObjectMapper objectMapper;

    //setting up constructor injection
@Autowired
    public QuestionServiceImpl(QuestionDAO theQuestionDAO,ObjectMapper theObjectMapper)
    {
        questionDAO=theQuestionDAO;
        objectMapper=theObjectMapper;
    }

    // serializing object to JSON and storing it in database
    @Transactional
    public void addJsonData() throws JsonProcessingException {
    String JsonData=questionDAO.getJsonDataFromApi("https://jservice.io/api/random");
        Question[] theQuestions = objectMapper.readValue(JsonData, Question[].class);
        // Perform any additional processing or validation
        for(Question tempQuestion: theQuestions)
        {
            questionDAO.save(tempQuestion);
        }

    }

    // Method to find Question next to given Question
    @Override
    public Question findNext(Question theQuestion) {

        return questionDAO.findNext(theQuestion);
}

//  Method to find all Questions in the database
    @Override
    public List<Question> findAll() {
      return questionDAO.findAll();
    }


//    Method to find question by Id
    @Override
    public Question findById(int theId) {
    return questionDAO.findById(theId);
    }

//    Method to save Question
    @Transactional
    @Override
    public Question save(Question theQuestion) {

    return questionDAO.save(theQuestion);
    }


}
