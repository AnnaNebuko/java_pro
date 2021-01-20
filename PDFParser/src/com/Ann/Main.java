package com.Ann;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
/*
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
*/


public class Main {

    public static void main(String[] args) throws IOException {
        File file = null;
        PDDocument document = null;
        try {
            //1. Output the imported text to the console
            //=====================================================================

            file = new File ("C:\\Users\\annan\\OneDrive\\Рабочий стол\\ALICE.pdf");
            //Load an existing pdf document via the load () method of the PDDocument class
            document = PDDocument.load(file);

            //Creating an instance of the PDFTextStripper class, which
            // provides methods to extract text from PDF document
            PDFTextStripper stripper = new PDFTextStripper();

            //We can read content from PDF document,
            //using the getText () method of the PDFTextStripper class
            String text = stripper.getText(document);
            System.out.println(text);

            //2. Saving the output to a file
            //=====================================================================

            PrintWriter writer = new PrintWriter(new File
                    ("C:\\Users\\annan\\OneDrive\\Рабочий стол\\Output.txt"));
            writer.println(text);
            writer.flush();
            writer.close();
            System.out.println("Done");
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            document.close();
        }
    }
}


