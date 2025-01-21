package com.springai.intro.demo.Service;

import com.springai.intro.demo.model.Answer;
import com.springai.intro.demo.model.CityInfo;
import com.springai.intro.demo.model.GetCapitalRequest;
import com.springai.intro.demo.model.Question;
import com.springai.intro.demo.model.getCapitalJson;

public interface OpenAiService {
	
	Answer getAnswer(Question question);
	
	getCapitalJson getCapital(GetCapitalRequest capitalRequest);
	
	Answer getCapitalCityInfo(GetCapitalRequest capitalRequest);
	
	CityInfo getCityCurrency(GetCapitalRequest capitalRequest);

}
