package com.example.genairabiloo.controller;

import com.example.genairabiloo.dto.AudioRequest;
import com.example.genairabiloo.dto.Convenstation;
import com.example.genairabiloo.service.AudioTranscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.messages.Message;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "*")
public class GenAIController {

    private final AudioTranscriptionService genAIService;

    @GetMapping(value = "/chat")
    public String chatWithAI(@RequestParam String message){
       return genAIService.chatWithAI(message);
    }

    @GetMapping(value = "/history")
    public List<Message> historyChatWithAI(@RequestParam String conversationId){
        return genAIService.getChatHistory(conversationId);
    }

    @PostMapping(value = "/transcription")
    public List<Convenstation> audioTranscription(@ModelAttribute AudioRequest audioRequest){
        return genAIService.audioTranscription(audioRequest.getAudioFile());
    }
}
