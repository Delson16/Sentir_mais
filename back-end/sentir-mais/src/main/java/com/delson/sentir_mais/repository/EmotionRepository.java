package com.delson.sentir_mais.repository;

import com.delson.sentir_mais.domain.Emotion;
import com.delson.sentir_mais.dto.EmotionRecordContent;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmotionRepository extends JpaRepository<Emotion, String>{
    
     List<Emotion> findByUserIdAndData(String userId, LocalDate data);
     
     Emotion findByUserIdAndDataAndEmotion(String userId, LocalDate data, String emotion);
     
      @Query(value = """
        SELECT 
            e.emotion AS emotion,
            e.emoji AS emoji,
            COUNT(*) AS amount
        FROM emotion AS e
        WHERE 
            MONTH(data) = :month AND 
            YEAR(data) = :year AND 
            id_user = :userId
        GROUP BY e.emotion, e.emoji
        ORDER BY amount DESC
    """, nativeQuery = true)
    List<EmotionRecordContent> findEmotionRecordByMonthAndUser( @Param("month") int month, @Param("year") int year, @Param("userId") String userId );
    
}
