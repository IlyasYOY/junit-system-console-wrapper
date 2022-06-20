package com.example.junitsystemconsolewrapper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

abstract class BaseTest {
    protected Output output;

    @BeforeEach
    protected void prepareOutput() {
        output = new RecordingOutput();
    }

    @AfterEach
    protected void closeOutput() throws IOException {
        output.close();
    }
}
