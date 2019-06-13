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
        HtmlTextConverterTestDouble converter = new HtmlTextConverterTestDouble("");
        converter.setInput("&");

        converter.convertToHtml("");

        String result = converter.output;
        assertThat(result, equalTo("<body>&amp;<br /></body>"));
    }

    @Test
    public void convert_single_quote() throws IOException {
        HtmlTextConverterTestDouble converter = new HtmlTextConverterTestDouble("");
        converter.setInput("'");

        converter.convertToHtml("");

        String result = converter.output;
        assertThat(result, equalTo("<body>&quot;<br /></body>"));
    }

    @Test
    public void convert_double_quote() throws IOException {
        HtmlTextConverterTestDouble converter = new HtmlTextConverterTestDouble("");
        converter.setInput("\"");

        converter.convertToHtml("");

        String result = converter.output;
        assertThat(result, equalTo("<body>&quot;<br /></body>"));
    }

    //  convert_lt
    //  convert_gt
    //  new funct

    private class HtmlTextConverterTestDouble extends HtmlTextConverter {
        public String output = "";
        private boolean empty = false;
        private String input = "";

        public HtmlTextConverterTestDouble(String fullFilenameWithPath) {
            super(fullFilenameWithPath);
        }

        public void setInput(String input) {
            this.input = input;
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
            return this.input;
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