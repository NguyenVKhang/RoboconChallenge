package org.kbc2d.utils;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFileQuestionAnswering {
    List<List<String>> listQuestionAnswers = new ArrayList<>();
    String textInFile = "";
    public ReadFileQuestionAnswering(String path) {
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                textInFile += data + "\n";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String getTextInFile() {
        return textInFile;
    }

    public String getQuestion() {
        return textInFile.split("\n")[0];

    }
    public String getAnswer() {
        return textInFile.split("\n")[1];
    }

    public List<List<String>> formatQuestionAnswering() {
        // remove question first line
        if (textInFile.startsWith("Question: ")) {
            textInFile = textInFile.substring(10);
        }

        String[] listQuestionAnswering = textInFile.split("Question: ");
        for(int i = 0; i < listQuestionAnswering.length; i++) {
            String question = listQuestionAnswering[i].split("Answer:")[0];
            String answer = listQuestionAnswering[i].split("Answer:")[1];

            String[] listAnswer = answer.split("\n");
            String answerTrue = "";



            List<String> listQuestionAnswer = new ArrayList<>();
            listQuestionAnswer.add(question.replace("Question: ", ""));

            for(int j = 0; j < listAnswer.length; j++) {
                if (listAnswer[j].startsWith("True: ")) {
                    answerTrue = listAnswer[j].substring(6);
                    listQuestionAnswer.add(answerTrue);
                } else {
                    listQuestionAnswer.add(listAnswer[j]);
                }
            }

            // add first character of answerTrue to listQuestionAnswer

            listQuestionAnswer.add(answerTrue.substring(0, 1));


            listQuestionAnswers.add(listQuestionAnswer);
        }

        return listQuestionAnswers;
    }
}
