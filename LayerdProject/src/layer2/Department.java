package layer2;

public class Department {

	private int departmentNumber;
	private String departmentName;
	private String departmentlocation;
	
	public Department() {
		System.out.println("Department : Department");
	}

	public int getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentlocation() {
		return departmentlocation;
	}

	public void setDepartmentlocation(String departmentlocation) {
		this.departmentlocation = departmentlocation;
	}
	
}
