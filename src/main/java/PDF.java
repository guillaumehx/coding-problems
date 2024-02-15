import com.formdev.flatlaf.FlatLightLaf;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PDF {

    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel(new FlatLightLaf());

        // Frame
        JFrame frame = new JFrame();
        frame.setTitle("Generate PDF");
        frame.setResizable(false);
        frame.setSize(400,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel and dimension
        JPanel panel = new JPanel();
        Dimension dimension = new Dimension(340, 30);

        // First TextArea
        JTextArea firstLineInput = new JTextArea();
        firstLineInput.setPreferredSize(dimension);
        firstLineInput.setLineWrap(true);
        firstLineInput.setRows(6);

        // Second TextArea
        JTextArea secondLineInput = new JTextArea();
        secondLineInput.setPreferredSize(dimension);
        secondLineInput.setLineWrap(true);
        secondLineInput.setRows(6);

        // File name
        JTextField fileNameInput = new JTextField();
        fileNameInput.setPreferredSize(dimension);

        // Submit button
        JLabel firstLineText = new JLabel("First row :");
        firstLineText.setPreferredSize(dimension);

        JLabel secondLineText = new JLabel("Second row :");
        secondLineText.setPreferredSize(dimension);

        JLabel fileNameText = new JLabel("File name :");
        fileNameText.setPreferredSize(dimension);

        JButton submitButton = new JButton("Generate PDF");
        submitButton.setPreferredSize(dimension);

        // Adding to panel
        panel.add(firstLineText);
        panel.add(firstLineInput);
        panel.add(secondLineText);
        panel.add(secondLineInput);
        panel.add(fileNameText);
        panel.add(fileNameInput);
        panel.add(submitButton);

        // Event
        submitButton.addActionListener(event -> {
            if(event != null && "Generate PDF".equals(event.getActionCommand())) {
                try {
                    String fileName = (fileNameInput.getText() == null || fileNameInput.getText().isEmpty()) ? "default" : fileNameInput.getText();
                    generatePDF(firstLineInput.getText(), secondLineInput.getText(), fileName);
                    JOptionPane.showMessageDialog(frame, "PDF successfully generated", "Generation complete", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                } catch (Exception e) {
                    System.exit(1);
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void generatePDF(String... inputs) throws IOException  {

        // Document initialization
        PDDocument pdDocument = new PDDocument();
        PDPage pdPage = new PDPage(new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth()));
        PDPageContentStream contentStream = new PDPageContentStream(pdDocument, pdPage);
        PDType1Font font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);

        float firstLineCentered = font.getStringWidth(inputs[0]) / 1000 * 14;
        float secondLineCentered = font.getStringWidth(inputs[1]) / 1000 * 14;

        contentStream.moveTo(0, 100);
        contentStream.setLineWidth(1);
        contentStream.lineTo(PDRectangle.A4.getHeight(), 100);
        contentStream.stroke();

        contentStream.setFont(font, 14);
        contentStream.setNonStrokingColor(Color.BLACK);

        contentStream.beginText();
        contentStream.newLineAtOffset((PDRectangle.A4.getHeight() - firstLineCentered) / 2, 65);
        contentStream.showText(inputs[0]);
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset((PDRectangle.A4.getHeight() - secondLineCentered) / 2, 30);
        contentStream.showText(inputs[1]);
        contentStream.endText();

        contentStream.close();

        pdDocument.addPage(pdPage);
        pdDocument.save("C:\\Users\\guill\\Desktop\\" + inputs[2] + ".pdf");
        pdDocument.close();
    }









    private void bdark_bg() throws IOException {

        PDDocument pdDocument = new PDDocument();
        PDPage pdPage = new PDPage(new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth()));
        PDPageContentStream contentStream = new PDPageContentStream(pdDocument, pdPage);

        PDType1Font font = new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN);


        contentStream.moveTo(0, 110);
        contentStream.setLineWidth(2000);
        contentStream.lineTo(PDRectangle.A4.getHeight(), 110);
        contentStream.stroke();

        contentStream.beginText();
        contentStream.newLineAtOffset(100, 100);
        contentStream.setFont(font, 20);
        contentStream.setNonStrokingColor(Color.BLUE);
        contentStream.showText("blabla");
        contentStream.endText();

        contentStream.close();

        pdDocument.addPage(pdPage);

        pdDocument.save("C:\\Users\\guill\\Desktop\\test_" + Math.random() + ".pdf");
        pdDocument.close();
    }

}
