package text_converter;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HtmlTextConverterTest {

    @Test
    public void replace_ampersand_gt_lt_single_and_double_quotes() {
        HtmlTextConverter converter = new HtmlTextConverter("");
        String line = "<first>&and\"double\"'single'</last>";
        String result = converter.replaceSpecialChars(line);

        String expected = "&lt;first&gt;&amp;and&quot;double&quot;&quot;single&quot;&lt;/last&gt;";
        assertThat(expected, equalTo(result));
    }
}
