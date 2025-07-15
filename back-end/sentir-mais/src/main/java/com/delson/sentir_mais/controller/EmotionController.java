package com.delson.sentir_mais.controller;

import com.delson.sentir_mais.domain.Emotion;
import com.delson.sentir_mais.domain.User;
import com.delson.sentir_mais.dto.EmotionRegisterDto;
import com.delson.sentir_mais.dto.EmotionUpdateDto;
import com.delson.sentir_mais.service.EmotionService;
import com.delson.sentir_mais.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emotion")
public class EmotionController {
    
    @Autowired
    EmotionService emotionService;
    
    @Autowired
    UserService userService;
    
    @GetMapping("/{id}/{date}")
    public ResponseEntity getEmotionByDate(@PathVariable("id") String userId,@PathVariable("date") String date){
        List<Emotion> bodyResponse = emotionService.getEmotionByDate(userId, date);
        return ResponseEntity.ok(bodyResponse);
    }
    
    @PostMapping("/{id}")
    public ResponseEntity register(@PathVariable("id") String userId, @RequestBody EmotionRegisterDto data){
        emotionService.registerEmotion(data, userService.getUser(userId));
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String emotionId){
        emotionService.deleteEmotion(emotionId);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
     public ResponseEntity update(@PathVariable("id") String userId, @RequestBody EmotionUpdateDto data){
        emotionService.updateEmotion(data, userService.getUser(userId));
        return ResponseEntity.noContent().build();
    }
     
     
    
    
}
