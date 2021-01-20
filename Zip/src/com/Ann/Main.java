package com.Ann;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

//A console application that saves all files and folders in a given directory to an archive.
// Example:
// Type the Source Folder:        M:\Авторство
// Type the Output Zip File:      M:\Авторство.zip

public class Main {
    private ArrayList <String> fileList;
    static String sourceFolder;

    //Constructor initializing fileList
    public Main(){
        fileList = new ArrayList<String>();
    }
    public static void main(String[] args) throws IOException {
        System.out.println("Type the Source Folder: ");
        Scanner scanner = new Scanner (System.in);
        sourceFolder  = scanner.nextLine();

        System.out.println("Type the Output Zip File: ");
        Scanner scanner2 = new Scanner (System.in);
        String outputZipFile = scanner2.nextLine();

        Main zipDemo = new Main();
        zipDemo.generateFileList(new File(sourceFolder));
        zipDemo.zipIt (outputZipFile);

    }
    public void zipIt (String zipFile) throws IOException{
        byte [] buffer = new byte [1024];
        try (
            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos)) {
            System.out.println("Output to Zip: " + zipFile);
            for (String file : this.fileList) {
                System.out.println("File Added: " + file);
                ZipEntry ze = new ZipEntry("test1.txt");
                zos.putNextEntry(ze);

                FileInputStream in = new FileInputStream(sourceFolder + File.separator + file);
                int len;
                while ((len = in.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                in.close();
            }
            zos.closeEntry();
            System.out.println("Zip file is created.");
        }

    }
    // Recursion
    public void generateFileList (File node){
        if (node.isFile()){
            fileList.add(generateZipEntry(node.getAbsoluteFile().toString()));
        }
        if (node.isDirectory()){
            String [] subNote = node.list();
            for (String filename : subNote){
                generateFileList(new File (node, filename));
            }
        }
    }
    private String generateZipEntry(String file){
        return file.substring (sourceFolder.length() + 1, file.length());
    }
}
