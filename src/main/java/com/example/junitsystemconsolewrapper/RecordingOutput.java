package com.example.junitsystemconsolewrapper;

import lombok.Getter;

import java.io.IOException;
import java.io.PrintStream;

public final class RecordingOutput implements Output {

    private final PrintStream out;
    private final PrintStream err;
    private final Recorder outRecorder = new Recorder();
    private final Recorder errRecorder = new Recorder();

    @Getter
    private boolean closed = false;

    public RecordingOutput() {
        this.out = System.out;
        this.err = System.err;
        System.setOut(new RecordingPrintStream(System.out, outRecorder));
        System.setErr(new RecordingPrintStream(System.err, errRecorder));
    }

    @Override
    public String getStdOut() {
        return outRecorder.getRecorded();
    }

    @Override
    public String getStdErr() {
        return errRecorder.getRecorded();
    }

    @Override
    public void close() throws IOException {
        closed = true;
        System.setErr(err);
        System.setOut(out);
    }
}
