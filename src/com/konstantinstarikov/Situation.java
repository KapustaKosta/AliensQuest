package com.konstantinstarikov;

import java.io.IOException;
import java.util.Scanner;

public class Situation {
    public Replica currentReplica;


    public Situation(Replica currentReplica) {
        this.currentReplica = currentReplica;
    }

    public void play() throws IOException {
        currentReplica.print();
        if(currentReplica instanceof  ReplicaWithAnswers)
        {
            String userInput = new Scanner(System.in).nextLine();
            ((ReplicaWithAnswers) currentReplica).playNextReplica(userInput);
        }
        else if(currentReplica instanceof ReplicaWithoutAnswers) {
            currentReplica = ((ReplicaWithoutAnswers) currentReplica).nextReplica;
            play();
        }
    }
}
