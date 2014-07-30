package per.kayu.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class FileWriterTest {
    public static void main(String args[]) {

        String filePath = "D:\\WORK\\UNITLEADTIME\\BufferedWriter.txt";
        File file = new File(filePath);
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("BufferedWriter");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String outputFile = "D:\\WORK\\UNITLEADTIME\\PrintWriter.txt";
        try {
            FileOutputStream os = new FileOutputStream(outputFile);
            OutputStreamWriter osWriter = null;
            osWriter = new OutputStreamWriter(os, "UTF-8");
            PrintWriter printerWriter = null;
            printerWriter = new PrintWriter(osWriter, true);
            printerWriter.print("PrintWriter");
            printerWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

}
