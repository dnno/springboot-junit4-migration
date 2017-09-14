package de.rpr.demowebapp.web;

import de.rpr.demowebapp.model.RequestMessage;
import de.rpr.demowebapp.model.ResponseMessage;
import de.rpr.demowebapp.repo.ResponseDummyRepository;
import de.rpr.demowebapp.repo.ResponseRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldControllerTest {

    HelloWorldController controller;
    @Mock
    ResponseRepository responseRepo;

    @Before
    public void setup() {
        controller = new HelloWorldController(responseRepo);
    }

    @Test
    public void should_return_responseMessage_with_value_Hello_World() {
        when(responseRepo.getResponse()).thenReturn("Hello World!");
        assertEquals(new ResponseMessage("Hello World!"), controller.hello());
    }

    @Test
    public void should_be_able_to_set_default_response() {
        ResponseEntity<ResponseMessage> responseBody = controller.updateDefaultResponse(new RequestMessage("Default Response!"));
        assertEquals(HttpStatus.OK, responseBody.getStatusCode());
        assertNotNull(responseBody.getBody());
        assertEquals(new ResponseMessage("Default Response!"), responseBody.getBody());
        verify(responseRepo).setResponse("Default Response!");
    }

    @Test
    public void should_use_repository_for_response_value() {
        controller.hello();
        verify(responseRepo).getResponse();
    }
}