package com.screening.solution.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.screening.solution.dao.QuestionDAO;
import com.screening.solution.entity.Question;
import com.screening.solution.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionRestController {
  private QuestionService questionService;




  //constructor injection
    @Autowired
    public QuestionRestController(QuestionService theQuestionService)
    {
        questionService=theQuestionService;

    }

//    endpoint to fetch 5 Questions from the website
    @RequestMapping("/fetch")
    public void fetchQuestions(Question theQuestion) throws JsonProcessingException {
for(int i=0;i<5;i++)
{  questionService.addJsonData();}
    }



    //endpoint to return a list of all the questions
    @GetMapping("/questions")
    public List<Question> findAll(){
        return questionService.findAll();
    }

    // endpoint to return Question based on id
  @GetMapping("/play/{questionId}")
  public Question getQuestion(@PathVariable int questionId)
  {
    Question theQuestion = questionService.findById(questionId);

    if(theQuestion==null)
    {
      throw new RuntimeException("Question with id - "+questionId+" not found ");
    }

    return theQuestion;
  }

  // endpoint to return the next question
  @PostMapping("/next")
  public String getnextQuestion(@RequestBody Question question)
  {
    Question theQuestion = questionService.findById(question.getId());

    if(theQuestion==null)
    {
      throw new RuntimeException("Question with id - "+question.getId()+" not found ");
    }
    String output="{correct_answer: " + theQuestion.getAnswer();

    Question nextQuestion = questionService.findNext(theQuestion);

    output = output + " {next_question: {question_id: " + nextQuestion.getId()
                        +", question : " + nextQuestion.getQuestion()+"}}";

    return output;

  }


}
