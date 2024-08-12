package com.filemanager;

import java.io.File;
import java.util.logging.Logger;

public class DirectoryOperations {
    private static final Logger logger = Utils.getLogger(DirectoryOperations.class.getName());

    public void createDirectory(String dirPath) {
        File directory = new File(dirPath);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                logger.info("Directory created: " + dirPath);
            } else {
                logger.severe("Failed to create directory: " + dirPath);
            }
        } else {
            System.out.println("Directory already exists.");
        }
    }

    public void deleteDirectory(String dirPath) {
        File directory = new File(dirPath);
        if (directory.exists() && directory.isDirectory()) {
            if (deleteRecursively(directory)) {
                logger.info("Directory deleted: " + dirPath);
            } else {
                logger.severe("Failed to delete directory: " + dirPath);
            }
        } else {
            System.out.println("The specified path is not a directory or does not exist.");
        }
    }

    private boolean deleteRecursively(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteRecursively(f);
                } else {
                    f.delete();
                }
            }
        }
        return file.delete();
    }
}

