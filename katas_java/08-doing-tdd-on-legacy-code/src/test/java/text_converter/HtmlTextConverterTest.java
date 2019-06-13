package text_converter;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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

    @Test
    public void replace_ampersand_gt_lt_single_and_double_quotes() throws IOException {
        HtmlTextConverterTestDouble converter = new HtmlTextConverterTestDouble("");
        converter.setInput("<first>&and\"double\"'single'</last>");

        converter.convertToHtml("");

        String expected = "<body>&lt;first&gt;&amp;and&quot;double&quot;&quot;single&quot;&lt;/last&gt;<br /></body>";
        MatcherAssert.assertThat(converter.output, equalTo(expected));
    }


    //  convert_lt
    //  convert_gt
    //  new funct

    private class HtmlTextConverterTestDouble extends HtmlTextConverter {
        String output = "";
        private boolean empty = false;
        private String input = "";

        HtmlTextConverterTestDouble(String fullFilenameWithPath) {
            super(fullFilenameWithPath);
        }

        void setInput(String input) {
            this.input = input;
        }

        @Override
        protected void closeWriter(BufferedWriter writer) {
        }

        @Override
        protected void writeLine(BufferedWriter writer, String s) {
            output += s;
        }

        @Override
        protected String readLine(BufferedReader reader) {
            if (this.empty) {
                return null;
            }
            this.empty = true;
            return this.input;
        }

        @Override
        protected BufferedReader createReader() {
            return null;
        }

        @Override
        protected BufferedWriter createWriter(String htmlFile) {
            return null;
        }
    }
}
