package layer3;

import java.util.List;

import layer2.Department;

public interface DepartmentDAO {
	
	void insertDepartment(Department dobj);//C
	
	Department selectDepartment(int dno);//R
	List<Department> selectDepartment();//RU
	
	void updateDepartment(Department dobj);//U
	void deletDepartment(int dno);//d

}
