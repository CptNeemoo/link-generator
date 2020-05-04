package com.cptneemoo.linkgenerator.service;

import com.cptneemoo.linkgenerator.dto.ExpandRequestDTOObject;
import com.cptneemoo.linkgenerator.entity.RequestResult;
import com.cptneemoo.linkgenerator.dto.ShortenRequestDTOObject;
import com.cptneemoo.linkgenerator.repository.RequestResultRepository;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.stereotype.Service;

@Service
public class WebService {

  private final RequestResultRepository requestResultRepository;

  public WebService(RequestResultRepository requestResultRepository) {
    this.requestResultRepository = requestResultRepository;
  }

  public RequestResult sendExpandRequest(String url) {
    String requestUrl = "https://api-ssl.bitly.com/v4/expand";
    HttpResponse<JsonNode> jsonNode = Unirest.post(requestUrl)
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer 7e78549e86fad3e310e89dc21124a2b9c166c96a")
            .body(new ExpandRequestDTOObject(url))
            .asJson();
    System.out.println(jsonNode.getBody().toPrettyString());
    String longUrl = jsonNode.getBody().getObject().getString("long_url");
    System.out.println();
    RequestResult result = new RequestResult(url, longUrl);
    return requestResultRepository.save(result);
  }

  public RequestResult sendShortenRequest(String url) {
    String requestUrl = "https://api-ssl.bitly.com/v4/shorten";
    String longUrl = Unirest.post(requestUrl)
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer 7e78549e86fad3e310e89dc21124a2b9c166c96a")
            .body(new ShortenRequestDTOObject(url))
            .asJson()
            .getBody()
            .getObject()
            .get("link")
            .toString();
    RequestResult result = new RequestResult(url, longUrl);
    return requestResultRepository.save(result);
  }

}
