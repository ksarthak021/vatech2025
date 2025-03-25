package com.valtech.training.question.vos;

import com.valtech.training.question.entities.Question;

public record QuestionVO (long id,String questionTitle, String option1, String option2, String option3, String option4,
		String rightAnswer, String difficultyLevel, String topic){
	
	
	public static QuestionVO from(Question q) {
		return new QuestionVO(
				q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),
				q.getOption3(),q.getOption4(),q.getRightAnswer(),q.getDifficultyLevel(),q.getTopic()
				);	
	}
	
	public Question to() {
		return new Question(id,questionTitle,option1,option2,option3,option4,rightAnswer,difficultyLevel,topic);		
	}

	
	public void updateTo(long id,Question q) {
	    q.setQuestionTitle(questionTitle);
	    q.setOption1(option1);
	    q.setOption2(option2);
	    q.setOption3(option3);
	    q.setOption4(option4);
	    q.setRightAnswer(rightAnswer);
	    q.setTopic(topic);
	    q.setDifficultyLevel(difficultyLevel);
	    
	    
	}
	
	
}




