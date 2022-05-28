import java.util.Date;

public abstract class GeometricObject implements Cloneable{
	private String color = "white";
	private boolean filled;
	private Date dateCreated;

	// Construct a default geometric object
	protected GeometricObject() {
		dateCreated = new Date();
	}

	// Construct a geometric object with color and filled value */
	protected GeometricObject(String color, boolean filled) {
		dateCreated = new Date();
		this.color = color;
		this.filled = filled;
	}

	// Return color
	public String getColor() {
		return color;
	}

	// Set a new color
	public void setColor(String color) {
		this.color = color;
	}

	// Return filled. Since filled is boolean, the get method is named isFilled

	public boolean isFilled() {
		return filled;
	}

	// Set a new filled
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	// Get dateCreated
	public Date getDateCreated() {
		return dateCreated;
	}

	@Override
	public String toString() {
		return String.format("The %s Area = %.2f, Perimeter = %.2f, color = %s and filled = %b.", this.getClass().getName(), getArea(),
				getPerimeter(), color, filled);
	}

	@Override
	// to deep copy GeometricObject object.
	public Object clone() throws CloneNotSupportedException {
		GeometricObject copy = (GeometricObject) super.clone();
		copy.dateCreated = (Date) dateCreated.clone();
		return copy;
	}

	// Abstract method getArea
	public abstract double getArea();

	// Abstract method getPerimeter
	public abstract double getPerimeter();
}