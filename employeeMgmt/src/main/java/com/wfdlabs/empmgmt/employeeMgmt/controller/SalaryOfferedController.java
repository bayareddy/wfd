package com.wfdlabs.empmgmt.employeeMgmt.controller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
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
	public ResponseEntity<String> pdfMethod(@RequestParam String month,@RequestParam Integer year, @RequestParam Integer employeId, @RequestParam Integer salaryOfferedId) throws IOException {
			
		Employee emp=employeeService.getEmployee(employeId);
		SalaryOffered salaryOffered=salaryOfferedService.getSalaryOffered(salaryOfferedId);
		
		Font catfont=new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            Font.BOLD);
	    Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            Font.BOLD);
	    Font subFont = new Font(Font.FontFamily.TIMES_ROMAN,10);
	    Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 14,
	            Font.BOLD);
		
		
			 	 Document document = new Document();
			 	 //Document(new Rectangle(350f,Table.getTotalHeight()));

		      try
		      {
		         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("E:\\"+emp.getFirstName()+".pdf"));
		         document.setMargins(30f, 30f, 30f, 30f);
		         document.open();
		       
		         
		         
		         Paragraph para = new Paragraph();
		         Font fontHeader = new Font(FontFamily.HELVETICA);
	      
		        	  String str="WFDLABS Pvt Ltd";
		        	  String str1="32, 4th floor, 1st cross Kaveri layout, Marathahalli, Bangalore-560037";
		        	  String str2="Salary Slip for the month of the";
		        
		         para = new Paragraph(str,smallBold);
		         para.setAlignment(Element.ALIGN_CENTER);
		         document.add(para);
		         para = new Paragraph(str1,catfont);
		         para.setAlignment(Element.ALIGN_CENTER);
		         document.add(para);
		         
		         para = new Paragraph(str2 + "  " + month  + "/" + year.toString(),catfont);
		         para.setAlignment(Element.ALIGN_CENTER);
		         document.add(para);
		         
		         para = new Paragraph("  ");
	             para.setAlignment(Element.ALIGN_LEFT);
	             document.add(para);
	                
		         
		 	     PdfPTable table = new PdfPTable(2);

		         table.setHorizontalAlignment(Element.ALIGN_CENTER);
		         table.setWidthPercentage(100);
		         table.setSpacingAfter(0);
			    
			    
			    PdfPCell cell1_1 = new PdfPCell();
			    cell1_1.addElement(new Paragraph(" "+"Employee Id:"+"  " + emp.getEmployeeId(), subFont));
			    cell1_1.addElement(new Paragraph(" "+"Emp Name:" + emp.getFirstName()+" "+emp.getLastName(),subFont));
			    cell1_1.addElement(new Paragraph(" "+"Date of Joing:"+"  " + emp.getJoinDate(),subFont));
			    cell1_1.addElement(new Paragraph(" "+"PF NO:"+" "+emp.getPf_No(),subFont));
			    cell1_1.addElement(new Paragraph(" "+"ESI NO:"+" "+emp.geteSI_no(),subFont));
			    
			    table.addCell(cell1_1);
			    
			    PdfPCell cell1_2=new PdfPCell(new Paragraph());
			    cell1_2.addElement(new Paragraph(" "+"Pension No:" +"  "+emp.getPension_no(),subFont));
			    cell1_2 .addElement(new Paragraph(" "+"Bank Name:" +"  "+emp.getBankDetails(),subFont));
			    cell1_2 .addElement(new Paragraph(" "+"Bank A/c no:" +"  "+emp.getBank_Ac_no(),subFont));
			    
			    table.addCell(cell1_2);
		         
		         
		         
		         
		         PdfPTable table1 = new PdfPTable(4); //
		   
		         table1.setHorizontalAlignment(Element.ALIGN_CENTER);
		         table1.setWidthPercentage(100);
		        // table.setLockedWidth(true);
		        
		        PdfPCell cell_a = new PdfPCell(new Paragraph("   "+"Earnings",catfont));
		        cell_a.setHorizontalAlignment(cell_a.ALIGN_CENTER);
		        PdfPCell cell_b = new PdfPCell(new Paragraph("   "+"Total",catfont));
		        cell_b.setHorizontalAlignment(cell_b.ALIGN_CENTER);
	            PdfPCell cell_c= new PdfPCell(new Paragraph("   "+"Deduction",catfont));
	            cell_c.setHorizontalAlignment(cell_c.ALIGN_CENTER);
	            PdfPCell cell_d = new PdfPCell(new Paragraph("   "+"Total",catfont));
	            cell_d.setHorizontalAlignment(cell_d.ALIGN_CENTER);
	            
	            table1.addCell(cell_a);
	            table1.addCell(cell_b);
	            table1.addCell(cell_c);
	            table1.addCell(cell_d);
	            table1.getSpacingBefore();
	            

		        PdfPCell cell1_a = new PdfPCell(new Paragraph(" "+"Basic salary",subFont));
		        PdfPCell cell1_b= new PdfPCell(new Paragraph(" "+salaryOffered.getBasic(),subFont));
		        cell1_b.setHorizontalAlignment(cell1_b.ALIGN_RIGHT);
		        PdfPCell cell1_c = new PdfPCell(new Paragraph(" "+"Employe Provident Fund",subFont));
		        PdfPCell cell1_d= new PdfPCell(new Paragraph(" "+salaryOffered.getEmployee_provident_fund(),subFont));
		        cell1_d.setHorizontalAlignment(cell1_d.ALIGN_RIGHT);
		        
		        table1.addCell(cell1_a);
		        table1.addCell(cell1_b);
		        table1.addCell(cell1_c);
		        table1.addCell(cell1_d);

		        
		        PdfPCell cell2_a = new PdfPCell(new Paragraph(" "+"House Rent Allowance",subFont));
		        PdfPCell cell2_b= new PdfPCell(new Paragraph(""+salaryOffered.getHouseRentAllowance(),subFont));
		        cell2_b.setHorizontalAlignment(cell1_a.ALIGN_RIGHT);
		        PdfPCell cell2_c = new PdfPCell(new Paragraph("Employee ESI Contribution",subFont));
		        PdfPCell cell2_d= new PdfPCell(new Paragraph(" "+salaryOffered.getEmployee_ESI_Contribution(),subFont));
		        cell2_d.setHorizontalAlignment(cell1_a.ALIGN_RIGHT);
		        
		        table1.addCell(cell2_a);
		        table1.addCell(cell2_b);
		        table1.addCell(cell2_c);
		        table1.addCell(cell2_d);
		        
		        PdfPCell cell3_a = new PdfPCell(new Paragraph(" "+"Medical Allowance",subFont));
		        PdfPCell cell3_b= new PdfPCell(new Paragraph(" "+salaryOffered.getMedicalAllowance(),subFont));
		        cell3_b.setHorizontalAlignment(cell3_b.ALIGN_RIGHT);
		        PdfPCell cell3_c = new PdfPCell(new Paragraph(" "+"Professional_Tax",subFont));
		        PdfPCell cell3_d= new PdfPCell(new Paragraph(" "+salaryOffered.getProfessional_Tax(),subFont));
		        cell3_d.setHorizontalAlignment(cell3_d.ALIGN_RIGHT);
		       
		        
		        table1.addCell(cell3_a);
		        table1.addCell(cell3_b);
		        table1.addCell(cell3_c);
		        table1.addCell(cell3_d);
		      
		        
		        PdfPCell cell4_a = new PdfPCell(new Paragraph(" "+"SpecialAllowance",subFont));
		        PdfPCell cell4_b= new PdfPCell(new Paragraph(" "+salaryOffered.getSpecialAllowance(),subFont));
		        cell4_b.setHorizontalAlignment(cell4_b.ALIGN_RIGHT);
		        PdfPCell cell4_c = new PdfPCell(new Paragraph(" "));
		        PdfPCell cell4_d= new PdfPCell(new Paragraph(" "));
		        
		        table1.addCell(cell4_a);
		        table1.addCell(cell4_b);
		        table1.addCell(cell4_c);
		        table1.addCell(cell4_d);
		        
		        
		        PdfPCell cell5_a = new PdfPCell(new Paragraph(" "+"Conveyance Allowance",subFont));
		        PdfPCell cell5_b= new PdfPCell(new Paragraph(" "+ salaryOffered.getConveyanceAllowance(),subFont));
		        cell5_b.setHorizontalAlignment(cell5_b.ALIGN_RIGHT);
		        PdfPCell cell5_c = new PdfPCell(new Paragraph(""));
		        PdfPCell cell5_d= new PdfPCell(new Paragraph(""));
		        
		        table1.addCell(cell5_a);
		        table1.addCell(cell5_b);
		        table1.addCell(cell5_c);
		        table1.addCell(cell5_d);
		        
		        
		        PdfPCell cell6_a = new PdfPCell(new Paragraph(" "+"PayOnMonthOryear",subFont));
		        PdfPCell cell6_b= new PdfPCell(new Paragraph(" "+ salaryOffered.getPayOnMonthOryear(),subFont));
		        cell6_b.setHorizontalAlignment(cell6_b.ALIGN_RIGHT);
		        PdfPCell cell6_c = new PdfPCell(new Paragraph(""));
		        PdfPCell cell6_d= new PdfPCell(new Paragraph(""));
		        
		        table1.addCell(cell6_a);
		        table1.addCell(cell6_b);
		        table1.addCell(cell6_c);
		        table1.addCell(cell6_d);
		        
		        PdfPTable table2 = new PdfPTable(4);
		        table2.setHorizontalAlignment(Element.ALIGN_CENTER);
		         table2.setWidthPercentage(100);
		        
		        PdfPCell cell7_a = new PdfPCell(new Paragraph("   "+"Total Payments",catfont));
		        PdfPCell cell7_b= new PdfPCell(new Paragraph(""));
		        cell7_b.setHorizontalAlignment(cell7_b.ALIGN_RIGHT);
		        PdfPCell cell7_c = new PdfPCell(new Paragraph("   "+"Total Deductions",catfont));
		        PdfPCell cell7_d= new PdfPCell(new Paragraph(""));
		        
		        table2.addCell(cell7_a);
		        table2.addCell(cell7_b);
		        table2.addCell(cell7_c);
		        table2.addCell(cell7_d);

		            document.add(table);
		            document.add(table1);
		            document.add(table2);
		            
		          para = new Paragraph("  ");//Signature Block
		             para.setAlignment(Element.ALIGN_LEFT);
		             document.add(para);
		             PdfPTable table3 = new PdfPTable(1); //
		   		  
		  		   
			         table3.setHorizontalAlignment(Element.ALIGN_CENTER);
			         table3.setWidthPercentage(100);
			         table3.setSpacingAfter(0);
			        // table.setLockedWidth(true);
			        
			         PdfPCell cell8_a = new PdfPCell();
			         cell8_a.addElement(new Paragraph("Net Pay:", redFont));
			         cell8_a.addElement(new Paragraph("Amount Payable in words :",redFont));
			         cell8_a.setHorizontalAlignment(Element.ALIGN_LEFT);
			         cell8_a.addElement(new Paragraph("Signature",redFont));
			         cell8_a.setHorizontalAlignment(Element.ALIGN_RIGHT);
			         cell8_a.setHorizontalAlignment(Element.ALIGN_RIGHT);
			         table3.addCell(cell8_a);
			        
			         document.add(table3);
                 

		         
		        
		         table.spacingBefore();
		       //  footer();
				
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
//	static Integer addSalary(int getBasic(),int getPayOnMonthOryear(),int getSalaryOfferedId() )  {
//		return getBasic() + getPayOnMonthOryear() + getSalaryOfferedId();
//	}

	
	
	public void footer() throws DocumentException {
		Document document =new Document();
		 
	         document.close();
	}
}
