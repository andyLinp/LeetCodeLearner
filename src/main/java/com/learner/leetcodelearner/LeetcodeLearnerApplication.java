package com.learner.leetcodelearner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeetcodeLearnerApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(LeetcodeLearnerApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
