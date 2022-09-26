package com.sparta.model;

import com.github.javafaker.Faker;

public class JavaFaker {

    /**
     * Random fake data generator
     */
    static Faker javaFaker = new Faker();

    public static Faker getJavaFaker() {
        return javaFaker;
    }

}
