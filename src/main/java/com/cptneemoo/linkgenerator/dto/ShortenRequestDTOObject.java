package com.cptneemoo.linkgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShortenRequestDTOObject {

  @JsonProperty("long_url")
  private String long_url;

  public ShortenRequestDTOObject(String long_url) {
    this.long_url = long_url;
  }
}
