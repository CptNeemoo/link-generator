package com.cptneemoo.linkgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExpandRequestDTOObject {

  @JsonProperty("bitlink_id")
  private String bitlink_id;

  public ExpandRequestDTOObject(String url) {
    this.bitlink_id = url;
  }
}
