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
                WikipediaDataParser("/testwiki-20170620-pages-articles-multistream.xml.zip",
                pages
        );
        parser.parse();
        assertTrue(pages.size() > 0);
    }
}