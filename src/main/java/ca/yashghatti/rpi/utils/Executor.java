package ca.yashghatti.rpi.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class Executor {

    public static String runCmd(String... cmd) throws IOException {
        String output = null;
        String errorOutput = null;
        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
        Process process = processBuilder.start();
        output = new String(process.getInputStream().readAllBytes());
        errorOutput = new String(process.getErrorStream().readAllBytes());

        if(StringUtils.isNotBlank(errorOutput)){
            throw new IOException(errorOutput);
        }

        return output;
    }

}
