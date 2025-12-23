class FineNode {
    int fineId;
    String driverName;
    String vehicleNumber;
    String violationType;
    double fineAmount;
    String status; // Paid / Unpaid
    FineNode next;

    public FineNode(int fineId, String driverName, String vehicleNumber,
                    String violationType, double fineAmount) {
        this.fineId = fineId;
        this.driverName = driverName;
        this.vehicleNumber = vehicleNumber;
        this.violationType = violationType;
        this.fineAmount = fineAmount;
        this.status = "Unpaid";
        this.next = null;
    }
}
