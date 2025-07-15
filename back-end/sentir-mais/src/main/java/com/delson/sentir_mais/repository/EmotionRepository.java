package com.delson.sentir_mais.repository;

import com.delson.sentir_mais.domain.Emotion;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmotionRepository extends JpaRepository<Emotion, String>{
    
     List<Emotion> findByUserIdAndData(String userId, LocalDate data);
     
     Emotion findByUserIdAndDataAndEmotion(String userId, LocalDate data, String emotion);
    
}
