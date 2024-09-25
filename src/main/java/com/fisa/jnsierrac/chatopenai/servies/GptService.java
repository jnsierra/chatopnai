package com.fisa.jnsierrac.chatopenai.servies;

import com.fisa.jnsierrac.chatopenai.dtos.PromptRequestDto;
import com.fisa.jnsierrac.chatopenai.dtos.PromptResponseDto;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GptService {
    @Autowired
    public GptService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    private ChatClient chatClient;

    public PromptResponseDto sendRequestToOpenIA(PromptRequestDto requestDto){
        String response = chatClient.prompt()
                .user(requestDto.prompt())
                .call()
                .content();
        return new PromptResponseDto(response);

    }
}
