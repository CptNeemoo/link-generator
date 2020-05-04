package com.cptneemoo.linkgenerator.controller;

import com.cptneemoo.linkgenerator.dto.ExpandResponseDTOObject;
import com.cptneemoo.linkgenerator.dto.ShortenRequestDTOObject;
import com.cptneemoo.linkgenerator.entity.RequestResult;
import com.cptneemoo.linkgenerator.service.WebService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
public class WebController {

  private final WebService webService;

  public WebController(WebService webService) {
    this.webService = webService;
  }

  @GetMapping("/expand")
  public ExpandResponseDTOObject getUrlForExpansion(@RequestParam(name="url") String url)
          throws UnsupportedEncodingException {
    RequestResult requestResult = webService.sendExpandRequest(trimUrl(url));
    return new ExpandResponseDTOObject(requestResult.getUrlAfter());
  }

  @GetMapping("/shorten")
  public ShortenRequestDTOObject getUrlForShorten(@RequestParam(name="url") String url)
          throws UnsupportedEncodingException {
    RequestResult requestResult = webService.sendShortenRequest(trimUrl(url));
    return new ShortenRequestDTOObject(requestResult.getUrlAfter());
  }

  public String trimUrl(String originalUrl) throws UnsupportedEncodingException {
    String url;
    if (originalUrl.startsWith("http://")){
      url = originalUrl.substring(7);
    } else {
      if (originalUrl.startsWith("https://")){
        url =  originalUrl.substring(8);
      } else url =  originalUrl;
    }
    //return URLEncoder.encode(url, StandardCharsets.UTF_8.toString());
    return url;
  }

}

