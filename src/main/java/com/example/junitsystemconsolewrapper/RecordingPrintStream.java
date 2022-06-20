package com.example.junitsystemconsolewrapper;

import lombok.Getter;

import java.io.PrintStream;

public final class RecordingPrintStream extends PrintStream {
    @Getter
    private final PrintStream sink;

    public RecordingPrintStream(PrintStream printStream, Recorder recorder) {
        super(new RecordingOutputStream(recorder, printStream));
        this.sink = printStream;
    }

}
