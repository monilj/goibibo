package steps;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppiumParallelExecution  {
public List<String> attachEmulators()
{
    List<String> devices = new ArrayList<>();
    String line;
    StringBuilder log = new StringBuilder();
    Process process;
    Runtime rt = Runtime.getRuntime();
    try{
        process = rt.exec(new String[]
                {"adb","devices","-l"});
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        while ((line=stdInput.readLine())!=null) {
            log.append(line);
            log.append(System.getProperty("line.separator"));
        }
        while ((line=stdError.readLine())!=null) {
            log.append(line);
            log.append(System.getProperty("line.separator"));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    Scanner scan = new Scanner(String.valueOf(log));
    while (scan.hasNextLine()){
        String oneLine = scan.nextLine();
        if (oneLine.contains("model")){
            devices.add(oneLine.split("device")[0].trim());
        }
    }
    return devices;
}

}



