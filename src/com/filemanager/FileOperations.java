package com.filemanager;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileOperations {
    private static final Logger LOGGER = Logger.getLogger(FileOperations.class.getName());

    public void displayDirectoryContents(String dirPath) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dirPath))) {
            for (Path entry : stream) {
                BasicFileAttributes attrs = Files.readAttributes(entry, BasicFileAttributes.class);
                System.out.println(entry.getFileName() + " | Size: " + attrs.size() + " | Last Modified: " + attrs.lastModifiedTime());
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading directory contents", e);
        }
    }

    public void copyFile(String sourcePath, String destPath) {
        try {
            Files.copy(Paths.get(sourcePath), Paths.get(destPath), StandardCopyOption.REPLACE_EXISTING);
            LOGGER.info("File copied from " + sourcePath + " to " + destPath);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error copying file", e);
        }
    }

    public void moveFile(String sourcePath, String destPath) {
        try {
            Files.move(Paths.get(sourcePath), Paths.get(destPath), StandardCopyOption.REPLACE_EXISTING);
            LOGGER.info("File moved from " + sourcePath + " to " + destPath);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error moving file", e);
        }
    }

    public void deleteFile(String filePath) {
        try {
            Files.delete(Paths.get(filePath));
            LOGGER.info("File deleted: " + filePath);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error deleting file", e);
        }
    }

    public void createDirectory(String dirPath) {
        try {
            Files.createDirectory(Paths.get(dirPath));
            LOGGER.info("Directory created: " + dirPath);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error creating directory", e);
        }
    }

    public void deleteDirectory(String dirPath) {
        try {
            Files.delete(Paths.get(dirPath));
            LOGGER.info("Directory deleted: " + dirPath);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error deleting directory", e);
        }
    }

    public void searchFiles(String dirPath, String searchTerm) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dirPath), "*" + searchTerm + "*")) {
            for (Path entry : stream) {
                System.out.println(entry.getFileName());
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error searching files", e);
        }
    }
}



