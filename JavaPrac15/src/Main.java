import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        IDocument doc = new IDocument() {
            @Override
            public JFrame document() {
                IDocument.super.document();
                return null;
            }
        };
        doc.document();
    }
}