package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.daos.QuestionDaoImpl;
import com.revature.pojos.Question;
import com.revature.pojos.User;

@Service("QuesitonService")
public class QuestionService {

	
	
	QuestionDaoImpl QUDI = new QuestionDaoImpl();
	

	
	public Question getQuestion(int questionId) {
		for(Question qu : QUDI.getAllQuestions()) {
			if(questionId == qu.getQuesitonId()) {
				return qu;
			}
		}
		return null;
	}
	
	
	public List<Question> getAllQuestions(){
		return QUDI.getAllQuestions();
	}
	
	
}
