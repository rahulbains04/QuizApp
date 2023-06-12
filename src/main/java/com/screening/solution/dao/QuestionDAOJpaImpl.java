package com.screening.solution.dao;

import com.screening.solution.entity.Question;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
@Repository
public class QuestionDAOJpaImpl implements QuestionDAO{
//defining field for entitymanager
private EntityManager entityManager;

//defining webClient to fetch data from API
    private final WebClient webClient;

//    setting up the constructor injection
    @Autowired
    public QuestionDAOJpaImpl (EntityManager theEntityManager)
    {
       entityManager=theEntityManager;
       webClient=WebClient.create();
    }



//defining method to find all the Questions stored in database
    @Override
    public List<Question> findAll() {
//        create a query
        TypedQuery<Question> theQuery=entityManager.createQuery("from Question",Question.class);
//        execute query and get result list
         List<Question>questions= theQuery.getResultList();
//        return the result
        return questions;
    }

//    getting the JSON string from the API
    public String getJsonDataFromApi( String apiUrl) {
        return webClient.get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    // method to find the next stored Question in database
    @Override
    public Question findNext(Question theQuestion) {

        List<Question>questions=findAll();

        for(int i=0;i<questions.size();i++)
        {
            Question tempQuestion=questions.get(i);

            if(tempQuestion==theQuestion && i== questions.size()-1)
            {throw new RuntimeException("This was the last question");
            }
           if(tempQuestion==theQuestion)
               return questions.get(i+1);

        }
        return null;
    }

//     finding the Question by id
    @Override
    public Question findById(int theId) {
//        get Question by Id
        Question theQuestion = entityManager.find(Question.class,theId);
//        return Question
        return theQuestion;
    }

    // saving the Question
    @Override
    public Question save(Question theQuestion) {
//   save the question in the database
      Question dbQuestion = entityManager.merge(theQuestion);

      return dbQuestion;
    }


}
