package com.filemanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileOperations fileOps = new FileOperations();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("File Manager Options:");
            System.out.println("1. Display Directory Contents");
            System.out.println("2. Copy File");
            System.out.println("3. Move File");
            System.out.println("4. Delete File");
            System.out.println("5. Create Directory");
            System.out.println("6. Delete Directory");
            System.out.println("7. Search Files");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter directory path: ");
                    String dirPath = scanner.nextLine();
                    fileOps.displayDirectoryContents(dirPath);
                    break;
                case 2:
                    System.out.print("Enter source file path: ");
                    String sourcePath = scanner.nextLine();
                    System.out.print("Enter destination file path: ");
                    String destPath = scanner.nextLine();
                    fileOps.copyFile(sourcePath, destPath);
                    break;
                case 3:
                    System.out.print("Enter source file path: ");
                    String sourcePathMove = scanner.nextLine();
                    System.out.print("Enter destination file path: ");
                    String destPathMove = scanner.nextLine();
                    fileOps.moveFile(sourcePathMove, destPathMove);
                    break;
                case 4:
                    System.out.print("Enter file path to delete: ");
                    String filePath = scanner.nextLine();
                    fileOps.deleteFile(filePath);
                    break;
                case 5:
                    System.out.print("Enter directory path to create: ");
                    String createDirPath = scanner.nextLine();
                    fileOps.createDirectory(createDirPath);
                    break;
                case 6:
                    System.out.print("Enter directory path to delete: ");
                    String deleteDirPath = scanner.nextLine();
                    fileOps.deleteDirectory(deleteDirPath);
                    break;
                case 7:
                    System.out.print("Enter directory path: ");
                    String searchDirPath = scanner.nextLine();
                    System.out.print("Enter search term: ");
                    String searchTerm = scanner.nextLine();
                    fileOps.searchFiles(searchDirPath, searchTerm);
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}




