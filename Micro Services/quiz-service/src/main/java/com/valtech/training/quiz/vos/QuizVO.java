package com.valtech.training.quiz.vos;

import java.util.List;

import com.valtech.training.quiz.entities.Quiz;

public record QuizVO(long id,String quizTitle, List<Integer> questionIds) {
	
	// Convert Entity to VO
    public static QuizVO from(Quiz quiz) {
        return new QuizVO(quiz.getId(), quiz.getQuizTitle(), quiz.getQuestionIds());
    }

    // Convert VO to Entity
    public Quiz to() {
        return new Quiz(this.id, this.quizTitle, this.questionIds);
    }

}
