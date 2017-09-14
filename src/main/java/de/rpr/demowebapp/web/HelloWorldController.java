package de.rpr.demowebapp.web;

import de.rpr.demowebapp.model.RequestMessage;
import de.rpr.demowebapp.model.ResponseMessage;
import de.rpr.demowebapp.repo.ResponseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class HelloWorldController {

    private final ResponseRepository responseRepo;

    @GetMapping
    ResponseMessage hello() {
        return new ResponseMessage(responseRepo.getResponse());
    }

    @PutMapping
    ResponseEntity<ResponseMessage> updateDefaultResponse(@RequestBody final RequestMessage defaultResponse) {
        responseRepo.setResponse(defaultResponse.getValue());
        return new ResponseEntity<>(new ResponseMessage(defaultResponse.getValue()), HttpStatus.OK);
    }
}
