package com.cb.translator.controller;

import com.cb.translator.service.OpenAIService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TranslateController {

    private final OpenAIService openAIService;

    public TranslateController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/translate")
    @ResponseBody
    public String translate(@RequestParam String text, @RequestParam String language) {
        return openAIService.translateText(text, language);
    }
}
