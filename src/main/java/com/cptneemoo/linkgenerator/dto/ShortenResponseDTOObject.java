package com.cptneemoo.linkgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShortenResponseDTOObject {
  @JsonProperty("shortened_url")
  private String urlAfter;

  public ShortenResponseDTOObject(String urlAfter) {
    this.urlAfter = urlAfter;
  }
}
