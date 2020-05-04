package com.cptneemoo.linkgenerator.service;

import com.cptneemoo.linkgenerator.dto.ExpandRequestDTOObject;
import com.cptneemoo.linkgenerator.dto.ShortenRequestDTOObject;
import com.cptneemoo.linkgenerator.entity.RequestResult;
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
    url = trimUrl(url);
    HttpResponse<JsonNode> jsonNode = Unirest.post(requestUrl)
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer 7e78549e86fad3e310e89dc21124a2b9c166c96a")
            .body(new ExpandRequestDTOObject(url))
            .asJson();
    String longUrl = jsonNode.getBody().getObject().getString("long_url");
    RequestResult result = new RequestResult(url, longUrl);
    return requestResultRepository.save(result);
  }

  public RequestResult sendShortenRequest(String url) {
    String requestUrl = "https://api-ssl.bitly.com/v4/shorten";
    url = "https://" + trimUrl(url);
    HttpResponse<JsonNode> jsonNode = Unirest.post(requestUrl)
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer 7e78549e86fad3e310e89dc21124a2b9c166c96a")
            .body(new ShortenRequestDTOObject(url))
            .asJson();
    String longUrl = jsonNode.getBody().getObject().getString("id");
    RequestResult result = new RequestResult(url, longUrl);
    return requestResultRepository.save(result);
  }

  private String trimUrl(String url){
    if (url.startsWith("http://")){
      url = url.substring(7);
    }
    if (url.startsWith("https://")){
      url = url.substring(8);
    }
    return url;
  }

}
