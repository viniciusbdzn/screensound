package br.com.alura.screensound.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGpt {
    public static String obterInformacao(String texto) {
        String API_KEY = "OPENAI_API_KEY";
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