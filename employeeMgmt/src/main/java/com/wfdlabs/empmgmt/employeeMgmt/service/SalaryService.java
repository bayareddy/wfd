package com.wfdlabs.empmgmt.employeeMgmt.service;
import java.util.List;
import com.wfdlabs.empmgmt.employeeMgmt.entity.Salary;

public interface SalaryService {

	public Salary createSalary(Salary salary);

	public Salary getSalary(Integer id);

	public List<Salary> getAllSalary();

	public String deleteSalary(Integer id);

	public Salary updateSalary(Salary salary);

}
