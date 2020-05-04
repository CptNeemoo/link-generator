package com.cptneemoo.linkgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShortenRequestDTOObject {

  @JsonProperty("long_url")
  private String urlBefore;

  public ShortenRequestDTOObject(String longUrl) {
    this.urlBefore = longUrl;
  }
}
