package com.cptneemoo.linkgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExpandResponseDTOObject {

  @JsonProperty("extended_url")
  private String urlAfter;

  public ExpandResponseDTOObject(String urlAfter) {
    this.urlAfter = urlAfter;
  }
}
