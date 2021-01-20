package com.Ann;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader( new FileReader ("phx.log"));
        String input = "";
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("input.separator");
        while( (input = reader.readLine()) != null ) {
            stringBuilder.append( input);
            stringBuilder.append( ls );
        }
        input = stringBuilder.toString();

        Pattern regexClientVer = Pattern.compile("\\s\\d\\.\\d\\.\\d{3}\\s");
        Pattern regexData = Pattern.compile ("\\d{4}\\/\\d{2}\\/\\d{2}");
        Pattern regexTime = Pattern.compile ("\\d{2}:\\d{2}:\\d{2}");
        Pattern regexUserName = Pattern.compile ("(\\w+)@");
        Pattern regexServerVer = Pattern.compile ("agent\\sver:\\d\\.\\d\\.\\d{3}");

        Matcher m1 = regexClientVer.matcher(input);
        if (m1.find()){
            System.out.println("Client Version: " + m1.group(0).trim());
        }

        Matcher m2 = regexData.matcher(input);
        if (m2.find()){
            System.out.println("Data: " + m2.group(0).trim());
        }

        Matcher m3 = regexTime.matcher(input);
        if (m3.find()){
            System.out.println("Time: " + m3.group(0).trim());
        }

        Matcher m4 = regexUserName.matcher(input);
        if (m4.find()){

            System.out.println("User Name: " + m4.group(0).trim());
        }

        Matcher m5 = regexServerVer.matcher(input);
        if (m5.find()){
            System.out.println("Server Version: " + m5.group(0).trim());
        }
    }
}
