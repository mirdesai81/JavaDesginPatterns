package com.java.algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class CSVReader {
    public static List<String> readData(String file) throws IOException {
        List<String> data = new LinkedList<>();
        InputStream in;
        int count = 0;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(CSVReader.class.getClassLoader().getResourceAsStream(file)))) {
            String line = br.readLine();
            while((line = br.readLine()) != null) {
                data.add(line.split(",")[0]);
            }
            return data;
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) throws Exception {
        List<String> testZips = readData("TestStores.csv");
        List<String> controlZips = readData("ControlStores.csv");

        testZips.removeAll(controlZips);
        System.out.println(controlZips);
        System.out.println(testZips);
    }
}
