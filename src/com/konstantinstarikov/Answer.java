package com.konstantinstarikov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Answer {
    public String text;
    private Replica nextReplica;
    public Action action;

    public Answer(String text, Replica nextReplica) {
        this.text = text;
        this.nextReplica = nextReplica;
    }

    public Answer(String text, Replica nextReplica, Action action) {
        this.text = text;
        this.nextReplica = nextReplica;
        this.action = action;
    }

    public void playNextReplica() throws IOException {
        nextReplica.print();
        if(nextReplica instanceof ReplicaWithAnswers)
        {
            String userInput = new Scanner(System.in).nextLine();
            ((ReplicaWithAnswers) nextReplica).playNextReplica(userInput);
        }
        else if(nextReplica instanceof ReplicaWithoutAnswers) {
            nextReplica = ((ReplicaWithoutAnswers) nextReplica).nextReplica;
            playNextReplica();
        }
        if(action != null) action.run();
    }
}

@FunctionalInterface
interface Action {
    void run() throws IOException;
}
