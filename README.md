# PDFToText
Small Java Application which converts a PDF file to a text file using the PDFBox library.

## How to build and run

    mvn clean compile assembly:single
    java -jar target\pdf-to-text-1.0-SNAPSHOT-jar-with-dependencies.jar
    
## How to run

Download latest jar: [pdf2text.jar](https://github.com/hmojicag/PDFToText/raw/master/builds/pdf2text.jar)
Run

    java -jar pdf2text.jar <path/to/pdf/file> <text/file/output/path/>

Example

    java -jar pdf2text.jar "C:\Users\user\Downloads\Report.pdf" "C:\Users\user\Downloads\Report.txt"

