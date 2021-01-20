package com.Ann;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import java.io.*;
import java.io.File;
import java.io.IOException;

/*
 DocumentPDF - old file
 Stamp.jpg - stamp (cheburashka)
 MyPDF - new file
*/

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            PDDocument document = PDDocument.load(new File("DocumentPDF.pdf"));

            PDPage page = document.getPage(0);
            FileInputStream in = new FileInputStream("Stamp.jpg");
            PDImageXObject image = PDImageXObject.createFromFile("Stamp.jpg", document);
            PDPageContentStream stream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, false, false);
            stream.drawImage(image, 400, 150, 100, 100);
            stream.close();
            document.save("MyPDF.pdf");
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Done! Happy New Year!");
    }
}

