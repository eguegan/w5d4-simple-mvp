package com.example.architectureandroid;

import com.example.architectureandroid.model.FileHandler;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by evin on 5/4/16.
 */
public class FileHandlerTest {

    private static final String TEXT_TO_ADD = "HELLO_WORLD";
    private static final String FILE_NAME = "hello.txt";

    FileHandler mFileHandler;

    @Before
    public void prepareFile() {
        mFileHandler = new FileHandler(FILE_NAME);
    }

    @Test
    public void file_isWriting() {
        mFileHandler.addFile(TEXT_TO_ADD);
    }

    @Test
    public void file_isReading() throws IOException {
        assertEquals(TEXT_TO_ADD, mFileHandler.retrieveFile());
    }

    @After
    public void removeFile() {
        mFileHandler.clean();
    }
}
