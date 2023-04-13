package com.example.jpql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
class JpqlApplicationTests {

	@Autowired
	EmpRepo empRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void createUser() {
		Employee emp1 = new Employee();
		emp1.setFirstName("Khushwant");
		emp1.setLastName("Prajapati");
		emp1.setSalary(15000);
		emp1.setAge(23);

		Employee emp2 = new Employee();
		emp2.setFirstName("Mukul");
		emp2.setLastName("Tanwar");
		emp2.setSalary(10000);
		emp2.setAge(22);

		empRepo.save(emp1);
		empRepo.save(emp2);
	}

	@Test
	void findAllEmployee() {

		System.out.printf(empRepo.findAllEmployee().toString());
	}

	@Test
	void findAllEmployeePartial() {
		List<Object[]> list = empRepo.findAllEmployeePartial();
		for (Object[] objects : list) {
			System.out.printf(objects[0].toString());
			System.out.printf(objects[1].toString());
		}
	}

	@Test
	public void findEmpWithSalaryGreaterThanAverage() {
		List<Object[]> list = empRepo.findEmployeesWithSalaryGreaterThanAverage();
		for (Object[] objects : list) {
			System.out.printf(objects[0].toString() +" ");
			System.out.println(objects[1].toString());
		}
	}

	@Test
	public void updateSalaryLessThanAverage(){
		empRepo.updateSalaryLessThanAvg(35000, empRepo.avg());
	}


	@Test
	void deleteEmployeesWithMinimumSal(){
		empRepo.deleteEmployeesWithMinimumSalary(empRepo.min());
	}

	// >>>>>>>>>>>>>>>>>>>>>>> NATIVE

	@Test
	void findAllEmployeeNative(){
		System.out.printf(empRepo.findAllEmployeeNative().toString());
	}

	@Test
	void findEmployeesWithSinghLastName(){
		List<Object[]> list = empRepo.findEmployeesWithSinghLastName();
		for (Object[] objects : list) {
			System.out.printf(objects[0].toString() +" ");
			System.out.printf(objects[1].toString() +" ");
			System.out.println(objects[2].toString());
		}
	}

	@Test
	@Rollback(value = false)
	void deleteEmployeesByAge(){
		empRepo.deleteEmployeesByAge(39);
	}
}
