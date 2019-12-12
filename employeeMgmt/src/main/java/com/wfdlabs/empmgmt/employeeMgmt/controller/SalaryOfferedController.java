package com.wfdlabs.empmgmt.employeeMgmt.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.wfdlabs.empmgmt.employeeMgmt.entity.Employee;
import com.wfdlabs.empmgmt.employeeMgmt.entity.SalaryOffered;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
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

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST)
	public SalaryOffered createSalaryOffered(@RequestBody SalaryOffered salaryOffered) {
		return salaryOfferedService.createSalaryOffered(salaryOffered);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.PUT)
	public SalaryOffered UpdateSalaryOffered(@RequestBody SalaryOffered salaryOffered) {
		return salaryOfferedService.updateSalaryOffered(salaryOffered);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.GET)
	public SalaryOffered getSalaryOffered(@RequestParam Integer employeeId) {
		System.out.println("SalaryOffered:" + employeeId);
		return salaryOfferedService.getSalaryOffered(employeeId);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public List<SalaryOffered> getAllSalaryOffered() {
		return salaryOfferedService.getAllSalaryOffered();
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteSalaryOffered(@RequestParam Integer employeeId) {
		System.out.println("employeeId:" + employeeId);
		salaryOfferedService.deleteSalaryOffered(employeeId);
		return "delete record successfully";
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/generatePaySlipPdf", method = RequestMethod.GET)
	public ResponseEntity<String> generatePaySlipPdf(@RequestParam String month, @RequestParam Integer year,
			@RequestParam Integer employeId) throws IOException {
		Document document = new Document();
		Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
		Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 10);
		Font catfont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);

		Employee employee = null;
		PdfWriter writer = null;
		try {
			employee = employeeService.getEmployee(employeId);

			// Creating Pdf File
			writer = PdfWriter.getInstance(document, new FileOutputStream("E:\\" + employee.getFirstName() + ".pdf"));
			document.setMargins(30f, 30f, 30f, 30f);
			document.open();

			// Building a header part
			headerPart(month, year, smallBold, document);

			// Building Employee Details Table
			employeeDetailsTable(subFont, document);

			// Building Salary Details Table
			salaryDetailsTable(subFont, document);

			// Building Total Payments and Deductions table
			totalTable(catfont, document);

			// Building Signature Table
			signatureTable(document, catfont);

			document.close();

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>("PDF generayted successfull at" + " " + "E:\\" + employee.getFirstName() + ".pdf",
				HttpStatus.OK);
	}

	/**
	 * This method is used to build header part of payslip Pdf
	 * 
	 * @param month
	 * @param year
	 * @param smallBold
	 * @param document
	 * @throws DocumentException
	 */
	public void headerPart(@RequestParam String month, @RequestParam Integer year, Font smallBold, Document document)
			throws DocumentException {
		Font catfont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

		String companyName = "WFDLABS Pvt Ltd";
		String address = "32, 4th floor, 1st cross Kaveri layout, Marathahalli, Bangalore-560037";
		String paySlipDiscription = "Salary Slip for the month of the";

		// setting company Name
		Paragraph para = new Paragraph(companyName, smallBold);
		para.setAlignment(Element.ALIGN_CENTER);
		document.add(para);

		// Setting Adress
		para = new Paragraph(address, catfont);
		para.setAlignment(Element.ALIGN_CENTER);
		document.add(para);

		// Setting paySlipDiscription
		para = new Paragraph(paySlipDiscription + "  " + month + "/" + year.toString(), catfont);
		para.setAlignment(Element.ALIGN_CENTER);
		document.add(para);

		// Adding empty para for gap between Header and table
		para = new Paragraph("  ");
		para.setAlignment(Element.ALIGN_LEFT);
		document.add(para);
	}

	/**
	 * This method is used to build the Employee Details into tables of payslip Pdf
	 * 
	 * @param subFont
	 * @param document
	 * 
	 * @param employeeId
	 * @throws DocumentException
	 */
	public void employeeDetailsTable(Font subFont, Document document) throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.setWidthPercentage(100);
		table.setSpacingAfter(0);

		// Adding EmployeeDetails into a table in 1st Cell

		PdfPCell cell1_1 = new PdfPCell();
		cell1_1.addElement(new Paragraph(" " + "Employee Id:", subFont));
		cell1_1.addElement(new Paragraph(" " + "Emp Name:", subFont));
		cell1_1.addElement(new Paragraph(" " + "Date of Joing:", subFont));
		cell1_1.addElement(new Paragraph(" " + "PF NO:", subFont));
		cell1_1.addElement(new Paragraph(" " + "ESI NO:", subFont));
		table.addCell(cell1_1);

		// Adding Employee Details into a table in 2nd Cell
		PdfPCell cell1_2 = new PdfPCell(new Paragraph());

		cell1_2.addElement(new Paragraph(" " + "Pension No:", subFont));
		cell1_2.addElement(new Paragraph(" " + "Bank Name:", subFont));
		cell1_2.addElement(new Paragraph(" " + "Bank A/c no:", subFont));
		table.addCell(cell1_2);

		// Adding tables to Document
		document.add(table);

	}

	/**
	 * This method is used to build the Salary Details into tables of payslip Pdf
	 * 
	 * @param subFont
	 * @param document
	 * 
	 * @throws DocumentException
	 */
	public void salaryDetailsTable(Font subFont, Document document) throws DocumentException {
		Font catfont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		PdfPTable table1 = new PdfPTable(4);
		table1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1.setWidthPercentage(100);

		// Setting Earnings and Deductions Heading
		PdfPCell cell_a = new PdfPCell(new Paragraph("   " + "Earnings", catfont));
		cell_a.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell_b = new PdfPCell(new Paragraph("   " + "Total", catfont));
		cell_b.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell_c = new PdfPCell(new Paragraph("   " + "Deduction", catfont));
		cell_c.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell_d = new PdfPCell(new Paragraph("   " + "Total", catfont));
		cell_d.setHorizontalAlignment(Element.ALIGN_CENTER);

		// Adding Cells to Table
		table1.addCell(cell_a);
		table1.addCell(cell_b);
		table1.addCell(cell_c);
		table1.addCell(cell_d);

		// Setting Basic salary & Employee Provident Fund cell
		PdfPCell cell1_a = new PdfPCell(new Paragraph(" " + "Basic salary", subFont));
		PdfPCell cell1_b = new PdfPCell(new Paragraph(" "));
		cell1_b.setHorizontalAlignment(Element.ALIGN_RIGHT);
		PdfPCell cell1_c = new PdfPCell(new Paragraph(" " + "Employe Provident Fund", subFont));
		PdfPCell cell1_d = new PdfPCell(new Paragraph(" "));
		cell1_d.setHorizontalAlignment(Element.ALIGN_RIGHT);

		// Adding cells to table
		table1.addCell(cell1_a);
		table1.addCell(cell1_b);
		table1.addCell(cell1_c);
		table1.addCell(cell1_d);

		// Setting House Rent Allowance & Employee ESI Contribution Cells
		PdfPCell cell2_a = new PdfPCell(new Paragraph(" " + "House Rent Allowance", subFont));
		PdfPCell cell2_b = new PdfPCell(new Paragraph(" "));
		cell2_b.setHorizontalAlignment(Element.ALIGN_RIGHT);
		PdfPCell cell2_c = new PdfPCell(new Paragraph("Employee ESI Contribution", subFont));
		PdfPCell cell2_d = new PdfPCell(new Paragraph(" "));
		cell2_d.setHorizontalAlignment(Element.ALIGN_RIGHT);

		// Adding Cells to Table
		table1.addCell(cell2_a);
		table1.addCell(cell2_b);
		table1.addCell(cell2_c);
		table1.addCell(cell2_d);

		// setting Medical Allowance & Professional_Tax Cells
		PdfPCell cell3_a = new PdfPCell(new Paragraph(" " + "Medical Allowance", subFont));
		PdfPCell cell3_b = new PdfPCell(new Paragraph(" "));
		cell3_b.setHorizontalAlignment(Element.ALIGN_RIGHT);
		PdfPCell cell3_c = new PdfPCell(new Paragraph(" " + "Professional_Tax", subFont));
		PdfPCell cell3_d = new PdfPCell(new Paragraph(" "));
		cell3_d.setHorizontalAlignment(Element.ALIGN_RIGHT);

		// Adding Cells to Tables
		table1.addCell(cell3_a);
		table1.addCell(cell3_b);
		table1.addCell(cell3_c);
		table1.addCell(cell3_d);

		// Setting SpecialAllowance cell
		PdfPCell cell4_a = new PdfPCell(new Paragraph(" " + "SpecialAllowance", subFont));
		PdfPCell cell4_b = new PdfPCell(new Paragraph(" "));
		cell4_b.setHorizontalAlignment(Element.ALIGN_RIGHT);
		PdfPCell cell4_c = new PdfPCell(new Paragraph(" "));
		PdfPCell cell4_d = new PdfPCell(new Paragraph(" "));

		// Adding Cells to Table
		table1.addCell(cell4_a);
		table1.addCell(cell4_b);
		table1.addCell(cell4_c);
		table1.addCell(cell4_d);

		// Setting Conveyance Allowance cell
		PdfPCell cell5_a = new PdfPCell(new Paragraph(" " + "Conveyance Allowance", subFont));
		PdfPCell cell5_b = new PdfPCell(new Paragraph(" "));
		cell5_b.setHorizontalAlignment(Element.ALIGN_RIGHT);
		PdfPCell cell5_c = new PdfPCell(new Paragraph(""));
		PdfPCell cell5_d = new PdfPCell(new Paragraph(""));

		// Adding cells to Table
		table1.addCell(cell5_a);
		table1.addCell(cell5_b);
		table1.addCell(cell5_c);
		table1.addCell(cell5_d);

		// Setting PayOnMonthOryear Cell
		PdfPCell cell6_a = new PdfPCell(new Paragraph(" " + "PayOnMonthOryear", subFont));
		PdfPCell cell6_b = new PdfPCell(new Paragraph(" "));
		cell6_b.setHorizontalAlignment(Element.ALIGN_RIGHT);
		PdfPCell cell6_c = new PdfPCell(new Paragraph(""));
		PdfPCell cell6_d = new PdfPCell(new Paragraph(""));

		// Adding cells to table
		table1.addCell(cell6_a);
		table1.addCell(cell6_b);
		table1.addCell(cell6_c);
		table1.addCell(cell6_d);

		// Adding table to Document
		document.add(table1);
	}

	/**
	 * This method is used to build the Total Payments & Deductions into tables of
	 * payslip Pdf
	 * 
	 * @param document
	 * @param catfont
	 * 
	 * @throws DocumentException
	 */
	public void totalTable(Font catfont, Document document) throws DocumentException {
		int addTotalPayments;
		int addTotalDeductions;
		PdfPTable table2 = new PdfPTable(4);
		table2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.setWidthPercentage(100);

		// Building Total Payments Cell
		PdfPCell cell7_a = new PdfPCell(new Paragraph("   " + "Total Payments", catfont));
		PdfPCell cell7_b = new PdfPCell(new Paragraph(""));
		cell7_b.setHorizontalAlignment(Element.ALIGN_RIGHT);

		// Building Total Deduction Cell
		PdfPCell cell7_c = new PdfPCell(new Paragraph("   " + "Total Deductions", catfont));
		PdfPCell cell7_d = new PdfPCell(new Paragraph(""));

		// Adding cells to Table
		table2.addCell(cell7_a);
		table2.addCell(cell7_b);
		table2.addCell(cell7_c);
		table2.addCell(cell7_d);

		// Adding table to Document
		document.add(table2);

	}

	/**
	 * This method is used to build Net pay ,Amount Payable in word sand signature
	 * Elements into table of payslip Pdf
	 * 
	 * @param catfont
	 * @param document
	 * 
	 * @throws DocumentException
	 */
	public void signatureTable(Document document, Font catfont) throws DocumentException {

		// Adding Empty Paragraph to maintain gap between table
		Paragraph para = new Paragraph("  ");// Signature Block
		para.setAlignment(Element.ALIGN_LEFT);
		document.add(para);
		PdfPTable table3 = new PdfPTable(1);
		table3.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3.setWidthPercentage(100);
		table3.setSpacingAfter(0);

		// Setting Net Pay Element
		PdfPCell cell8_a = new PdfPCell();
		cell8_a.addElement(new Paragraph("Net Pay:", catfont));

		// Setting Amount Payable in words Element
		cell8_a.addElement(new Paragraph("Amount Payable in words :", catfont));
		cell8_a.setHorizontalAlignment(Element.ALIGN_LEFT);

		// Setting Signature Paragraph into Cell
		Paragraph p1 = new Paragraph();
		p1 = new Paragraph("Signature", catfont);
		p1.setAlignment(Element.ALIGN_RIGHT);
		cell8_a.addElement(p1);

		// Adding cell to table
		table3.addCell(cell8_a);

		// Adding Table to Document
		document.add(table3);

	}

	@RequestMapping(value = "/addMethod", method = RequestMethod.GET)
	public Integer addPayments(@RequestParam Integer salaryOfferedId) {
		SalaryOffered salaryOffered = salaryOfferedService.getSalaryOffered(salaryOfferedId);
		int addTotalPayments = (salaryOffered.getBasic()) + (salaryOffered.getHouseRentAllowance())
				+ (salaryOffered.getMedicalAllowance()) + (salaryOffered.getSpecialAllowance())
				+ (salaryOffered.getConveyanceAllowance()) + (salaryOffered.getPayOnMonthOryear());
		int addTotalDeductions = (salaryOffered.getEmployee_provident_fund())
				+ (salaryOffered.getEmployee_ESI_Contribution()) + (salaryOffered.getProfessional_Tax());
		System.out.println("TotalPayments=" + addTotalPayments + "TotalDeductions=" + addTotalDeductions);

		return addTotalPayments;
	}
}