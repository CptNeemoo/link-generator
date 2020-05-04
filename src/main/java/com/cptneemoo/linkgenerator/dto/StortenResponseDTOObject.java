package com.cptneemoo.linkgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StortenResponseDTOObject {
  @JsonProperty("shortened_url")
  private String urlAfter;

  public StortenResponseDTOObject(String urlAfter) {
    this.urlAfter = urlAfter;
  }
}
