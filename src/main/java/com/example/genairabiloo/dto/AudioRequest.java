package com.example.genairabiloo.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AudioRequest{
    private MultipartFile audioFile;
    private String message;
}
