package de.rpr.demowebapp.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RequestMessage {
    private final String value;
}
