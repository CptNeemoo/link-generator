package com.cptneemoo.linkgenerator.controller;

import com.cptneemoo.linkgenerator.dto.ExpandResponseDTOObject;
import com.cptneemoo.linkgenerator.dto.ShortenResponseDTOObject;
import com.cptneemoo.linkgenerator.entity.RequestResult;
import com.cptneemoo.linkgenerator.service.WebService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

  private final WebService webService;

  public WebController(WebService webService) {
    this.webService = webService;
  }

  @GetMapping("/expand")
  public ExpandResponseDTOObject getUrlForExpansion(@RequestParam(name="url") String url) {
    RequestResult requestResult = webService.sendExpandRequest(url);
    return new ExpandResponseDTOObject(requestResult.getUrlAfter());
  }

  @GetMapping("/shorten")
  public ShortenResponseDTOObject getUrlForShorten(@RequestParam(name="url") String url) {
    RequestResult requestResult = webService.sendShortenRequest(url);
    return new ShortenResponseDTOObject(requestResult.getUrlAfter());
  }

}

