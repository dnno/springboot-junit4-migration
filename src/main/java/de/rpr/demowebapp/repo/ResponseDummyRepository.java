package de.rpr.demowebapp.repo;

import org.springframework.stereotype.Repository;

@Repository
public class ResponseDummyRepository implements ResponseRepository {

    private String response = "Hello World!";

    @Override
    public String getResponse() {
        return response;
    }

    @Override
    public void setResponse(final String response) {
        this.response = response;
    }
}
