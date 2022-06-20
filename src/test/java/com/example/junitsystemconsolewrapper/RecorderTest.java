package com.example.junitsystemconsolewrapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecorderTest {

    @Test
    void testRecord() {
        String hello = "hello";
        Recorder recorder = new Recorder();

        recorder.record(hello);
        String recorded = recorder.getRecorded();

        assertEquals(hello, recorded);
    }

}