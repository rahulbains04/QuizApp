package com.screening.solution.dao;

import com.screening.solution.entity.Question;

import java.util.List;

public interface QuestionDAO {

    List<Question> findAll();

    Question findById(int theId);

    Question save(Question theQuestion);

    String getJsonDataFromApi(String s);

    Question findNext(Question theQuestion);

}
