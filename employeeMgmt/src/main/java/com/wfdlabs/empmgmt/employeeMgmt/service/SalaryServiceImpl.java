package com.wfdlabs.empmgmt.employeeMgmt.service;
import java.util.List;
import com.wfdlabs.empmgmt.employeeMgmt.entity.Salary;
import com.wfdlabs.empmgmt.employeeMgmt.repository.SalaryRepository;
import com.wfdlabs.empmgmt.employeeMgmt.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl implements SalaryService {

 
 @Autowired
 SalaryRepository salaryRepository;
 
 @Override
 public Salary createSalary(Salary salary) {
  System.out.println("Save salary record");
  return salaryRepository.save(salary);
 }
 
 @Override
 public Salary getSalary(Integer id) {
  return salaryRepository.findById(id).get();
 }
    
 @Override
 public List<Salary> getAllSalary(){
  return salaryRepository.findAll();
 }
    
 @Override
 public String deleteSalary(Integer id) {
   salaryRepository.deleteById(id);
   return "record1 deleted successfully";
  
 }

 @Override
 public Salary updateSalary(Salary salary) {
  return salaryRepository.save(salary);
 }
}
 
