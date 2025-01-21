package com.springai.intro.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springai.intro.demo.Service.OpenAiService;
import com.springai.intro.demo.model.Answer;
import com.springai.intro.demo.model.CityInfo;
import com.springai.intro.demo.model.GetCapitalRequest;
import com.springai.intro.demo.model.Question;
import com.springai.intro.demo.model.getCapitalJson;

@RestController
public class QuestionController {
	
	@Autowired
	private OpenAiService aiService;
	
	@PostMapping("/capital")
	public getCapitalJson getCapital(@RequestBody GetCapitalRequest capitalRequest) {
		return aiService.getCapital(capitalRequest);
	}
	
	@PostMapping("/capitalInfo")
	public Answer getCapitalCityInfo(@RequestBody GetCapitalRequest capitalRequest) {
		return aiService.getCapitalCityInfo(capitalRequest);
	}
	
	@PostMapping("/currency")
	public CityInfo getCityCurrency(@RequestBody GetCapitalRequest capitalRequest) {
		return aiService.getCityCurrency(capitalRequest);
	}
	
	
	@PostMapping("/ask")
	public Answer askMeAnything(@RequestBody Question question) {
		return aiService.getAnswer(question);
	}

}
