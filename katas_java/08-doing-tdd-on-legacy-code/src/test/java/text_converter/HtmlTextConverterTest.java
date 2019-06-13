package text_converter;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class HtmlTextConverterTest {

    @Test
    public void convert_ampersand() throws IOException {
        FakeHtmlTextConverter converter = new FakeHtmlTextConverter("");

        converter.convertToHtml("");

        String result = converter.output;
        assertThat(result, equalTo("<body>&amp;<br /></body>"));
    }

    //  convert_lt
    //  convert_gt
    //  new funct

    private class FakeHtmlTextConverter extends HtmlTextConverter {
        public String output = "";
        private boolean empty;

        public FakeHtmlTextConverter(String fullFilenameWithPath) {
            super(fullFilenameWithPath);
            this.empty = false;
        }

        @Override
        protected void closeWriter(BufferedWriter writer) throws IOException {
        }

        @Override
        protected void writeLine(BufferedWriter writer, String s) throws IOException {
            output += s;
        }

        @Override
        protected String readLine(BufferedReader reader) throws IOException {
            if (this.empty) {
                return null;
            }
            this.empty = true;
            return "&";
        }

        @Override
        protected BufferedReader createReader() throws FileNotFoundException {
            return null;
        }

        @Override
        protected BufferedWriter createWriter(String htmlFile) throws IOException {
            return null;
        }
    }
}