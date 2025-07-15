package com.delson.sentir_mais.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Emotion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    private String emotion;
    
    private String emoji;
    
    private LocalDate data;
    
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "id_User")
    @JsonIgnore
    private User user;

    public Emotion(String emotion, String emoji, LocalDate data, String description, User user) {
        this.emotion = emotion;
        this.emoji = emoji;
        this.data = data;
        this.description = description;
        this.user = user;
    }
    
}
