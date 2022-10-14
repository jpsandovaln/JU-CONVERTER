package com.jalasoft.springboothelloworld.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Executor {
    private Process process;

    public void runCommand(List<String> command) throws IOException {
        initProcess(command);
        //readConsole();
    }

    private void initProcess(List<String> command) throws IOException {
        ProcessBuilder builder = new ProcessBuilder(command);
        Process process = builder.start();
        InputStream errorStream = process.getErrorStream();
        InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
        BufferedReader br = new BufferedReader(inputStreamReader);
        String line = "";
         while ((line = br.readLine())!= null)  {

         }
         if ( br!= null) {
            br.close();
         }
         if (inputStreamReader != null) {
            inputStreamReader.close();
         }
         if (errorStream != null) {
            errorStream.close();
         }

        /*builder.redirectErrorStream(true);

        try {
            process = builder.start();
        } catch (IOException e) {
            System.out.println (e);

        }*/
    }
    private void readConsole () {
        try {
            process.waitFor();
            InputStreamReader streamReader = new InputStreamReader(process.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder result = new StringBuilder();
            while(reader.ready()) {
                result.append((char) reader.read());
            }
            System.out.println(result.toString());
        } catch (InterruptedException e) {
            System.out.println (e);
        } catch (IOException e) {
            System.out.println (e);
        }
    }
}
