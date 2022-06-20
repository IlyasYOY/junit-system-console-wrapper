package com.example.junitsystemconsolewrapper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(OutputExtension.class)
@ExtendWith(OutputCaptureExtension.class)
class MainTest {

    Output output;

    @Test
    void testCaptureStdOut(
            Output output
    ) {
        String expectedString = "Hello Out";
        System.out.println(expectedString);

        String content = output.getStdOut();

        assertAll(
                () -> assertNotNull(content),
                () -> assertTrue(content.contains(expectedString))
        );
    }

    @Test
    void testCaptureStdErr() {
        String expectedString = "Hello Err";
        System.err.println(expectedString);

        String content = output.getStdErr();

        assertAll(
                () -> assertNotNull(content),
                () -> assertTrue(content.contains(expectedString))
        );
    }
}
