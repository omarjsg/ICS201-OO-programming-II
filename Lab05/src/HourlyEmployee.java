
public class HourlyEmployee extends Staff {

	private double hours;

	public HourlyEmployee(String name, String phone, double hours, double pay) {
		super(name, phone, pay);
		this.hours = hours;
	}

	public double calculatePayment() {
		return (this.payment = this.payment * this.hours);
	}

}
