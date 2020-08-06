package com.revseev.xml_parser;

import org.junit.jupiter.api.Test;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WikipediaDataParserTest {

    @Test
    public void testParse() throws IOException, XMLStreamException {
        final List<WikipediaPage> pages = new ArrayList();
        final WikipediaDataParser parser = new
                WikipediaDataParser("/metawiki-20191120-pages-articles-multistream2.xml-p1821603p2208725.xml",
                pages
        );
        parser.parse();
        int size = pages.size();
        System.out.println(size);
        assertTrue(size > 0);
    }
}