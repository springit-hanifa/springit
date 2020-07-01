package com.hanifa.springit.controller;

import com.hanifa.springit.domain.Link;
import com.hanifa.springit.exception.LinkNotFoundException;
import com.hanifa.springit.service.SpringitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@Slf4j
public class SpringitController {
    @Autowired
    SpringitService springitService;

    @GetMapping(path="/v1/link/{id}")
    public Link getLinkById(@PathVariable(value = "id") Long linkId) throws LinkNotFoundException {
        return springitService.getLinkDetailsById(linkId).orElseThrow(() -> new LinkNotFoundException(linkId));

    }

    @GetMapping(path="/v1/links")
    public List<Link> getAllLinks() {
        return springitService.getLinks();
    }

    @PostMapping(path= "/links/create", consumes = "application/json", produces = "application/json")
    public boolean createLink(@Validated @RequestBody Link link){
        return springitService.createLink(link);
    }

    /*
        Assume that we are calling two different micro services of amazon.com and google.com
        I am going to use completable future class to call both the methods asyncronously
        and prepare the result to send the response
     */
    public String callMicroServiceAsync() throws ExecutionException, InterruptedException {
        String combined = "";
        CompletableFuture<String> amzFuture = CompletableFuture.supplyAsync(()-> "Call the first microservice and get response");
        CompletableFuture<String> googleFuture = CompletableFuture.supplyAsync(()-> "Call the second microservice and get response");
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(amzFuture, googleFuture);
        combinedFuture.get();
        if(combinedFuture.isDone()){
            combined = Stream.of(amzFuture, googleFuture)
                    .map(CompletableFuture::join)
                    .collect(Collectors.joining(" "));
        }
        return combined;
    }


}
