package text_converter;

import java.io.*;

public class HtmlTextConverter
{
    private String fileName;

    public HtmlTextConverter(String fullFilenameWithPath)
    {
        this.fileName = fullFilenameWithPath;
    }

    public void convertToHtml(String htmlFile) throws IOException{
		BufferedWriter writer = createWriter(htmlFile);
	    BufferedReader reader = createReader();
	    
	    String line = readLine(reader);
		writeLine(writer, "<body>");
		while (line != null)
	    {
			String output = line;
			output = output.replace("&", "&amp;");
			output = output.replace("<", "&lt;");
			output = output.replace(">", "&gt;");
			writeLine(writer, output);
			writeLine(writer, "<br />");
			line = readLine(reader);
	    }
		writeLine(writer, "</body>");
		closeWriter(writer);
	}

	protected void closeWriter(BufferedWriter writer) throws IOException {
		writer.close();
	}

	protected void writeLine(BufferedWriter writer, String s) throws IOException {
		writer.write(s);
	}

	protected String readLine(BufferedReader reader) throws IOException {
		return reader.readLine();
	}

	protected BufferedReader createReader() throws FileNotFoundException {
		return new BufferedReader(new FileReader(fileName));
	}

	protected BufferedWriter createWriter(String htmlFile) throws IOException {
		return new BufferedWriter(new FileWriter(htmlFile));
	}

	public String getFilename() {
		return this.fileName;
	}

	public static void main(String[] args) {
		try {
			HtmlTextConverter htmlTextConverter = new HtmlTextConverter("res/example.txt");
			htmlTextConverter.convertToHtml("res/example.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
