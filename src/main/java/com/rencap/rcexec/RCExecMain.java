package com.rencap.rcexec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RCExecMain {
    public static String exec(String inArgs) throws IOException, InterruptedException { //throws InterruptedException, IOException
        String[] args = inArgs.split(" ");
        ProcessBuilder pb = new ProcessBuilder(args);
        Process process = pb.start(); // run command
        String result = output(process.getInputStream()).trim();
        return result;

        //int errCode = process.waitFor();
        //System.out.println("Echo command executed, any errors? " + (errCode == 0 ? "No" : "Yes"));
        //System.out.println("Echo Output:\n" + output(process.getInputStream()));
    }

    private static String output(InputStream inputStream) throws IOException { //throws InterruptedException, IOException
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + System.getProperty("line.separator"));
            }
        }
        finally {
            br.close();
        }
        return sb.toString();
    }
}
