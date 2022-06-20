package com.example.junitsystemconsolewrapper;

import java.io.Closeable;

public interface Output extends Closeable {
    String getStdOut();

    String getStdErr();

    boolean isClosed();
}
