package text_converter;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HtmlTextConverterTest {

    @Test
    public void replace_ampersand_in_line_with_one_character() {
        HtmlTextConverter converter = new HtmlTextConverter("");
        String line = "&";
        String result = converter.replaceSpecialChars(line);

        String expected = "&amp;";
        assertThat(expected, equalTo(result));
    }

}