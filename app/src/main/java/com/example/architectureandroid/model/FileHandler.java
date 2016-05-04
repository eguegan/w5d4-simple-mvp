package com.example.architectureandroid.model;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created by evin on 5/4/16.
 */
public class FileHandler {

    private String mFilename;

    //Test it with a unit test
    //That cleans the file before and after the test.

    public FileHandler(String filename) {
        mFilename = filename;
    }

    public void addFile(String text) {

        try {
            PrintWriter writer = new PrintWriter(mFilename, "UTF-8");
            writer.println(text);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String retrieveFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(mFilename));
        StringBuilder sb = new StringBuilder();

        try {
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
        } finally {
            br.close();
        }

        return sb.toString();
    }

    public void clean() {
        //Delete the file
    }
}
