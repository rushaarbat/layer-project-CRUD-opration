package layer4;
import java.util.List;

import layer2.Department;
import layer3.DepartmentDAOImpl;
import layer4.exceptions.DepartmentExistsException;
import layer4.exceptions.DepartmentNotFoundException;
public class DepartmentServiceImpl implements DepartmentService {
	DepartmentDAOImpl deptDao = new DepartmentDAOImpl();
	
	public DepartmentServiceImpl() {
		pst.setString(1, dobj.getDepartmentName());
		pst.setString(2, dobj.getDepartmentlocation());System.out.println("DepartmentServiceImpl : DepartmentServiceImpl() constructor....");
	}
	@Override
	public void createDepartmentService(Department dobj) throws DepartmentExistsException
	{ //37 QA ND
			Department dummyDept = deptDao.selectDepartment(dobj.getDepartmentNumber());
			if(dummyDept != null ) {
				DepartmentExistsException dee = new DepartmentExistsException("This department number already exists "+dobj.getDepartmentNumber());
				throw dee;
			}
			else {
				System.out.println("=>createDepartmentService() started");
				deptDao.insertDepartment(dobj);
				System.out.println("DepartmentServiceImpl :  createDepartmentService() invoked....");
				System.out.println("=>createDepartmentService() finished");
			}
	  
	}
	
	public List<Department> findAllDeptsService()
	{
		return deptDao.selectDepartments();
	}
	
	public Department findDeptService(int dno) throws DepartmentNotFoundException
	{
		Department dept = deptDao.selectDepartment(dno);
		if(dept == null) {
			throw new DepartmentNotFoundException("Department Not found : "+dno);
		}
		return dept;
	}
}
/*
import java.util.List;

import layer2.Department;
import layer3.DepartmentDAOImpl1;

public class DepartmentServiceImpl implements DepartmentService {
	
	DepartmentDAOImpl1 deptDao = new DepartmentDAOImpl1();
	public void createDepartmentService(Department dobj) {
		System.out.println("=> creatDepartmentService  : start");
		deptDao.insertDepartment(dobj);
		System.out.println("DepartmentServiceImpl : createDepartmentService");
		System.out.println("=> creatDepartmentService  : end");
		
	}
	
	public List<Department> findAllDeptsService();
	{
		return deptDao.selectDepartment();
	}

}*/
