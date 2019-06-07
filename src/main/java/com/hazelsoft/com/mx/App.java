package com.hazelsoft.com.mx;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class App {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Run passing the PDF path and Output text file as arguments.");
            System.out.println("java -jar  pdf2text.jar <path/to/pdf/file> <text/file/output/path/>");
            System.out.println("java -jar  pdf2text.jar C:\\Users\\example\\Documents\\Report.pdf C:\\Users\\example\\Documents\\Report.txt");
            return;
        }

        String pdfFilePath = args[0];
        String outputTextFilePath = args[1];

        System.out.println("Using PDF file path: " + pdfFilePath);
        System.out.println("Using output text file path: " + outputTextFilePath);

        try {
            try (PDDocument document = PDDocument.load(new File(pdfFilePath))) {
                document.getClass();
                if (!document.isEncrypted()) {
                    PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                    stripper.setSortByPosition(true);
                    PDFTextStripper tStripper = new PDFTextStripper();
                    String pdfFileInText = tStripper.getText(document);

                    File file = new File(outputTextFilePath);
                    FileUtils.writeStringToFile(file, pdfFileInText, StandardCharsets.UTF_8);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Completed!");
    }
}
