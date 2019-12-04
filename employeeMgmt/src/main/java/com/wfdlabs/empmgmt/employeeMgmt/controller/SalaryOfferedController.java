package com.wfdlabs.empmgmt.employeeMgmt.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.InputStream;
import com.wfdlabs.empmgmt.employeeMgmt.entity.Employee;
import com.wfdlabs.empmgmt.employeeMgmt.entity.SalaryOffered;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfdlabs.empmgmt.employeeMgmt.service.EmployeeService;
import com.wfdlabs.empmgmt.employeeMgmt.service.SalaryOfferedService;

@RestController
@RequestMapping("/SalaryOffered")
public class SalaryOfferedController {
	
			
	@Autowired
	SalaryOfferedService salaryOfferedService;
	
	@Autowired
	EmployeeService employeeService;
	
	
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.POST)
	public SalaryOffered createSalaryOffered(@RequestBody SalaryOffered salaryOffered) {
		return salaryOfferedService.createSalaryOffered(salaryOffered);
	}
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.PUT)
	public SalaryOffered UpdateSalaryOffered(@RequestBody SalaryOffered salaryOffered) {
		return salaryOfferedService.updateSalaryOffered(salaryOffered);
	}
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.GET)
	public SalaryOffered getSalaryOffered(@RequestParam Integer employeeId) {
		System.out.println("SalaryOffered:" + employeeId);
		return salaryOfferedService.getSalaryOffered(employeeId);
	}
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public List<SalaryOffered> getAllSalaryOffered() {
		return salaryOfferedService.getAllSalaryOffered();
	}
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteSalaryOffered(@RequestParam Integer employeeId) {
		System.out.println("employeeId:" + employeeId);
		salaryOfferedService.deleteSalaryOffered(employeeId);
		return "delete record successfully";
	}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/generateEmpPdf", method = RequestMethod.GET)
	public ResponseEntity<String> pdfMethod(@RequestParam String month,@RequestParam Integer year, @RequestParam Integer salaryOfferedId) throws IOException {
			
		
		SalaryOffered salaryOffered=salaryOfferedService.getSalaryOffered(salaryOfferedId);
	//	Employee emp=employeeService.getEmployee(employeId);
			 	 Document document = new Document();

		      try
		      {
		         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("E:\\Payslip.pdf"));
		         document.open();
		         
		         
		         Paragraph para = new Paragraph();
//		         Font fontHeader = new Font(Font.ITALIC);
//		         Font font1 = new Font(Font.BOLD);
		         
		         // read the properties file
		         Properties p = new Properties();
		        java.io.InputStream is=new FileInputStream("C:\\Users\\DELL\\Desktop\\New Project\\wfd\\employeeMgmt\\src\\main\\resources\\application.properties");
		        	 p.load(is);
		        	 String companyName = p.getProperty("company.name");  
		        	 String address = p.getProperty("address");
		        	  
		        
		         para = new Paragraph(companyName);
		         para.setAlignment(Element.ALIGN_CENTER);
		         document.add(para);
		        
		         para = new Paragraph(address + " " + month  + "/" + year.toString());
		         para.setAlignment(Element.ALIGN_CENTER);
		         document.add(para);
		         
//		         para = new Paragraph(employeId);
//		         para.setAlignment(Element.ALIGN_LEFT);
	
		         PdfPTable table = new PdfPTable(4); // 3 columns.
//		         PdfPTable table1 = new PdfPTable(4); // 3 columns.
//		         PdfPTable table2 = new PdfPTable(4);
//		         PdfPTable table3 = new PdfPTable(4);
//		         PdfPTable table4 = new PdfPTable(4);
//		         PdfPTable table5 = new PdfPTable(4);
//		         PdfPTable table6 = new PdfPTable(2);
//		         PdfPTable table7 = new PdfPTable(4);
//		         PdfPTable table8 = new PdfPTable(4);


		        PdfPCell cell_a = new PdfPCell(new Paragraph("Earnings:"));
		        PdfPCell cell_b = new PdfPCell(new Paragraph("Total"));
	            PdfPCell cell_c= new PdfPCell(new Paragraph("Deduction"));
	            PdfPCell cell_d = new PdfPCell(new Paragraph("Total"));
	            
	            table.addCell(cell_a);
	            table.addCell(cell_b);
	            table.addCell(cell_c);
	            table.addCell(cell_d);
	            

		        PdfPCell cell1_a = new PdfPCell(new Paragraph("Basic salary"));
		        PdfPCell cell1_b= new PdfPCell(new Paragraph(" "+salaryOffered.getBasic()));
		        PdfPCell cell1_c = new PdfPCell(new Paragraph("CompanyContributionToPf"));
		        PdfPCell cell1_d= new PdfPCell(new Paragraph(" "+salaryOffered.getCompanyContributionToPf()));
		        
		        table.addCell(cell1_a);
		        table.addCell(cell1_b);
		        table.addCell(cell1_c);
		        table.addCell(cell1_d);

		        
		        PdfPCell cell2_a = new PdfPCell(new Paragraph("ConveyanceAllowance"));
		        PdfPCell cell2_b= new PdfPCell(new Paragraph(" "+salaryOffered.getConveyanceAllowance()));
		        PdfPCell cell2_c = new PdfPCell(new Paragraph("HouseRentAllowance"));
		        PdfPCell cell2_d= new PdfPCell(new Paragraph(" "+salaryOffered.getHouseRentAllowance()));
		        
		        table.addCell(cell2_a);
		        table.addCell(cell2_b);
		        table.addCell(cell2_c);
		        table.addCell(cell2_d);
		        
		        PdfPCell cell3_a = new PdfPCell(new Paragraph("Medical Allowance"));
		        PdfPCell cell3_b= new PdfPCell(new Paragraph(" "+salaryOffered.getMedicalAllowance()));
		       PdfPCell cell3_c = new PdfPCell(new Paragraph("PayOnMonthOryear"));
		        PdfPCell cell3_d= new PdfPCell(new Paragraph(" "+salaryOffered.getPayOnMonthOryear()));
		       
		        
		        table.addCell(cell3_a);
		        table.addCell(cell3_b);
		        table.addCell(cell3_c);
		        table.addCell(cell3_d);
		      
		        
		        PdfPCell cell4_a = new PdfPCell(new Paragraph("SpecialAllowance"));
		        PdfPCell cell4_b= new PdfPCell(new Paragraph(" "+salaryOffered.getSpecialAllowance()));
		        PdfPCell cell4_c = new PdfPCell(new Paragraph("SalaryOfferedId"));
		        PdfPCell cell4_d= new PdfPCell(new Paragraph(" "+salaryOffered.getSalaryOfferedId()));
		        
		        table.addCell(cell4_a);
		        table.addCell(cell4_b);
		        table.addCell(cell4_c);
		        table.addCell(cell4_d);
		        
		        
		        PdfPCell cell5_a = new PdfPCell(new Paragraph("Conveyance Allowance"));
		        PdfPCell cell5_b= new PdfPCell(new Paragraph("Total"));
		        PdfPCell cell5_c = new PdfPCell(new Paragraph("Professional Tax-Arrear/adjustment"));
		        PdfPCell cell5_d= new PdfPCell(new Paragraph("Total"));
		        
		        table.addCell(cell5_a);
		        table.addCell(cell5_b);
		        table.addCell(cell5_c);
		        table.addCell(cell5_d);
		        
		        
		        PdfPCell cell6_a = new PdfPCell(new Paragraph("Conveyance Allowance"));
		        PdfPCell cell6_b= new PdfPCell(new Paragraph("Total"));
		   //     PdfPCell cell6_c = new PdfPCell(new Paragraph("Professional Tax-Arrear/adjustment"));
		     //   PdfPCell cell6_d= new PdfPCell(new Paragraph("Total"));
		        
		        table.addCell(cell6_a);
		        table.addCell(cell6_b);
		       // table1.addCell(cell6_c);
		        //table1.addCell(cell6_d);
		        

		            document.add(table);
//		            document.add(table1);
//		            document.add(table2);
//		            document.add(table3);
//		            document.add(table4);
//		            document.add(table5);
//		            document.add(table6);

		         
		        
		         
				
		         document.close();
		        
		      } catch (DocumentException e)
		      {
		         e.printStackTrace();
		      } catch (FileNotFoundException e)
		      {
		         e.printStackTrace();
		      }

		      return new ResponseEntity<>("Success", HttpStatus.OK);
	}

}
