package com.api.freetoyz.controller.dto.toyz;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToyzFileDTO {
    private String name;
    private String description;
    private String cotation;
    private String quantite;
    private MultipartFile picture;
}
