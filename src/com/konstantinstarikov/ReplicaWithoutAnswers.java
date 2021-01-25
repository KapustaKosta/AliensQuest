package com.konstantinstarikov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplicaWithoutAnswers extends Replica {
    public Replica nextReplica;

    public ReplicaWithoutAnswers(String text, Replica nextReplica) {
        this.nextReplica = nextReplica;
        this.text = text;
    }

    @Override
    void print() throws IOException {
        System.out.println(text);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
    }
}
