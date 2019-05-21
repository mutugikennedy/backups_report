package com.backup.reports.resources;

import java.io.FileReader;
import java.util.Properties;

public class Configuration {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("///")) {
            Properties properties = new Properties();
            properties.load(reader);
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}