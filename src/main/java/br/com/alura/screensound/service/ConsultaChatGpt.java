package br.com.alura.screensound.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGpt {
    public static String obterInformacao(String texto) {
        String API_KEY = "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";
        OpenAiService service = new OpenAiService(System.getenv(API_KEY));


        CompletionRequest requisicao = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("Me fale sobre o artista: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();


        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}