package com.raidancampbell.buildping;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@RestController
public class BuildPingController {

    private static Gson gson = new Gson();

    @GetMapping("ping")
    public String getHealth(HttpServletResponse response) {
        response.setContentType("application/json");
        String details = readFile("build.details");

        Map<String, String> responseMap = new HashMap<>();

        for(String line: details.split("\n")) {
            String[] keyVal = line.split("=");
            responseMap.put(keyVal[0], keyVal[1]);
        }
        return gson.toJson(responseMap).replaceAll(",", ",\n");
    }


    private String readFile(String fileName) {

        StringBuilder result = new StringBuilder("");

        //Get file from resources folder
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                result.append(scanner.nextLine()).append("\n");
            }
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();

    }
}
