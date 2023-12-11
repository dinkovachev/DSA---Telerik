package com.company.dsa;

import java.nio.file.Paths;

import static com.company.dsa.FilesUtils.fileExists;
import static com.company.dsa.FilesUtils.findFiles;

//import static com.company.dsa.FilesUtils.fileExists;
//import static com.company.dsa.FilesUtils.findFiles;

public class Main {

    public static void main(String[] args) {
//        String path = Paths.get("demo").toAbsolutePath().toString();
//System.out.println(findFiles(path, "md"));
//        String path = Paths.get("demo").toAbsolutePath().toString();
//        System.out.println(fileExists(path, "test-3.md"));
//        System.out.println(fileExists(path, "test-2.md"));

        String path = Paths.get("demo").toAbsolutePath().toString();
        System.out.println(FilesUtils.getDirectoryStats(path));
    }

}
