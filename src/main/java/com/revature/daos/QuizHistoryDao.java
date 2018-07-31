package com.revature.daos;

import java.util.List;

import com.revature.pojos.QuizHistory;

public interface QuizHistoryDao {
	
	public QuizHistory getQuizHistory(int id);
	public QuizHistory putQuizHistory(QuizHistory qh);
	public List<QuizHistory> getAllQuizHistories();
	public QuizHistory updateQuizHistory(QuizHistory  qh, int id);
	public void DeleteQuizHistory(QuizHistory qh);
}
