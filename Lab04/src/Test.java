public class Test {
	public static void main(String[] args) {
		Person person = new Person("Adel","B831-233","+966583648392",
				"Adel938@gmail.com");
		Student sudent= new Student("Baraa","B852-123","+966505763486",
				"Killer85@gmail.com","Freshman");
		Employee employee = new Employee("Othman", "Ryiadh - Yasmeen13325",
				"+966558773325","Othman123@gmail.com", "Fanar-B5-243",
				"25,000 SAR", generateDate());
		Faculty faculty = new Faculty("Tariq", "KFUPM - Alzuhra 3119",
				"+966558871143","talqarni@kfupm.edu.sa", "B22- 256", 
				"20,000 SAR", generateDate(), "UTR 10:00 - 10:50", "Assossiate Professor");
		Staff staff = new Staff ("Faisal", "KFUPM - Nuzhah 4564",
				"+966567384658", "falothaim@kfupm.edu.sa", "B14 - 222", "17,000",generateDate() , "Mr.");
		Student sudent1= new Student("freshman");
		System.out.println(person);
		System.out.println(sudent);
		System.out.println(employee);
		System.out.println(faculty);
		System.out.println(staff);
	}
	public static String generateDate()
	{
		int day = (int)(Math.random()*30)+1;
		int month = (int)(Math.random()*12)+1;
		int year = (int)(Math.random()*40)+1985;
		return String.format("%d/ %d/ %d",day, month, year);
	}
	
}
//-----------------------------------------------------------------------------------------------
class Person 
{
	private String name;
	private String address;
	private String PhoneNumber;
	private String email;
	public Person (String name, String address, String PhoneNumber, String email)
	{
		this.name = name;
		this.address = address;
		this.PhoneNumber = PhoneNumber;
		this.email = email;
	}
	public Person() {
		this.name = null;
		this.address = null;
		this.PhoneNumber = null;
		this.email = null;
	}
	public String getName()
	{
		return this.name;
	}
	public String getAddress()
	{
		return this.address;
	}
	public String getPhoneNumber()
	{
		return this.PhoneNumber;
	}
	public String getEmail()
	{
		return this.email;
	}
	public String toString()
	{
		return String.format("Class: %s.%nName:%s.",this.getClass().getName(), getName());
	}
}
//-----------------------------------------------------------------------------------------------
class Student extends Person
{
	private String status;
	public Student(String name, String address, String PhoneNumber, String email, String status) 
	{
		super(name, address, PhoneNumber, email);
		if(checkStatus(status))
		{
			this.status = status;
		}
	}
	public Student(String status)
	{
		//super();
		this.status = status;
	}
	private boolean checkStatus(String status1)
	{
		boolean Studentstatus = false;
		String[] status = {"freshman", "sophomore", "junior", "senior"};
		for (int i = 0; i<status.length; i++)
		{
			if (status1.equalsIgnoreCase(status[i]))
			{
				Studentstatus = true;
				break;
			}
		}
		return Studentstatus;
	}
	public String getStatus()
	{
		return this.status;
	}
	public String toString()
	{
		return String.format("Class: Student.%nName:%s.", getName());
	}
}
//-----------------------------------------------------------------------------------------------
class Employee extends Person
{
	private String office;
	private String salary;
	private String dateHired;
	public Employee(String name, String address, String PhoneNumber, String email, String office, String salary,
			String dateHired) 
	{
		super(name, address, PhoneNumber, email);
		this.office = office;
		this.salary = salary;
		this.dateHired = dateHired;
	}
	public String getOffice()
	{
		return this.office;
	}
	public String getDateHired()
	{
		return this.dateHired;
	}
	public String getSalary()
	{
		return this.salary;
	}
	public String toString()
	{
		return String.format("Class: Employee.%nName:%s.", getName());
	}
}
//-----------------------------------------------------------------------------------------------
class Faculty extends Employee
{
	private String rank;
	private String officeHours;
	public Faculty(String name, String address, String PhoneNumber, String email, String office, String salary,
			String dateHired, String rank, String officeHours) {
		super(name, address, PhoneNumber, email, office, salary, dateHired);
		this.officeHours = officeHours;
		this.rank = rank;
	}
	public String getSalary()
	{
		return this.rank;
	}
	public String getOfficeHours()
	{
		return this.officeHours;
	}
	public String toString()
	{
		return String.format("Class: Faculty.%nName:%s.", getName());
	}
}
//-----------------------------------------------------------------------------------------------
class Staff extends Employee
{
	private String title;
	public Staff(String name, String address, String PhoneNumber, String email, String office, String salary,
			String dateHired, String title) {
		super(name, address, PhoneNumber, email, office, salary, dateHired);
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}
	public String toString()
	{
		return String.format("Class: Staff.%nName:%s.", getName());
	}
}