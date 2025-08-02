import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverterGUI {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Currency Converter (INR to Foreign)");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 1, 10, 10));
        frame.getContentPane().setBackground(new Color(245, 245, 245)); // light gray background

        // UI Components
        JLabel label = new JLabel("Enter amount in INR:", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(new Color(33, 37, 41)); // dark gray text

        JTextField amountField = new JTextField();
        amountField.setBackground(new Color(255, 255, 255));
        amountField.setForeground(Color.BLACK);
        amountField.setFont(new Font("Arial", Font.PLAIN, 14));

        String[] currencies = {"USD", "EUR", "JPY", "GBP"};
        JComboBox<String> currencyBox = new JComboBox<>(currencies);
        currencyBox.setBackground(new Color(220, 220, 220));
        currencyBox.setFont(new Font("Arial", Font.PLAIN, 13));

        JButton convertButton = new JButton("Convert");
        convertButton.setBackground(new Color(72, 133, 237)); // blue button
        convertButton.setForeground(Color.WHITE);
        convertButton.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel resultLabel = new JLabel("Converted amount will appear here", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        resultLabel.setForeground(new Color(60, 60, 60)); // dark text

        // Add components to the frame
        frame.add(label);
        frame.add(amountField);
        frame.add(new JLabel("Select Currency:", SwingConstants.CENTER));
        frame.add(currencyBox);
        frame.add(convertButton);
        frame.add(resultLabel);

        // Conversion rates
        double inrToUsd = 0.012;
        double inrToEur = 0.011;
        double inrToJpy = 1.81;
        double inrToGbp = 0.0093;

        // Action on button click
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double inrAmount = Double.parseDouble(amountField.getText());
                    String selectedCurrency = (String) currencyBox.getSelectedItem();
                    double result = 0;

                    switch (selectedCurrency) {
                        case "USD":
                            result = inrAmount * inrToUsd;
                            break;
                        case "EUR":
                            result = inrAmount * inrToEur;
                            break;
                        case "JPY":
                            result = inrAmount * inrToJpy;
                            break;
                        case "GBP":
                            result = inrAmount * inrToGbp;
                            break;
                    }

                    resultLabel.setText(String.format("%.2f INR = %.2f %s", inrAmount, result, selectedCurrency));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number.");
                }
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }

}
