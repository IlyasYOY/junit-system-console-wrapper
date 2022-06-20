package com.example.junitsystemconsolewrapper;

import java.io.IOException;
import java.io.OutputStream;

public final class RecordingOutputStream extends OutputStream {

    private final Recorder recorder;
    private final OutputStream sink;

    public RecordingOutputStream(Recorder recorder, OutputStream sink) {
        this.recorder = recorder;
        this.sink = sink;
    }

    @Override
    public void write(int b) throws IOException {
        byte byteValue = Integer.valueOf(b).byteValue();
        write(new byte[]{byteValue});
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        String data = new String(b, off, len);
        recorder.record(data);
        sink.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        sink.flush();
    }
}
