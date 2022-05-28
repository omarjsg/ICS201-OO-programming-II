
public class StaffTest {
	public static void main(String[] args) {
		Staff[] staffList = new Staff[4];
		staffList[0] = new Excutive("Ahmad", "860-1490", 5000);
		staffList[1] = new MonthlyEmployee("Ali", "0555-0101", 850);
		staffList[2] = new HourlyEmployee("Othman", "0555-0690", 40, 20.5);
		staffList[3] = new Volunteer("Bandar", "849-8374");
		double total = 0;
		for (int i = 0; i < staffList.length; i++) {
			modify(staffList[i]);
			total += staffList[i].getPayent();
			System.out.println(staffList[i] + "\n");
		}
		System.out.printf("Total Pay = %.1f SAR", total);
	}

	public static void modify(Staff staffList) {
		if (staffList instanceof Excutive) {
			Excutive newPayment = (Excutive) staffList;
			newPayment.addPayment();
		} else if (staffList instanceof HourlyEmployee) {
			HourlyEmployee newPayment = (HourlyEmployee) staffList;
			newPayment.calculatePayment();
		}

	}
}
