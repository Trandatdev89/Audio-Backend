package com.example.genairabiloo.controller;

import com.example.genairabiloo.service.AudioTranscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.messages.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GenAIController {

    private final AudioTranscriptionService genAIService;

    @GetMapping(value = "/chat1")
    public String chatWithAI(@RequestParam String message){
       return genAIService.chatWithAI(message);
    }

    @GetMapping(value = "/history")
    public List<Message> historyChatWithAI(@RequestParam String conversationId){
        return genAIService.getChatHistory(conversationId);
    }

    @PostMapping(value = "/transcription")
    public String chatWithImage(@RequestParam MultipartFile file,@RequestParam String message){
        return genAIService.chatWithImage(file,message);
    }
}
