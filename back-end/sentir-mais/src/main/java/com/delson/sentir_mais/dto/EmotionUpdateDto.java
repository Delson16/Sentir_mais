package com.delson.sentir_mais.dto;

public record EmotionUpdateDto(
        String id,
        String data,
        String description,
        String emoji,
        String emotion) {

}
