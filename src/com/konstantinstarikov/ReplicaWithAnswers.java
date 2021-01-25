package com.konstantinstarikov;

import java.io.IOException;

public class ReplicaWithAnswers extends Replica {
    public Answer[] answers;

    public ReplicaWithAnswers(String text, Answer... answers)
    {
        this.answers = answers.clone();
        this.text = text;
    }


    public void playNextReplica(String userAnswer) throws IOException {
        for (int i = 0; i < answers.length; i++) {
            if (userAnswer.equals(Integer.toString(i + 1)))
            {
                answers[i].playNextReplica();
            }
        }
    }

    @Override
    void print() {
        System.out.println(text);
        for (int i = 0 ; i < answers.length; i++)
        {
            System.out.println((i + 1) + ": " + answers[i].text);
        }
    }
}

