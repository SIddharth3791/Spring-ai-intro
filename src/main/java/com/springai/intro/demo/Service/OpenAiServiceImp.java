package com.springai.intro.demo.Service;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springai.intro.demo.model.Answer;
import com.springai.intro.demo.model.CityInfo;
import com.springai.intro.demo.model.GetCapitalRequest;
import com.springai.intro.demo.model.Question;
import com.springai.intro.demo.model.getCapitalJson;

@Service 
public class OpenAiServiceImp implements OpenAiService {
	
	private final ChatModel chatModel;
	
	@Value("classpath:templates/get-capital.st")
	private Resource getCapitalPrompt;
	
	@Value("classpath:templates/get-capital-city-info.st")
	private Resource getCapitalCityInfoPrompt;
	
	@Value("classpath:templates/get-currency.st")
	private Resource getCurrencyPrompt;
	
	
	private ObjectMapper objectMapper;
	
	public OpenAiServiceImp(ChatModel chatModel, ObjectMapper objectMapper) {
		this.chatModel = chatModel;
		this.objectMapper = objectMapper;
	}

	@Override
	public Answer getAnswer(Question question) {
		
        PromptTemplate promptTemplate = new PromptTemplate(question.text());
        Prompt prompt = promptTemplate.create();

        ChatResponse response = chatModel.call(prompt);

        
        return new Answer(response.getResult().getOutput().getContent());
	}

	@Override
	public getCapitalJson getCapital(GetCapitalRequest capitalRequest) {
		
		BeanOutputConverter<getCapitalJson> converter = new BeanOutputConverter<>(getCapitalJson.class);
		String format = converter.getFormat();
		
		PromptTemplate promptTemplate = new PromptTemplate(getCapitalPrompt);
		Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", capitalRequest.stateOrCountry(), "format", format));
		ChatResponse response = chatModel.call(prompt);
	
		return converter.convert(response.getResult().getOutput().getContent());
	}

	@Override
	public Answer getCapitalCityInfo(GetCapitalRequest capitalRequest) {
		PromptTemplate promptTemplate = new PromptTemplate(getCapitalCityInfoPrompt);
		Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", capitalRequest.stateOrCountry()));
		ChatResponse response = chatModel.call(prompt);
		
		return new Answer(response.getResult().getOutput().getContent());
	}

	@Override
	public CityInfo getCityCurrency(GetCapitalRequest capitalRequest) {
		BeanOutputConverter<CityInfo> converter = new BeanOutputConverter<>(CityInfo.class);
		String format = converter.getFormat();
		
		PromptTemplate template = new PromptTemplate(getCurrencyPrompt);
		
		Prompt prompt = template.create(Map.of("stateOrCountry", capitalRequest.stateOrCountry(), "format", format));
		ChatResponse response = chatModel.call(prompt);
		
		CityInfo cityInfo = converter.convert(response.getResult().getOutput().getContent());
		if(StringUtils.isNotBlank(cityInfo.currency())) {
			System.out.print("Currency is not blank");
			return cityInfo;
		}
		System.out.print("Currency is blank");
		return null;
		
	}

}
