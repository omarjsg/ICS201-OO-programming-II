
public class City implements Cloneable, Comparable<City> {

	private String cityName;
	private int temperature;

	public City(String cityName, int temperature) {
		this.cityName = cityName;
		this.temperature = temperature;
	}

	public City() { // unknown city 0'C is temperature in STP
		this.cityName = "Unknown";
		this.temperature = 0;
	}

	public String getCityName() {
		return cityName;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	@Override
	public int compareTo(City city) {
		if (temperature < city.temperature) {
			return -1;
		} else if (temperature > city.temperature) {
			return 1;
		} else {
			return 0;
		}
	}

	public boolean equals(Object o) {
		if (o instanceof City) {
			City city = (City) o;
			return compareTo(city) == 0;
		}
		return false;
	}

	public String toString() {
		return String.format("City: %s, Temperature = %d'C", cityName, temperature);
	}

	public Object clone() throws CloneNotSupportedException {
		City copy = (City) super.clone();
		return copy;
	}
}