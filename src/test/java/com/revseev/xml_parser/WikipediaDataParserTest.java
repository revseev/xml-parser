package com.revseev.xml_parser;

import org.junit.jupiter.api.Test;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WikipediaDataParserTest {

    @Test
    public void zip() throws Exception {
        String sourceFile = "metawiki-20191120-pages-articles-multistream2.xml-p1821603p2208725.xml";
        FileOutputStream fos = new FileOutputStream("compressed.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        File fileToZip = new File(sourceFile);
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        zipOut.close();
        fis.close();
        fos.close();
    }

    @Test
    public void testParse() throws IOException, XMLStreamException {

        final List<WikipediaPage> pages = new ArrayList();
        final WikipediaDataParser parser = new WikipediaDataParser("/compressed.zip", pages);
        parser.parse();
        int size = pages.size();
        System.out.println(size);
        assertTrue(size > 0);
    }
}