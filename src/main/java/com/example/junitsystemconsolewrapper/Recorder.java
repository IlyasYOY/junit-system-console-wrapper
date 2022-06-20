package com.example.junitsystemconsolewrapper;

public final class Recorder {

    private final StringBuilder recorder = new StringBuilder();
    public void record(String record) {
        recorder.append(record);
    }

    public String getRecorded() {
        return recorder.toString();
    }
}
