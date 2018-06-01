package com.epam.task2.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {

    public String loadStringFromFile(String fileName){
        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            char[] buff = new char[100];
            int readChars = 0;
            while((readChars = reader.read(buff)) != -1){
                if (buff.length == readChars){
                    sb.append(buff);
                } else {
                    char[] tmp = new char[readChars];
                    System.arraycopy(buff, 0, tmp, 0, readChars);
                    sb.append(tmp);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
