package com.screening.solution.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.screening.solution.entity.Question;

import java.util.List;

public interface QuestionService {

    List<Question> findAll();

    Question findById(int theId);

    Question save(Question theQuestion);

    void addJsonData() throws JsonProcessingException;

    Question findNext(Question theQuestion);

}
