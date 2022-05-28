public class City implements Comparable<City> {
    private String name;
    private double longitude, latitude;

    public City(String name) {
        this(name, 0, 0);
    }

    public City(String name, double longitude, double latitude) {
        setName(name);
        setLongitude(longitude);
        setLatitude(latitude);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof City) {
            City city = (City) o;
            return compareTo(city) == 0;
        }
        return false;
    }

    @Override
    public int compareTo(City city) {
        return name.compareToIgnoreCase(city.name);
    }
}
