import java.util.*;

public class Driver {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		City[] cities = { new City("Abha", 25), new City("Riyadh", 37), new City("Dhahran", 35), new City("Makkah", 41),
				new City("Jeddah", 42), new City() };
		Arrays.sort(cities);
		for (City city : cities) {
			System.out.println(city);
		}
	}

}
