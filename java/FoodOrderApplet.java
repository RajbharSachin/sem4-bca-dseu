import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
<applet code ="FoodOrderApplet.class" width="600" height="600">
</applet>
*/
public class FoodOrderApplet extends JApplet {
    private JButton orderButton;
    private JTextField itemField, quantityField;
    
    public void init() {
        setLayout(new FlowLayout());
        
        // Item label and text field
        JLabel itemLabel = new JLabel("Item:");
        itemField = new JTextField(10);
        add(itemLabel);
        add(itemField);
        
        // Quantity label and text field
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField(10);
        add(quantityLabel);
        add(quantityField);
        
        // Order button
        orderButton = new JButton("Place Order");
        add(orderButton);
        
        // Register event listener for the order button
        orderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                placeOrder();
            }
        });
    }
    
    private void placeOrder() {
        String item = itemField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        
        double totalCost = calculateTotalCost(item, quantity);
        
        // Create a confirmation message
        String confirmationMessage = "Order placed!\n"
                + "Item: " + item + "\n"
                + "Quantity: " + quantity + "\n"
                + "Total Cost: $" + totalCost;
        
        // Display confirmation message in a separate window
        JOptionPane.showMessageDialog(this, confirmationMessage, "Order Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private double calculateTotalCost(String item, int quantity) {
        // Calculate total cost based on the item and quantity
        // This is just a placeholder method, you can implement your own logic here
        // For simplicity, we assume each item costs $10
        double itemCost = 10.0;
        return itemCost * quantity;
    }
}