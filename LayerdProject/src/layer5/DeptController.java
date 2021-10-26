package layer5;
import java.util.List;

import layer2.Department;
import layer4.DepartmentServiceImpl;
import layer4.exceptions.DepartmentExistsException;
import layer4.exceptions.DepartmentNotFoundException;

public class DeptController {

	public static void main(String[] args) {

		DepartmentServiceImpl deptService = new DepartmentServiceImpl();
		
		  Department deptObj = new Department(); 
		  deptObj.setDepartmentNumber(66);
		  deptObj.setDepartmentName("Snack"); 
		  deptObj.setDepartmentlocation("DC"); 
		  try {
			deptService.createDepartmentService(deptObj);
		} catch (DepartmentExistsException e) {
			
			System.out.println("Problem : "+e.getMessage());
		}
		 

		/*List<Department> deptList = deptService.findAllDeptsService();
		for (Department theDept : deptList) {
			System.out.println("Dept NO   : " + theDept.getDepartmentNumber());
			System.out.println("Dept NAME : " + theDept.getDepartmentName());
			System.out.println("Dept LOC  : " + theDept.getDepartmentLocation());
			System.out.println("---------");
		}*/
		
		/*Department theDept;
		try {
			theDept = deptService.findDeptService(137);
			System.out.println("Dept NO   : " + theDept.getDepartmentNumber());
			System.out.println("Dept NAME : " + theDept.getDepartmentName());
			System.out.println("Dept LOC  : " + theDept.getDepartmentLocation());
			System.out.println("---------");
		} catch (DepartmentNotFoundException e) {
			System.out.println("Problem : "+e.getMessage());
		}*/
		
	}
}
/*
import java.util.List;

import layer2.Department;
import layer4.DepartmentServiceImpl;

public class DeptController {

	public static void main(String[] args) {
		
		DepartmentServiceImpl deptService = new DepartmentServiceImpl();
		/*Department deptObj = new Department(); //this can be from html
		deptObj.setDepartmentNumber(55);
		deptObj.setDepartmentName("food");
		deptObj.setDepartmentlocation("hotel");
		
		deptService.createDepartmentService(deptObj);*/
		List<Department> deptList = deptService.findAllDeptsService();
		for(Department theDept : deptList){
				System.out.println("Dept NO  : "+ theDept.getDepartmentNumber());
				System.out.println("Dept name  : "+ theDept.getDepartmentName());
				System.out.println("Dept Location : "+ theDept.getDepartmentlocation());
		}
		
	}
}
/*