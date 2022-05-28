public class Staff {
	String name;
	String phone;
	double payment;

	public Staff(String name, String phone, double pay) {
		this.name = name;
		this.phone = phone;
		this.payment = pay;
	}

	public String toString() {
		return String.format("Staff Type: %s%nName: %s%nPhone: %s%nPay: %.1f SAR", this.getClass().getName(), name,
				phone, payment);
	}

	public double getPayent() {
		return this.payment;
	}
}
