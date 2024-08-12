package com.filemanager;

import java.io.File;
import java.util.logging.Logger;

public class SearchOperations {
    private static final Logger logger = Utils.getLogger(SearchOperations.class.getName());

    public static void searchFiles(String directory, String searchTerm) {
        try {
            File dir = new File(directory);
            if (dir.isDirectory()) {
                searchRecursive(dir, searchTerm);
                logger.info("Searched for files with term '" + searchTerm + "' in directory " + directory);
            } else {
                System.out.println("Path is not a directory.");
            }
        } catch (Exception e) {
            logger.severe("Failed to search files: " + e.getMessage());
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void searchRecursive(File dir, String searchTerm) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchRecursive(file, searchTerm);
                } else if (file.getName().contains(searchTerm)) {
                    System.out.println("Found: " + file.getAbsolutePath());
                }
            }
        }
    }
}

