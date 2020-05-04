package com.cptneemoo.linkgenerator.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Data
public class RequestResult{

  @Id
  private long id;

  private String urlBefore;
  private String urlAfter;
  private long unixTimestamp;

  public RequestResult(String urlBefore, String urlAfter) {
    this.urlBefore = urlBefore;
    this.urlAfter = urlAfter;
    this.unixTimestamp = Instant.now().getEpochSecond();
  }

  @Override
  public String toString() {
    return "RequestResult{" +
            "id=" + id +
            ", urlBefore='" + urlBefore + '\'' +
            ", urlAfter='" + urlAfter + '\'' +
            ", unixTimestamp=" + unixTimestamp +
            '}';
  }
}
