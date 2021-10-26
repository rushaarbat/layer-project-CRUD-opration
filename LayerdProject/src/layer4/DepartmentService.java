package layer4;

import java.util.List;

import layer2.Department;
import layer4.exceptions.DepartmentExistsException;
import layer4.exceptions.DepartmentNotFoundException;
public interface DepartmentService {
	
	void createDepartmentService(Department dobj) throws DepartmentExistsException; //C
	List<Department> findAllDeptsService(); //RA
	
	Department findDeptService(int dno) throws DepartmentNotFoundException;
	
	
}
/*
import java.util.List;

import layer2.Department;

public interface DepartmentService {

	void createDepartmentService(Department dobj);
	 List<Department> findAllDeptsService();
}
*/