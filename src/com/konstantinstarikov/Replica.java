package com.konstantinstarikov;

import java.io.IOException;

public abstract class Replica {
    public String text;

    abstract void print() throws IOException;
}
