package com.revature.daos;

import java.util.List;

import com.revature.pojos.Question;

public interface QuesitonDao {
		
	public Question getQuestion(int id);
	public List<Question> getAllQuestions();
	public Question putQuestion(Question q);
	public Question updateQuestion(Question q, int id);
	public void deleteQuestion(Question q);
}
