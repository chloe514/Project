package com.filemanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileOperations fileOps = new FileOperations();
        DirectoryOperations dirOps = new DirectoryOperations();
        SearchOperations searchOps = new SearchOperations();

        while (true) {
            System.out.println("File Manager");
            System.out.println("1. Display directory contents");
            System.out.println("2. Copy file");
            System.out.println("3. Move file");
            System.out.println("4. Delete file");
            System.out.println("5. Create directory");
            System.out.println("6. Delete directory");
            System.out.println("7. Search files");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the directory path: ");
                    String dirPath = scanner.nextLine();
                    fileOps.displayDirectoryContents(dirPath);
                    break;
                case 2:
                    System.out.print("Enter the source file path: ");
                    String sourcePath = scanner.nextLine();
                    System.out.print("Enter the destination file path: ");
                    String destPath = scanner.nextLine();
                    fileOps.copyFile(sourcePath, destPath);
                    break;
                case 3:
                    System.out.print("Enter the source file path: ");
                    sourcePath = scanner.nextLine();
                    System.out.print("Enter the destination file path: ");
                    destPath = scanner.nextLine();
                    fileOps.moveFile(sourcePath, destPath);
                    break;
                case 4:
                    System.out.print("Enter the file path to delete: ");
                    String filePath = scanner.nextLine();
                    fileOps.deleteFile(filePath);
                    break;
                case 5:
                    System.out.print("Enter the directory path to create: ");
                    dirPath = scanner.nextLine();
                    dirOps.createDirectory(dirPath);
                    break;
                case 6:
                    System.out.print("Enter the directory path to delete: ");
                    dirPath = scanner.nextLine();
                    dirOps.deleteDirectory(dirPath);
                    break;
                case 7:
                    System.out.print("Enter the directory path to search in: ");
                    dirPath = scanner.nextLine();
                    System.out.print("Enter the search term (file name or extension): ");
                    String searchTerm = scanner.nextLine();
                    searchOps.searchFiles(dirPath, searchTerm);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }}



