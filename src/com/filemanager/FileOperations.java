package com.filemanager;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

public class FileOperations {
    private static final Logger logger = Utils.getLogger(FileOperations.class.getName());

    public void displayDirectoryContents(String dirPath) {
        File directory = new File(dirPath);
        if (directory.exists() && directory.isDirectory()) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            File[] files = directory.listFiles();
            if (files != null) {
                System.out.printf("%-30s%-15s%-20s%n", "File Name", "File Size", "Last Modified");
                System.out.println("--------------------------------------------------------------");
                for (File file : files) {
                    System.out.printf("%-30s%-15d%-20s%n", file.getName(), file.length(), sdf.format(file.lastModified()));
                }
            } else {
                System.out.println("The directory is empty.");
            }
        } else {
            System.out.println("The specified path is not a directory or does not exist.");
        }
    }

    public void copyFile(String sourcePath, String destPath) {
        try {
            Files.copy(Paths.get(sourcePath), Paths.get(destPath), StandardCopyOption.REPLACE_EXISTING);
            logger.info("File copied from " + sourcePath + " to " + destPath);
        } catch (IOException e) {
            logger.severe("Error copying file: " + e.getMessage());
        }
    }

    public void moveFile(String sourcePath, String destPath) {
        try {
            Files.move(Paths.get(sourcePath), Paths.get(destPath), StandardCopyOption.REPLACE_EXISTING);
            logger.info("File moved from " + sourcePath + " to " + destPath);
        } catch (IOException e) {
            logger.severe("Error moving file: " + e.getMessage());
        }
    }

    public void deleteFile(String filePath) {
        try {
            Files.delete(Paths.get(filePath));
            logger.info("File deleted: " + filePath);
        } catch (IOException e) {
            logger.severe("Error deleting file: " + e.getMessage());
        }
    }
}


