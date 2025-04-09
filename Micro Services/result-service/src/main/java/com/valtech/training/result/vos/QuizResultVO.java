package com.valtech.training.result.vos;
import com.valtech.training.result.entities.QuizResult;

public record QuizResultVO(Long id, Long quizId, String userName, int score) {

// Convert Entity → VO
    public static QuizResultVO from(QuizResult quizResult) {
        return new QuizResultVO(
            quizResult.getId(),
            quizResult.getQuizId(),
            quizResult.getUserName(),
            quizResult.getScore()
        );
    }

  //Convert VO → Entity
    public QuizResult to() {
        return new QuizResult(
            this.quizId,
            this.userName,
            this.score
        );
    }
}
