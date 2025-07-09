package com.example.genairabiloo.dto;

import org.springframework.web.multipart.MultipartFile;

public record AudioRequest(MultipartFile audioFile) {
}
