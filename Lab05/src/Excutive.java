
public class Excutive extends Staff {

	public Excutive(String name, String phone, double pay) {
		super(name, phone, pay);
	}

	public double addPayment() {
		return this.payment += 5000;
	}
}
