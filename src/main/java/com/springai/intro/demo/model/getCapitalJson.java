package com.springai.intro.demo.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public record getCapitalJson(@JsonPropertyDescription("This is City Name") String answer) {

}
