package com.example.junitsystemconsolewrapper;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RecordingPrintStreamTest {

    @Test
    void testCreatePrintStream() {
        OutputStream outputStream = OutputStream.nullOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        RecordingPrintStream recordingPrintStream = new RecordingPrintStream(printStream, new Recorder());

        PrintStream sink = recordingPrintStream.getSink();

        assertSame(sink, printStream);
    }

    @Test
    void testPassWrite() {
        String hello = "hello";
        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        RecordingPrintStream recordingPrintStream = new RecordingPrintStream(printStream, new Recorder());

        recordingPrintStream.print(hello);

        assertEquals(hello, outputStream.toString());
    }
}
