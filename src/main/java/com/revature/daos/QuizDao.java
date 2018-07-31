package com.revature.daos;

import java.util.List;

import com.revature.pojos.Question;
import com.revature.pojos.Quiz;

public interface QuizDao {

	public Quiz getQuiz(int id);
	public List<Quiz> getAllQuizzes();
	public Quiz putQuiz(Quiz q);
	public Quiz addQuiz(Quiz q);
	public Quiz updateQuiz(Quiz q, int id);
	public void deleteQuiz(Quiz q);
	public List<Question> getQuizQuestions(Quiz q);
	public void addQuestion(Quiz q, Question qu);
}
