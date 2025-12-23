import javax.swing.*;
import java.awt.*;

public class TrafficFineUI extends JFrame {

    FineLinkedList list = new FineLinkedList();

    JTextField txtId, txtName, txtVehicle, txtViolation, txtAmount;
    JTextArea displayArea;

    public TrafficFineUI() {
        setTitle("Traffic Fine Management System");
        setSize(750, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //  MAIN PANEL 
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(245, 250, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        add(mainPanel);

        // TITLE
        JLabel title = new JLabel("Traffic Fine Management System", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(new Color(30, 30, 30));
        mainPanel.add(title, BorderLayout.NORTH);

        //  FORM PANEL 
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 12, 12));
        formPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Fine Details"
        ));
        formPanel.setBackground(Color.WHITE);

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 14);

        txtId = new JTextField();
        txtName = new JTextField();
        txtVehicle = new JTextField();
        txtViolation = new JTextField();
        txtAmount = new JTextField();

        formPanel.add(createLabel("Fine ID:", labelFont));
        formPanel.add(txtId);
        formPanel.add(createLabel("Driver Name:", labelFont));
        formPanel.add(txtName);
        formPanel.add(createLabel("Vehicle Number:", labelFont));
        formPanel.add(txtVehicle);
        formPanel.add(createLabel("Violation Type:", labelFont));
        formPanel.add(txtViolation);
        formPanel.add(createLabel("Fine Amount (Rs):", labelFont));
        formPanel.add(txtAmount);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        // ================= BUTTON PANEL =================
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(new Color(245, 250, 255));

        JButton btnAdd = new JButton("➕ Add Fine");
        JButton btnPay = new JButton("💰 Pay Fine");
        JButton btnDelete = new JButton("🗑 Delete Paid Fine");
        JButton btnSearch = new JButton("🔍 Search by Vehicle");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnPay);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnSearch);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        //  DISPLAY AREA 
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        displayArea.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Fine Records"));

        mainPanel.add(scrollPane, BorderLayout.EAST);
        scrollPane.setPreferredSize(new Dimension(300, 0));

        //  BUTTON ACTIONS 

        btnAdd.addActionListener(e -> {
            int id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();
            String vehicle = txtVehicle.getText();
            String violation = txtViolation.getText();
            double amount = Double.parseDouble(txtAmount.getText());

            list.addFine(id, name, vehicle, violation, amount);
            JOptionPane.showMessageDialog(this, "Fine added successfully!");
            clearFields();
        });

        btnPay.addActionListener(e -> {
            int id = Integer.parseInt(txtId.getText());
            list.payFine(id);
            JOptionPane.showMessageDialog(this, "Fine paid successfully!");
        });

        btnDelete.addActionListener(e -> {
            int id = Integer.parseInt(txtId.getText());
            list.deletePaidFine(id);
            JOptionPane.showMessageDialog(this, "Paid fine deleted!");
        });

        btnSearch.addActionListener(e -> {
            displayArea.setText("");
            FineNode temp = list.head;
            String vehicle = txtVehicle.getText();

            while (temp != null) {
                if (temp.vehicleNumber.equalsIgnoreCase(vehicle)) {
                    displayArea.append(
                            "Fine ID : " + temp.fineId +
                            "\nDriver : " + temp.driverName +
                            "\nVehicle : " + temp.vehicleNumber +
                            "\nViolation : " + temp.violationType +
                            "\nAmount : Rs. " + temp.fineAmount +
                            "\nStatus : " + temp.status +
                            "\n-----------------------------\n"
                    );
                }
                temp = temp.next;
            }
        });
    }

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtVehicle.setText("");
        txtViolation.setText("");
        txtAmount.setText("");
    }

    public static void main(String[] args) {
        new TrafficFineUI().setVisible(true);
    }
}
