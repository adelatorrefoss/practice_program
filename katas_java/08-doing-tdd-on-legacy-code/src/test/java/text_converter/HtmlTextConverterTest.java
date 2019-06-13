package text_converter;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HtmlTextConverterTest {

    @Test
    public void replace_ampersand_gt_and_lt() {
        HtmlTextConverter converter = new HtmlTextConverter("");
        String line = "<first>&and</last>";
        String result = converter.replaceSpecialChars(line);

        String expected = "&lt;first&gt;&amp;and&lt;/last&gt;";
        assertThat(expected, equalTo(result));
    }
}
