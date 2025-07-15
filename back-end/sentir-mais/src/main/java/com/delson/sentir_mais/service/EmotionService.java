package com.delson.sentir_mais.service;

import com.delson.sentir_mais.domain.Emotion;
import com.delson.sentir_mais.domain.User;
import com.delson.sentir_mais.dto.EmotionRegisterDto;
import com.delson.sentir_mais.dto.EmotionUpdateDto;
import com.delson.sentir_mais.exception.EmotionAlreadyExistsException;
import com.delson.sentir_mais.exception.EmotionNotFoundException;
import com.delson.sentir_mais.repository.EmotionRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmotionService {

    @Autowired
    EmotionRepository emotionRepository;

    public List<Emotion> getEmotionByDate(String userId, String dataStr) {
        LocalDate data = parseLocalDate(dataStr);
        return emotionRepository.findByUserIdAndData(userId, data);
    }
    
    public void registerEmotion(EmotionRegisterDto data, User user) {
        
        LocalDate localDate = parseLocalDate(data.data());
        
        Emotion emotionTest = emotionRepository.findByUserIdAndDataAndEmotion(
                                        user.getId(), localDate, data.emotion());
        
        if(emotionTest != null){
              throw new EmotionAlreadyExistsException("Esta emoção já foi cadastrada neste dia");
        }
        
        Emotion emotion = new Emotion(
                data.emotion(),
                data.emoji(),
                localDate,
                data.description(),
                user
        );

        emotionRepository.save(emotion);
    }

    public void deleteEmotion(String id) {
        Optional<Emotion> emotion = emotionRepository.findById(id);

        if (emotion.isEmpty()) {
            throw new EmotionNotFoundException();
        }

        emotionRepository.delete(emotion.get());

    }
    
    public void updateEmotion(EmotionUpdateDto data, User user){
        Optional<Emotion> emotion = emotionRepository.findById(data.id());
        if(emotion.isEmpty()){
            throw new EmotionNotFoundException();
        }
        
        Emotion emotionUpdate = emotion.get();
        
        emotionUpdate.setData(parseLocalDate(data.data()));
        emotionUpdate.setDescription(data.description());
        emotionUpdate.setEmoji(data.emoji());
        emotionUpdate.setEmotion(data.emotion());
        emotionUpdate.setUser(user);
        
        emotionRepository.save(emotionUpdate);        
    }

    public LocalDate parseLocalDate(String dataStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dataStr, formatter);
    }
    
    

}
