package org.hbrs.se1.ws24.exercises.uebung9;

public class TextDocument extends CoreDocument{
    private String content;
    private Encoding encoding;

    public TextDocument(String text, Encoding encoding) {
        this.content = text;
        this.encoding = encoding;
    }

    public int getSize() {
        return content.getBytes().length;
    }
}
