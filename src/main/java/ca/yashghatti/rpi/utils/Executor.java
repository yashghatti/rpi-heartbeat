package ca.yashghatti.rpi.utils;

import java.io.IOException;

public class Executor {

    public static String runCmd(String... cmd) throws IOException {
        String output = null;
        String errorOutput = null;
        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
        Process process = processBuilder.start();
        output = new String(process.getInputStream().readAllBytes());
        errorOutput = new String(process.getErrorStream().readAllBytes());

        return output;
    }

}
