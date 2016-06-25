package com.example;

import java.util.ArrayList;
import java.util.Random;

public class MyJokesClass {

    ArrayList<String> jokeList;
    private Random randomGenerator;

    public MyJokesClass(){
        jokeList = new ArrayList<String>();
        jokeList.add("Joke No. 1");
        jokeList.add("Joke No. 2");
        jokeList.add("Joke No. 3");
        jokeList.add("Joke No. 4");
        jokeList.add("Joke No. 5");
        jokeList.add("Joke No. 6");
        jokeList.add("Joke No. 7");
        jokeList.add("Joke No. 8");
        jokeList.add("Joke No. 9");
        jokeList.add("Joke No. 10");
        randomGenerator = new Random();

    }

    public String getJoke(){
        int index = randomGenerator.nextInt(jokeList.size());
        return jokeList.get(index);
    }
}
