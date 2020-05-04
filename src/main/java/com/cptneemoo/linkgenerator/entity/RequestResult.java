package com.cptneemoo.linkgenerator.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Data
@Entity
public class RequestResult {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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
