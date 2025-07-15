package com.delson.sentir_mais.dto;

public record EmotionRecordResponseDto(
        String emotion,
        String emoji,
        int amount,
        float percentage) {

}
