package com.springai.intro.demo.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public record CityInfo(@JsonPropertyDescription("This Is Curreny of the City") String currency, 
						@JsonPropertyDescription("This Is Population Of The City") String population,
						@JsonPropertyDescription("This Is Region Of The City") String region) {

}
