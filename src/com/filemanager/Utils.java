package com.filemanager;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Utils {

    public static Logger getLogger(String className) {
        Logger logger = Logger.getLogger(className);
        try {
            FileHandler fileHandler = new FileHandler("logs/file_manager.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logger;
    }
}
