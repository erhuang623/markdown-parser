import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition()
    {
        assertEquals(2,1+1);
    }

    @Test
    public void testGetLinks() throws IOException
    {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);

        ArrayList<String> expected = new ArrayList<String>();
        expected.add("https://something.com");
        expected.add("some-thing.html");

        assertEquals(expected,links);
    }

    @Test
    public void test2GetLinks() throws IOException
    {
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);

        ArrayList<String> expected = new ArrayList<String>();
        expected.add("https://canvas.ucsd.edu");
        expected.add("https://docs.oracle.com/javase/7/docs/api/java/lang/String.html");

        assertEquals(expected,links);
    }

    @Test
    public void test3GetLinks() throws IOException
    {
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);

        ArrayList<String> expected = new ArrayList<String>();
        expected.add("abc");

        assertEquals(expected,links);
    }

    @Test
    public void test4GetLinks() throws IOException
    {
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);

        ArrayList<String> expected = new ArrayList<String>();
        expected.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule?authuser=0");

        assertEquals(expected, links);
    }

    @Test
    public void test5GetLinks() throws IOException
    {
        Path fileName = Path.of("test-file5.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);

        ArrayList<String> expected = new ArrayList<String>();
        expected.add("# for test-file5");

        assertEquals(expected, links);
    }
}
