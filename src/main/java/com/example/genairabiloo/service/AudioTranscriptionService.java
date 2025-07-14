package com.example.genairabiloo.service;

import com.example.genairabiloo.Enums.Transcript;
import com.example.genairabiloo.dto.Convenstation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.content.Media;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class AudioTranscriptionService {

    private final ChatClient chatClient;
    private final ChatMemory chatMemory;

    public String chatWithAI(String message){

        String response = chatClient.prompt()
                .system(s -> s.text("Bạn là một trợ lý vui vẻ và thân thiện, trả lời bằng tiếng Việt."))
                .user(message)
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID, "007"))
                .call()
                .content();
        return response;
    }


    public List<Convenstation> audioTranscription(MultipartFile file){
        Media media = Media.builder()
                .mimeType(MimeTypeUtils.parseMimeType(file.getContentType()))
                .data(file.getResource())
                .build();

        ChatOptions chatOptions = ChatOptions.builder()
                .temperature(0.3)
                .build();

        // Prompt mặc định nếu không có custom message
        String message = Transcript.TRANSCRIPT_AUDIO.getValue();

        List<Convenstation> response = chatClient.prompt()
                .system("Bạn là trợ lý của DEV Tran")
                .options(chatOptions)
                .user(u->u.media(media).text(message))
                .call()
                .entity(new ParameterizedTypeReference<List<Convenstation>>() {
                });

        log.info("Thông tin hội thoại: {}",response);

        return response;
    }

    public List<Message> getChatHistory(String conversationId) {
        return chatMemory.get(conversationId); // Lấy 100 tin nhắn gần nhất
    }
}
