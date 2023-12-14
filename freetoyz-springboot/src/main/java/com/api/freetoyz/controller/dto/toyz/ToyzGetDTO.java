package com.api.freetoyz.controller.dto.toyz;

public record ToyzGetDTO(Long id, String name, String categories, String description, String cotation, String quantite, org.springframework.web.multipart.MultipartFile Picture) {
}
