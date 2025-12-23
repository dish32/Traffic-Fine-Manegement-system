class FineLinkedList {
    FineNode head;

    // Add fine
    public void addFine(int id, String name, String vehicle, String violation, double amount) {
        FineNode newNode = new FineNode(id, name, vehicle, violation, amount);

        if (head == null) {
            head = newNode;
        } else {
            FineNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("✅ Traffic fine added successfully.");
    }

    // Display all fines
    public void displayFines() {
        if (head == null) {
            System.out.println("No fine records found.");
            return;
        }

        FineNode temp = head;
        while (temp != null) {
            System.out.println("----------------------------------");
            System.out.println("Fine ID: " + temp.fineId);
            System.out.println("Driver: " + temp.driverName);
            System.out.println("Vehicle: " + temp.vehicleNumber);
            System.out.println("Violation: " + temp.violationType);
            System.out.println("Amount: Rs." + temp.fineAmount);
            System.out.println("Status: " + temp.status);
            temp = temp.next;
        }
    }

    // Search fine by vehicle number
    public void searchByVehicle(String vehicle) {
        FineNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.vehicleNumber.equalsIgnoreCase(vehicle)) {
                System.out.println("Fine Found!");
                System.out.println("Driver: " + temp.driverName);
                System.out.println("Violation: " + temp.violationType);
                System.out.println("Amount: Rs." + temp.fineAmount);
                System.out.println("Status: " + temp.status);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No fine found for this vehicle.");
        }
    }

    // Pay fine
    public void payFine(int id) {
        FineNode temp = head;

        while (temp != null) {
            if (temp.fineId == id) {
                temp.status = "Paid";
                System.out.println("💰 Fine paid successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Fine ID not found.");
    }

    // Delete paid fine
    public void deletePaidFine(int id) {
        if (head == null) return;

        if (head.fineId == id && head.status.equals("Paid")) {
            head = head.next;
            System.out.println("🗑️ Paid fine removed.");
            return;
        }

        FineNode temp = head;
        while (temp.next != null) {
            if (temp.next.fineId == id && temp.next.status.equals("Paid")) {
                temp.next = temp.next.next;
                System.out.println("🗑️ Paid fine removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Fine not found or not paid yet.");
    }
}
