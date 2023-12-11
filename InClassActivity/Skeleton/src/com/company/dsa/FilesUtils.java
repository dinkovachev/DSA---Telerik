package com.company.dsa;

import java.io.File;
import java.nio.file.Path;
import java.util.*;


public class FilesUtils {

    public static void traverseDirectories(String path) {
        List<Path> files = new ArrayList<>();
        listFiles(path, files);
    }

    private static void listFiles(String path, List<Path> collectedFiles) {
        File root = new File(path);
        File[] files = root.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {

            if (file.isDirectory()) {
                System.out.println(file.getName());
                listFiles(file.getAbsolutePath(), collectedFiles);
            } else {
                System.out.println(file.getName());
                collectedFiles.add(file.toPath());
            }
        }
    }

    public static List<String> findFiles(String path, String extension) {
        File root = new File(path);
        File[] files = root.listFiles();
        List<String> filesAsString = new ArrayList<>();

        if (files == null) {
            return Collections.singletonList("");
        }

        for (File file : files) {

            if (file.isFile() && file.getName().endsWith(extension)) {
                filesAsString.add(file.getName());
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                findFiles(file.getAbsolutePath(), extension);
            }
        }
        return filesAsString;
    }

    public static boolean fileExists(String path, String fileName) {
        File root = new File(path);
        File[] files = root.listFiles();

        if (files == null) {
            return false;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                if (fileExists(file.getAbsolutePath(), fileName)) {
                    return true;
                }
            } else if (file.getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    public static Map<String, Integer> getDirectoryStats(String path) {
        throw new UnsupportedOperationException();
    }
}



