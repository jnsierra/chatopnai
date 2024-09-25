package com.fisa.jnsierrac.chatopenai.controller;

import com.fisa.jnsierrac.chatopenai.dtos.PromptRequestDto;
import com.fisa.jnsierrac.chatopenai.dtos.PromptResponseDto;
import com.fisa.jnsierrac.chatopenai.servies.GptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/gpt")
@RestController
public class GptController {
    @Autowired
    public GptController(GptService gptService) {
        this.gptService = gptService;
    }

    private GptService gptService;

    @PostMapping(value = "/prompt")
    public ResponseEntity<?> promptOpenAi(@RequestBody PromptRequestDto requestDto){
        PromptResponseDto responseDto = gptService.sendRequestToOpenIA(requestDto);
        return ResponseEntity.ok(responseDto);
    }
}