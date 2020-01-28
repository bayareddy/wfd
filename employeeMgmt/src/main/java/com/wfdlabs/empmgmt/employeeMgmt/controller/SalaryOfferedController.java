package com.wfdlabs.empmgmt.employeeMgmt.controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
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
import java.math.BigInteger;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;
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
	public ResponseEntity<String> generatePaySlipPdf(@RequestParam String month, @RequestParam Integer year,
			@RequestParam Integer salaryOfferedId, @RequestParam Integer employeId) throws IOException {
		Document document = new Document();
		Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
		Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 10);
		Font catfont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

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
		cell_a.setHorizontalAlignment(cell_a.ALIGN_CENTER);
		PdfPCell cell_b = new PdfPCell(new Paragraph("   " + "Total", catfont));
		cell_b.setHorizontalAlignment(cell_b.ALIGN_CENTER);
		PdfPCell cell_c = new PdfPCell(new Paragraph("   " + "Deduction", catfont));
		cell_c.setHorizontalAlignment(cell_c.ALIGN_CENTER);
		PdfPCell cell_d = new PdfPCell(new Paragraph("   " + "Total", catfont));
		cell_d.setHorizontalAlignment(cell_d.ALIGN_CENTER);
		// Adding Cells to Table
		table1.addCell(cell_a);
		table1.addCell(cell_b);
		table1.addCell(cell_c);
		table1.addCell(cell_d);
		// Setting Basic salary & Employe Provident Fund cell
		PdfPCell cell1_a = new PdfPCell(new Paragraph(" " + "Basic salary", subFont));
		PdfPCell cell1_b = new PdfPCell(new Paragraph(" "));
		cell1_b.setHorizontalAlignment(cell1_b.ALIGN_RIGHT);
		PdfPCell cell1_c = new PdfPCell(new Paragraph(" " + "Employe Provident Fund", subFont));
		PdfPCell cell1_d = new PdfPCell(new Paragraph(" "));
		cell1_d.setHorizontalAlignment(cell1_d.ALIGN_RIGHT);
		// Adding cells to table
		table1.addCell(cell1_a);
		table1.addCell(cell1_b);
		table1.addCell(cell1_c);
		table1.addCell(cell1_d);
		// Setting House Rent Allowance & Employee ESI Contribution Cells
		PdfPCell cell2_a = new PdfPCell(new Paragraph(" " + "House Rent Allowance", subFont));
		PdfPCell cell2_b = new PdfPCell(new Paragraph(" "));
		cell2_b.setHorizontalAlignment(cell1_a.ALIGN_RIGHT);
		PdfPCell cell2_c = new PdfPCell(new Paragraph("Employee ESI Contribution", subFont));
		PdfPCell cell2_d = new PdfPCell(new Paragraph(" "));
		cell2_d.setHorizontalAlignment(cell1_a.ALIGN_RIGHT);
		// Adding Cells to Table
		table1.addCell(cell2_a);
		table1.addCell(cell2_b);
		table1.addCell(cell2_c);
		table1.addCell(cell2_d);
		// setting Medical Allowance & Professional_Tax Cells
		PdfPCell cell3_a = new PdfPCell(new Paragraph(" " + "Medical Allowance", subFont));
		PdfPCell cell3_b = new PdfPCell(new Paragraph(" "));
		cell3_b.setHorizontalAlignment(cell3_b.ALIGN_RIGHT);
		PdfPCell cell3_c = new PdfPCell(new Paragraph(" " + "Professional_Tax", subFont));
		PdfPCell cell3_d = new PdfPCell(new Paragraph(" "));
		cell3_d.setHorizontalAlignment(cell3_d.ALIGN_RIGHT);
		// Adding Cells to Tables
		table1.addCell(cell3_a);
		table1.addCell(cell3_b);
		table1.addCell(cell3_c);
		table1.addCell(cell3_d);
		// Setting SpecialAllowance cell
		PdfPCell cell4_a = new PdfPCell(new Paragraph(" " + "SpecialAllowance", subFont));
		PdfPCell cell4_b = new PdfPCell(new Paragraph(" "));
		cell4_b.setHorizontalAlignment(cell4_b.ALIGN_RIGHT);
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
		cell5_b.setHorizontalAlignment(cell5_b.ALIGN_RIGHT);
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
		cell6_b.setHorizontalAlignment(cell6_b.ALIGN_RIGHT);
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
		cell7_b.setHorizontalAlignment(cell7_b.ALIGN_RIGHT);
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

	/*
	 * @RequestMapping(value= "/addMethod",method=RequestMethod.GET) public Integer
	 * addPayments(@RequestParam Integer salaryOfferedId) { SalaryOffered
	 * salaryOffered =salaryOfferedService.getSalaryOffered(salaryOfferedId); int
	 * addTotalPayments=(salaryOffered.getBasic()) +
	 * (salaryOffered.getHouseRentAllowance()) +
	 * (salaryOffered.getMedicalAllowance()) +
	 * (salaryOffered.getSpecialAllowance())+
	 * (salaryOffered.getConveyanceAllowance())+
	 * (salaryOffered.getPayOnMonthOryear()); int
	 * addTotalDeductions=(salaryOffered.getEmployee_provident_fund())+
	 * (salaryOffered.getEmployee_ESI_Contribution())+
	 * (salaryOffered.getProfessional_Tax()); System.out.println("TotalPayments="+
	 * addTotalPayments + "TotalDeductions="+ addTotalDeductions);
	 * 
	 * return addTotalPayments; }
	 */
/*	@RequestMapping(value = { "/offerLetter" }, method = RequestMethod.GET)
	public void generateOfferLetter() throws IOException {

		XWPFDocument document = new XWPFDocument();
		XWPFParagraph paragraphMr = document.createParagraph();
		paragraphMr.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runMr = paragraphMr.createRun();
		runMr.setBold(true);
		runMr.setText("Mr.");

		XWPFParagraph paragraphDate = document.createParagraph();
		paragraphDate.setAlignment(ParagraphAlignment.RIGHT);
		XWPFRun runDate = paragraphDate.createRun();
		runDate.setText("\r\n" + "Date :"+"");

		XWPFParagraph paragraphPlace = document.createParagraph();
		paragraphPlace.setAlignment(ParagraphAlignment.RIGHT);
		XWPFRun runPlace = paragraphPlace.createRun();
		runPlace.setText("Banglore");

		XWPFParagraph paragraphSubject = document.createParagraph();
		paragraphSubject.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runSubject = paragraphSubject.createRun();
		runSubject.setBold(true);
		runSubject.setText("\r\n" +"Subject: OFFER OF EMOPLOYMENT	\n");
// Role And Date of Joining
		XWPFParagraph paragraph1 = document.createParagraph();
		paragraph1.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun run1 = paragraph1.createRun();
		run1.setText("Dear  Ashok");
		XWPFParagraph paragraph1a = document.createParagraph();
		paragraph1a.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun run1a = paragraph1a.createRun();
		run1a.setText("\r\n"
				+ "With reference to your application and the subsequent interview that you had with us on 05th September 2018 for employment in our company, we are pleased to appoint you as “Associate Software Engineer” on following terms and conditions.\r\n");
//Date Of joining Paragraph
		XWPFParagraph paragraph1b = document.createParagraph();
		paragraph1b.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun run1b = paragraph1b.createRun();
		run1b.setBold(true);
		run1b.setUnderline(UnderlinePatterns.SINGLE);
		run1b.setText("Date Of Joining" );
		XWPFParagraph paragraph1c = document.createParagraph();
		paragraph1c.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun run1c = paragraph1c.createRun();
		run1c.setText("\r\n"
				+ "This appointment letter is valid for your joining on or before 5thSeptember 2018. In case of your not complying this, the appointment would be treated as cancelled.\r\n"
				);
// Medica Fitness Paragraph
		XWPFParagraph paragraphMedical = document.createParagraph();
		paragraphMedical.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runMedical = paragraphMedical.createRun();
		runMedical.setBold(true);
		runMedical.setUnderline(UnderlinePatterns.SINGLE);
		runMedical.setText("Medical Fitness" + "\n");
		XWPFParagraph paragraphMedical1 = document.createParagraph();
		paragraphMedical1.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runMedical1 = paragraphMedical1.createRun();
		runMedical1.setText("\r\n"
				+ "The appointment is valid only in case of your being found medically fit to perform your duties by the registered Medical Practitioner authorized by the Company. Further, your fitness for the job is subject to periodical medical examinations by the company.\r\n"
				);
//Certificate / Testimonals Paragraph	
		XWPFParagraph paragraphCerificate = document.createParagraph();
		paragraphCerificate.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runCertificate = paragraphCerificate.createRun();
		runCertificate.setBold(true);
		runCertificate.setUnderline(UnderlinePatterns.SINGLE);
		runCertificate.setText("Certificate / Testimonials:" );
		XWPFParagraph paragraphCerificate1 = document.createParagraph();
		paragraphCerificate1.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runCertificate1 = paragraphCerificate1.createRun();
		runCertificate1.setText("\r\n"
				+ "The appointment is further subject to your providing documented proofs about details mentioned in the Application form by you and information provided by you during interviews with the management. This includes;\r\n"
				);
		XWPFParagraph paragraphCerificate2 = document.createParagraph();
		paragraphCerificate2.setAlignment(ParagraphAlignment.CENTER);
		paragraphCerificate2.setAlignment(ParagraphAlignment.NUM_TAB);
		XWPFRun runCertificate2 = paragraphCerificate2.createRun();
		runCertificate2.setText("\r\n"
				+ "Certificates of educational qualifications and any other professional qualifications.");
		runCertificate2.setText("\r\n"
				+ "Certificates from the previous employee(s) regarding position held, emoluments earned general conduct during employment, reason and date of leaving the previous employer / organization.\r\n"
				);
// Probation period Paragraph
		XWPFParagraph paragraphProbation = document.createParagraph();
		paragraphProbation.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runProbation = paragraphProbation.createRun();
		runProbation.setBold(true);
		runProbation.setUnderline(UnderlinePatterns.SINGLE);
		runProbation.setText("\r\n" + "Probation period:\r\n");
		XWPFParagraph paragraphProbation1 = document.createParagraph();
		paragraphProbation1.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runProbation1 = paragraphProbation1.createRun();
		runProbation1.setText(
				"The period of first six months from your joining duty will be considered as Probation period. During this period you are required to get yourself acquainted to the job. At the end of this period your performance will be reviewed. Satisfactory performance may lead to confirmation of your services with the company and unsatisfactory performance can lead to extension of probation period for another three months or cessation of your employment. This will be at sole discretion of the management. Your probation period would be considered to be extended if you are intimated in writing about confirmation of your services.");
//Remuneration Paragraph		
		XWPFParagraph paragraphRemuneration = document.createParagraph();
		paragraphRemuneration.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runRemuneration = paragraphRemuneration.createRun();
		runRemuneration.setBold(true);
		runRemuneration.setUnderline(UnderlinePatterns.SINGLE);
		runRemuneration.setText("Remuneration:\r\n");
		XWPFParagraph paragraphRemuneration1 = document.createParagraph();
		paragraphRemuneration1.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runRemuneration1 = paragraphRemuneration1.createRun();
		runRemuneration1.setText("Your annual Remuneration will be as described below:\r\n");

// Creating table
		XWPFTable table=document.createTable();
		 //create first row
	      XWPFTableRow tableRowOne = table.getRow(0);
	      tableRowOne.getCell(0).setText("Basic");
	      tableRowOne.addNewTableCell().setText("1,20,000");
	      // create second row
	      XWPFTableRow tableRowTwo=table.createRow();
	      tableRowTwo.getCell(0).setText("HRA");
	      tableRowTwo.getCell(1).setText("000");
	      // create Third row
	      XWPFTableRow tableRowThree=table.createRow();
	      tableRowThree.getCell(0).setText("Allowance");
	      tableRowThree.getCell(1).setText("000");
	      // create four row
	      XWPFTableRow tableRowFour=table.createRow();
	      tableRowFour.getCell(0).setText("CCA");
	      tableRowFour.getCell(1).setText("000");
	      // create Five row
	      XWPFTableRow tableRowFive=table.createRow();
	      tableRowFive.getCell(0).setText("Medical");
	      tableRowFive.getCell(1).setText("000");
	      // create Six row
	      XWPFTableRow tableRowSix=table.createRow();
	      tableRowSix.getCell(0).setText("CONVEYANCE");
	      tableRowSix.getCell(1).setText("000");
	      // create Seven row
	      XWPFTableRow tableRowSeven=table.createRow();
	      tableRowSeven.getCell(0).setText("Total");
	      tableRowSeven.getCell(1).setText("000");
		
		
		// Write the Document in file system
		FileOutputStream out = new FileOutputStream(new File("E:\\Ashok.docx"));
		document.write(out);
		out.close();
		System.out.println("createdocument.docx written successully");
	}*/
	@RequestMapping(value = "/generateWordDoc", method = RequestMethod.GET, produces = "application/Word")
	public ResponseEntity<byte[]> getWord() throws IOException, XmlException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

		XWPFDocument document = new XWPFDocument();
		XWPFParagraph paragraph = document.createParagraph();
		  XWPFRun run=paragraph.createRun();  

		  // create header start
		  CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
		  XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(document, sectPr);

		  XWPFHeader header = headerFooterPolicy.createHeader(XWPFHeaderFooterPolicy.DEFAULT);

		  paragraph = header.createParagraph();
		  paragraph.setAlignment(ParagraphAlignment.LEFT);
		  
		  //CTPageMar pageMar = sectPr.getPgMar();
		  

		  CTTabStop tabStop = paragraph.getCTP().getPPr().addNewTabs().addNewTab();
		  tabStop.setVal(STTabJc.RIGHT);
		  int twipsPerInch =  1000;
		  tabStop.setPos(BigInteger.valueOf(6 * twipsPerInch));

		
		  File img = new File("E://wfdlab.jpeg");
		  XWPFParagraph imgPraragraph = header.createParagraph();
		  imgPraragraph.setFontAlignment(ParagraphAlignment.LEFT.getValue());
		  XWPFRun imgRun = imgPraragraph.createRun();
		  imgRun.addBreak();
		  imgRun.addBreak();
		  imgRun.addBreak();
		  
		  imgRun.addPicture(new FileInputStream(img), XWPFDocument.PICTURE_TYPE_JPEG, "img", Units.toEMU(200), Units.toEMU(50));
		  

		  XWPFParagraph paragraphMr = document.createParagraph();
			paragraphMr.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runMr = paragraphMr.createRun();
			runMr.setBold(true);
			runMr.setText("Mr.");

			XWPFParagraph paragraphDate = document.createParagraph();
			paragraphDate.setAlignment(ParagraphAlignment.RIGHT);
			XWPFRun runDate = paragraphDate.createRun();
			runDate.setText("\r\n" + "Date :" + "");

			XWPFParagraph paragraphPlace = document.createParagraph();
			paragraphPlace.setAlignment(ParagraphAlignment.RIGHT);
			XWPFRun runPlace = paragraphPlace.createRun();
			runPlace.setText("Banglore");

			XWPFParagraph paragraphSubject = document.createParagraph();
			paragraphSubject.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runSubject = paragraphSubject.createRun();
			runSubject.setBold(true);
			runSubject.setText("\r\n" + "Subject: OFFER OF EMOPLOYMENT	\n");
	// Role And Date of Joining
			XWPFParagraph paragraph1 = document.createParagraph();
			paragraph1.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun run1 = paragraph1.createRun();
			run1.setText("Dear  Ashok");
			XWPFParagraph paragraph1a = document.createParagraph();
			paragraph1a.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun run1a = paragraph1a.createRun();
			run1a.setText("\r\n"
					+ "With reference to your application and the subsequent interview that you had with us on 05th "
					+ "September 2018 for employment in our company, we are pleased to appoint you as “Associate Software"
					+ " Engineer” on following terms and conditions.\r\n");
	//Date Of joining Paragraph
			XWPFParagraph paragraph1b = document.createParagraph();
			paragraph1b.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun run1b = paragraph1b.createRun();
			run1b.setBold(true);
			run1b.setUnderline(UnderlinePatterns.SINGLE);
			run1b.setText("Date Of Joining");
			XWPFParagraph paragraph1c = document.createParagraph();
			paragraph1c.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun run1c = paragraph1c.createRun();
			run1c.setText("\r\n"
					+ "This appointment letter is valid for your joining on or before 5thSeptember 2018. In case of your "
					+ "not complying this, the appointment would be treated as cancelled.\r\n");
	// Medica Fitness Paragraph
			XWPFParagraph paragraphMedical = document.createParagraph();
			paragraphMedical.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runMedical = paragraphMedical.createRun();
			runMedical.setBold(true);
			runMedical.setUnderline(UnderlinePatterns.SINGLE);
			runMedical.setText("Medical Fitness" + "\n");
			XWPFParagraph paragraphMedical1 = document.createParagraph();
			paragraphMedical1.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runMedical1 = paragraphMedical1.createRun();
			runMedical1.setText("\r\n"
					+ "The appointment is valid only in case of your being found medically fit to perform your duties by"
					+ " the registered Medical Practitioner authorized by the Company. Further, your fitness for the job"
					+ " is subject to periodical medical examinations by the company.\r\n");
	//Certificate / Testimonals Paragraph	
			XWPFParagraph paragraphCerificate = document.createParagraph();
			paragraphCerificate.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runCertificate = paragraphCerificate.createRun();
			runCertificate.setBold(true);
			runCertificate.setUnderline(UnderlinePatterns.SINGLE);
			runCertificate.setText("Certificate / Testimonials:");
			XWPFParagraph paragraphCerificate1 = document.createParagraph();
			paragraphCerificate1.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runCertificate1 = paragraphCerificate1.createRun();
			runCertificate1.setText("\r\n"
					+ "The appointment is further subject to your providing documented proofs about details mentioned in"
					+ " the Application form by you and information provided by you during interviews with the management. This includes;\r\n");
			XWPFParagraph paragraphCerificate2 = document.createParagraph();
			paragraphCerificate2.setAlignment(ParagraphAlignment.CENTER);
			paragraphCerificate2.setAlignment(ParagraphAlignment.NUM_TAB);
			XWPFRun runCertificate2 = paragraphCerificate2.createRun();
			runCertificate2.setText(
					"\r\n" + "Certificates of educational qualifications and any other professional qualifications.");
			runCertificate2.setText("\r\n"
					+ "Certificates from the previous employee(s) regarding position held, emoluments earned general conduct"
					+ " during employment, reason and date of leaving the previous employer / organization.\r\n");
	// Probation period Paragraph
			XWPFParagraph paragraphProbation = document.createParagraph();
			paragraphProbation.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runProbation = paragraphProbation.createRun();
			runProbation.setBold(true);
			runProbation.setUnderline(UnderlinePatterns.SINGLE);
			runProbation.setText("\r\n" + "Probation period:\r\n");
			XWPFParagraph paragraphProbation1 = document.createParagraph();
			paragraphProbation1.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runProbation1 = paragraphProbation1.createRun();
			runProbation1
					.setText("The period of first six months from your joining duty will be considered as Probation period."
							+ " During this period you are required to get yourself acquainted to the job. At the end of this "
							+ "period your performance will be reviewed. Satisfactory performance may lead to confirmation of"
							+ " your services with the company and unsatisfactory performance can lead to extension of probation "
							+ "period for another three months or cessation of your employment. This will be at sole discretion of"
							+ " the management. Your probation period would be considered to be extended if you are intimated in"
							+ " writing about confirmation of your services.");
	//Remuneration Paragraph		
			XWPFParagraph paragraphRemuneration = document.createParagraph();
			paragraphRemuneration.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runRemuneration = paragraphRemuneration.createRun();
			runRemuneration.setBold(true);
			runRemuneration.setUnderline(UnderlinePatterns.SINGLE);
			runRemuneration.setText("Remuneration:\r\n");
			XWPFParagraph paragraphRemuneration1 = document.createParagraph();
			paragraphRemuneration1.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runRemuneration1 = paragraphRemuneration1.createRun();
			runRemuneration1.setText("Your annual Remuneration will be as described below:\r\n");

	// Creating table
			XWPFTable table = document.createTable();
			// create first row
			XWPFTableRow tableRowOne = table.getRow(0);
			tableRowOne.getCell(0).setText("Basic");
			tableRowOne.addNewTableCell().setText("1,20,000");
			// create second row
			XWPFTableRow tableRowTwo = table.createRow();
			tableRowTwo.getCell(0).setText("HRA");
			tableRowTwo.getCell(1).setText("000");
			// create Third row
			XWPFTableRow tableRowThree = table.createRow();
			tableRowThree.getCell(0).setText("Allowance");
			tableRowThree.getCell(1).setText("000");
			// create four row
			XWPFTableRow tableRowFour = table.createRow();
			tableRowFour.getCell(0).setText("CCA");
			tableRowFour.getCell(1).setText("000");
			// create Five row
			XWPFTableRow tableRowFive = table.createRow();
			tableRowFive.getCell(0).setText("Medical");
			tableRowFive.getCell(1).setText("000");
			// create Six row
			XWPFTableRow tableRowSix = table.createRow();
			tableRowSix.getCell(0).setText("CONVEYANCE");
			tableRowSix.getCell(1).setText("000");
			// create Seven row
			XWPFTableRow tableRowSeven = table.createRow();
			tableRowSeven.getCell(0).setText("Total");
			tableRowSeven.getCell(1).setText("000");

			// Working Hours and Weekly Off
			XWPFParagraph paragraphWorkingHours = document.createParagraph();
			paragraphWorkingHours.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runWorkingHours = paragraphWorkingHours.createRun();
			runWorkingHours.setBold(true);
			runWorkingHours.setUnderline(UnderlinePatterns.SINGLE);
			runWorkingHours.setText("Working Hours and Weekly Off:" + "\n");
			XWPFParagraph paragraphWorkingHours1 = document.createParagraph();
			paragraphWorkingHours1.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runWorkingHours1 = paragraphWorkingHours1.createRun();
			runWorkingHours1.setText("\r\n"
					+ "You will attend your duties and discharge the responsibilities entrusted upon you as per the "
					+ "working hours scheduled by the management for your department or functional area."
					+ " The schedules for working hours and weekly off authorized by superiors will have to be compiled all the time."
					+ " Such schedules are subject to changes and modifications depending upon exigency of work. You may be transferred "
					+ "from one shift to another as and when need arises and also you may be required to work for extra hours keeping in view "
					+ "the urgency of  work as deemed necessary by your superiors." + " ");
			// Leave
			XWPFParagraph paragraphLeave = document.createParagraph();
			paragraphLeave.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runLeave = paragraphLeave.createRun();
			runLeave.setBold(true);
			runLeave.setUnderline(UnderlinePatterns.SINGLE);
			runLeave.setText("Leave:" + "\n");
			XWPFParagraph paragraphLeave1 = document.createParagraph();
			paragraphLeave1.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runLeave1 = paragraphLeave1.createRun();
			runLeave1.setText("\r\n"
					+ "You will be entitled to a number of working days for a calendar year comprising of 12 casual Leaves."
					+ " This distribution and entitlement is subjected to change. Entitlement and utilization of earned "
					+ "Leave will be governed by the Factories Act. Entitlement of Leave is not the right to leave. Advance"
					+ " approval / sanction of superiors and reporting authority is to be obtained before availing any leave."
					+ " Remaining absent from duty without sanctioned leave will be treated as unauthorized leave." + " ");
			// Transfer
			XWPFParagraph paragraphTransfer = document.createParagraph();
			paragraphTransfer.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runTransfer = paragraphTransfer.createRun();
			runTransfer.setBold(true);
			runTransfer.setUnderline(UnderlinePatterns.SINGLE);
			runTransfer.setText("Leave:" + "\n");
			XWPFParagraph paragraphTransfer1 = document.createParagraph();
			paragraphTransfer1.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runTransfer1 = paragraphTransfer1.createRun();
			runTransfer1.setText("\r\n"
					+ "Your employment is liable from one department to another or from one unit / office / plant / site / location"
					+ " of the company whether existing or which may come in existence in future anywhere across the country."
					+ "");
			XWPFParagraph paragraphTransfer2 = document.createParagraph();
			paragraphTransfer2.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runTransfer2 = paragraphTransfer2.createRun();
			runTransfer2.setText(
					"On all such transfers, the conditions of services and rules and regulations applicable at the place of\"\r\n"
							+ "transfer will be application to you." + "");
			// Secrecy
			XWPFParagraph paragraphSecrecy = document.createParagraph();
			paragraphSecrecy.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runSecrecy = paragraphSecrecy.createRun();
			runSecrecy.setBold(true);
			runSecrecy.setUnderline(UnderlinePatterns.SINGLE);
			runSecrecy.setText("Secrecy:" + "\n");
			XWPFParagraph paragraphSecrecy1 = document.createParagraph();
			paragraphSecrecy1.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runSecrecy1 = paragraphSecrecy.createRun();
			runSecrecy1.setText("\r\n"
					+ "A complete secrecy will have to be observed by you on all company matters including Security arrangements,"
					+ " Technical know-how, and Financial and Administration matters. And shall not divulge or be responsible for "
					+ "divulging any secret of the company to any person(s) during your employment and afterwards. Any breach of "
					+ "this condition on your part shall be enough to terminate your services from the company with immediate effect."
					+ "");
			// Safe up-keeping of company’s property
			XWPFParagraph paragraphSafeUpKeeping = document.createParagraph();
			paragraphSafeUpKeeping.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runSafeUpKeeping = paragraphSafeUpKeeping.createRun();
			runSafeUpKeeping.setBold(true);
			runSafeUpKeeping.setUnderline(UnderlinePatterns.SINGLE);
			runSecrecy.setText("Safe up-keeping of company’s property:" + "\n");
			XWPFParagraph paragraphSafeUpKeeping1 = document.createParagraph();
			paragraphSafeUpKeeping.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runSafeUpKeeping1 = paragraphSafeUpKeeping1.createRun();
			runSafeUpKeeping1.setText("\r\n"
					+ "Safe up-keeping and return in good conditions and order of all the company’s property such as tools, equipment’s,"
					+ " instruments, uniform, literature etc. in your use / custody / care / charge will have to be observed by you."
					+ " Accountability of any such goods or literatures etc., provided to you for official purpose will be yours. "
					+ "On completion of work or assignment or at the terminate or cessation of employment, you will return all such "
					+ "properties allotted to you to your reporting authority with record.");
			// Termination
			XWPFParagraph paragraphTermination = document.createParagraph();
			paragraphTermination.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runTermination = paragraphTermination.createRun();
			runTermination.setBold(true);
			runTermination.setUnderline(UnderlinePatterns.SINGLE);
			runTermination.setText("Termination:" + "\n");

			XWPFParagraph paragraphTermination1 = document.createParagraph();
			paragraphTermination1.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runTermination1 = paragraphTermination1.createRun();
			runTermination1.setText(
					"Your employment with the company can be terminated by the management with immediate effect without assigning "
							+ "any reason whatsoever during the training or probationary period of your services. Any breach of trust on your"
							+ " part will be liable for termination of your services with 30 days’ notice period. After confirmation, your services"
							+ " can be terminated by notice pay in lieu of notice period." + "");

			XWPFParagraph paragraphTermination2 = document.createParagraph();
			paragraphTermination2.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runTermination2 = paragraphTermination2.createRun();
			runTermination2.setText(
					"You will adhere to the rules and policies of the company existing or all those which may come into force in future. "
							+ "Extend cooperation to your colleagues in the execution of jobs and follow the instructions given by your superiors."
							+ " A detail of other conditions will be provided at the time of confirmation. In the event of any situation not specified "
							+ "in the above terms and conditions, the management’s decision will be bound to you." + "");

			XWPFParagraph paragraphTermination3 = document.createParagraph();
			paragraphTermination3.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runTermination3 = paragraphTermination3.createRun();
			runTermination3.setText(""
					+ "We welcome you to the company and look forward to your participation in making the activities of the company an outstanding success.");

			XWPFParagraph paragraphTermination4 = document.createParagraph();
			paragraphTermination4.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runTermination4 = paragraphTermination4.createRun();
			runTermination4.setText(""
					+ "You are requested to treat this appointment letter as a confidential document. Please sign and return the duplicate copy of this letter in"
					+ " token of acceptance of the terms and conditions mentioned above.");
			// For WFD Labs PVT.LTD
			XWPFParagraph paragraphForWFDLabsPVTLTD = document.createParagraph();
			paragraphForWFDLabsPVTLTD.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runForWFDLabsPVTLTD = paragraphForWFDLabsPVTLTD.createRun();
			runForWFDLabsPVTLTD.setBold(true);
			runForWFDLabsPVTLTD.setUnderline(UnderlinePatterns.SINGLE);
			runForWFDLabsPVTLTD.setText("For WFD Labs PVT.LTD:" + "\n");
			// Human Resources
			XWPFParagraph paragraphHumanResources = document.createParagraph();
			paragraphHumanResources.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runHumanResources = paragraphHumanResources.createRun();
			runHumanResources.setBold(true);
			runHumanResources.setUnderline(UnderlinePatterns.SINGLE);
			runHumanResources.setText("Human Resources:" + "\n");

			XWPFParagraph paragraphHumanResources1 = document.createParagraph();
			paragraphHumanResources1.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runHumanResources1 = paragraphHumanResources1.createRun();
			runHumanResources1.setText(
					"I have read the terms and conditions of this letter of appointment and confirm my acceptance of the same.");
			// Accepted
			XWPFParagraph paragraphAccepted = document.createParagraph();
			paragraphAccepted.setAlignment(ParagraphAlignment.BOTH);
			XWPFRun runAccepted = paragraphAccepted.createRun();
			runAccepted.setBold(true);
			runAccepted.setText("Accepted:");
			runAccepted.setText("Date:");
		  
		  // create footer start
		  XWPFFooter footer = headerFooterPolicy.createFooter(XWPFHeaderFooterPolicy.DEFAULT);

		  paragraph = footer.createParagraph();
		  paragraph.setAlignment(ParagraphAlignment.CENTER);

		  run = paragraph.createRun();  
		  run.setText("The Footer:");


		  document.write(new FileOutputStream("E:/prasad.docx"));
		return null;

			//return null;

		}

		
	@RequestMapping(value = { "/offerLetter" }, method = RequestMethod.GET)
	public void generateOfferLetter() throws IOException {

		XWPFDocument document = new XWPFDocument();
		XWPFParagraph paragraphMr = document.createParagraph();
		paragraphMr.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runMr = paragraphMr.createRun();
		runMr.setBold(true);
		runMr.setText("Mr.");

		XWPFParagraph paragraphDate = document.createParagraph();
		paragraphDate.setAlignment(ParagraphAlignment.RIGHT);
		XWPFRun runDate = paragraphDate.createRun();
		runDate.setText("\r\n" + "Date :" + "");

		XWPFParagraph paragraphPlace = document.createParagraph();
		paragraphPlace.setAlignment(ParagraphAlignment.RIGHT);
		XWPFRun runPlace = paragraphPlace.createRun();
		runPlace.setText("Banglore");

		XWPFParagraph paragraphSubject = document.createParagraph();
		paragraphSubject.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runSubject = paragraphSubject.createRun();
		runSubject.setBold(true);
		runSubject.setText("\r\n" + "Subject: OFFER OF EMOPLOYMENT	\n");
// Role And Date of Joining
		XWPFParagraph paragraph1 = document.createParagraph();
		paragraph1.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun run1 = paragraph1.createRun();
		run1.setText("Dear  Ashok");
		XWPFParagraph paragraph1a = document.createParagraph();
		paragraph1a.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun run1a = paragraph1a.createRun();
		run1a.setText("\r\n"
				+ "With reference to your application and the subsequent interview that you had with us on 05th "
				+ "September 2018 for employment in our company, we are pleased to appoint you as “Associate Software"
				+ " Engineer” on following terms and conditions.\r\n");
//Date Of joining Paragraph
		XWPFParagraph paragraph1b = document.createParagraph();
		paragraph1b.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun run1b = paragraph1b.createRun();
		run1b.setBold(true);
		run1b.setUnderline(UnderlinePatterns.SINGLE);
		run1b.setText("Date Of Joining");
		XWPFParagraph paragraph1c = document.createParagraph();
		paragraph1c.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun run1c = paragraph1c.createRun();
		run1c.setText("\r\n"
				+ "This appointment letter is valid for your joining on or before 5thSeptember 2018. In case of your "
				+ "not complying this, the appointment would be treated as cancelled.\r\n");
// Medica Fitness Paragraph
		XWPFParagraph paragraphMedical = document.createParagraph();
		paragraphMedical.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runMedical = paragraphMedical.createRun();
		runMedical.setBold(true);
		runMedical.setUnderline(UnderlinePatterns.SINGLE);
		runMedical.setText("Medical Fitness" + "\n");
		XWPFParagraph paragraphMedical1 = document.createParagraph();
		paragraphMedical1.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runMedical1 = paragraphMedical1.createRun();
		runMedical1.setText("\r\n"
				+ "The appointment is valid only in case of your being found medically fit to perform your duties by"
				+ " the registered Medical Practitioner authorized by the Company. Further, your fitness for the job"
				+ " is subject to periodical medical examinations by the company.\r\n");
//Certificate / Testimonals Paragraph	
		XWPFParagraph paragraphCerificate = document.createParagraph();
		paragraphCerificate.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runCertificate = paragraphCerificate.createRun();
		runCertificate.setBold(true);
		runCertificate.setUnderline(UnderlinePatterns.SINGLE);
		runCertificate.setText("Certificate / Testimonials:");
		XWPFParagraph paragraphCerificate1 = document.createParagraph();
		paragraphCerificate1.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runCertificate1 = paragraphCerificate1.createRun();
		runCertificate1.setText("\r\n"
				+ "The appointment is further subject to your providing documented proofs about details mentioned in"
				+ " the Application form by you and information provided by you during interviews with the management. This includes;\r\n");
		XWPFParagraph paragraphCerificate2 = document.createParagraph();
		paragraphCerificate2.setAlignment(ParagraphAlignment.CENTER);
		paragraphCerificate2.setAlignment(ParagraphAlignment.NUM_TAB);
		XWPFRun runCertificate2 = paragraphCerificate2.createRun();
		runCertificate2.setText(
				"\r\n" + "Certificates of educational qualifications and any other professional qualifications.");
		runCertificate2.setText("\r\n"
				+ "Certificates from the previous employee(s) regarding position held, emoluments earned general conduct"
				+ " during employment, reason and date of leaving the previous employer / organization.\r\n");
// Probation period Paragraph
		XWPFParagraph paragraphProbation = document.createParagraph();
		paragraphProbation.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runProbation = paragraphProbation.createRun();
		runProbation.setBold(true);
		runProbation.setUnderline(UnderlinePatterns.SINGLE);
		runProbation.setText("\r\n" + "Probation period:\r\n");
		XWPFParagraph paragraphProbation1 = document.createParagraph();
		paragraphProbation1.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runProbation1 = paragraphProbation1.createRun();
		runProbation1
				.setText("The period of first six months from your joining duty will be considered as Probation period."
						+ " During this period you are required to get yourself acquainted to the job. At the end of this "
						+ "period your performance will be reviewed. Satisfactory performance may lead to confirmation of"
						+ " your services with the company and unsatisfactory performance can lead to extension of probation "
						+ "period for another three months or cessation of your employment. This will be at sole discretion of"
						+ " the management. Your probation period would be considered to be extended if you are intimated in"
						+ " writing about confirmation of your services.");
//Remuneration Paragraph		
		XWPFParagraph paragraphRemuneration = document.createParagraph();
		paragraphRemuneration.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runRemuneration = paragraphRemuneration.createRun();
		runRemuneration.setBold(true);
		runRemuneration.setUnderline(UnderlinePatterns.SINGLE);
		runRemuneration.setText("Remuneration:\r\n");
		XWPFParagraph paragraphRemuneration1 = document.createParagraph();
		paragraphRemuneration1.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runRemuneration1 = paragraphRemuneration1.createRun();
		runRemuneration1.setText("Your annual Remuneration will be as described below:\r\n");

// Creating table
		XWPFTable table = document.createTable();
		// create first row
		XWPFTableRow tableRowOne = table.getRow(0);
		tableRowOne.getCell(0).setText("Basic");
		tableRowOne.addNewTableCell().setText("1,20,000");
		// create second row
		XWPFTableRow tableRowTwo = table.createRow();
		tableRowTwo.getCell(0).setText("HRA");
		tableRowTwo.getCell(1).setText("000");
		// create Third row
		XWPFTableRow tableRowThree = table.createRow();
		tableRowThree.getCell(0).setText("Allowance");
		tableRowThree.getCell(1).setText("000");
		// create four row
		XWPFTableRow tableRowFour = table.createRow();
		tableRowFour.getCell(0).setText("CCA");
		tableRowFour.getCell(1).setText("000");
		// create Five row
		XWPFTableRow tableRowFive = table.createRow();
		tableRowFive.getCell(0).setText("Medical");
		tableRowFive.getCell(1).setText("000");
		// create Six row
		XWPFTableRow tableRowSix = table.createRow();
		tableRowSix.getCell(0).setText("CONVEYANCE");
		tableRowSix.getCell(1).setText("000");
		// create Seven row
		XWPFTableRow tableRowSeven = table.createRow();
		tableRowSeven.getCell(0).setText("Total");
		tableRowSeven.getCell(1).setText("000");

		// Working Hours and Weekly Off
		XWPFParagraph paragraphWorkingHours = document.createParagraph();
		paragraphWorkingHours.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runWorkingHours = paragraphWorkingHours.createRun();
		runWorkingHours.setBold(true);
		runWorkingHours.setUnderline(UnderlinePatterns.SINGLE);
		runWorkingHours.setText("Working Hours and Weekly Off:" + "\n");
		XWPFParagraph paragraphWorkingHours1 = document.createParagraph();
		paragraphWorkingHours1.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runWorkingHours1 = paragraphWorkingHours1.createRun();
		runWorkingHours1.setText("\r\n"
				+ "You will attend your duties and discharge the responsibilities entrusted upon you as per the "
				+ "working hours scheduled by the management for your department or functional area."
				+ " The schedules for working hours and weekly off authorized by superiors will have to be compiled all the time."
				+ " Such schedules are subject to changes and modifications depending upon exigency of work. You may be transferred "
				+ "from one shift to another as and when need arises and also you may be required to work for extra hours keeping in view "
				+ "the urgency of  work as deemed necessary by your superiors." + " ");
		// Leave
		XWPFParagraph paragraphLeave = document.createParagraph();
		paragraphLeave.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runLeave = paragraphLeave.createRun();
		runLeave.setBold(true);
		runLeave.setUnderline(UnderlinePatterns.SINGLE);
		runLeave.setText("Leave:" + "\n");
		XWPFParagraph paragraphLeave1 = document.createParagraph();
		paragraphLeave1.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runLeave1 = paragraphLeave1.createRun();
		runLeave1.setText("\r\n"
				+ "You will be entitled to a number of working days for a calendar year comprising of 12 casual Leaves."
				+ " This distribution and entitlement is subjected to change. Entitlement and utilization of earned "
				+ "Leave will be governed by the Factories Act. Entitlement of Leave is not the right to leave. Advance"
				+ " approval / sanction of superiors and reporting authority is to be obtained before availing any leave."
				+ " Remaining absent from duty without sanctioned leave will be treated as unauthorized leave." + " ");
		// Transfer
		XWPFParagraph paragraphTransfer = document.createParagraph();
		paragraphTransfer.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runTransfer = paragraphTransfer.createRun();
		runTransfer.setBold(true);
		runTransfer.setUnderline(UnderlinePatterns.SINGLE);
		runTransfer.setText("Leave:" + "\n");
		XWPFParagraph paragraphTransfer1 = document.createParagraph();
		paragraphTransfer1.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runTransfer1 = paragraphTransfer1.createRun();
		runTransfer1.setText("\r\n"
				+ "Your employment is liable from one department to another or from one unit / office / plant / site / location"
				+ " of the company whether existing or which may come in existence in future anywhere across the country."
				+ "");
		XWPFParagraph paragraphTransfer2 = document.createParagraph();
		paragraphTransfer2.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runTransfer2 = paragraphTransfer2.createRun();
		runTransfer2.setText(
				"On all such transfers, the conditions of services and rules and regulations applicable at the place of\"\r\n"
						+ "transfer will be application to you." + "");
		// Secrecy
		XWPFParagraph paragraphSecrecy = document.createParagraph();
		paragraphSecrecy.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runSecrecy = paragraphSecrecy.createRun();
		runSecrecy.setBold(true);
		runSecrecy.setUnderline(UnderlinePatterns.SINGLE);
		runSecrecy.setText("Secrecy:" + "\n");
		XWPFParagraph paragraphSecrecy1 = document.createParagraph();
		paragraphSecrecy1.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runSecrecy1 = paragraphSecrecy.createRun();
		runSecrecy1.setText("\r\n"
				+ "A complete secrecy will have to be observed by you on all company matters including Security arrangements,"
				+ " Technical know-how, and Financial and Administration matters. And shall not divulge or be responsible for "
				+ "divulging any secret of the company to any person(s) during your employment and afterwards. Any breach of "
				+ "this condition on your part shall be enough to terminate your services from the company with immediate effect."
				+ "");
		// Safe up-keeping of company’s property
		XWPFParagraph paragraphSafeUpKeeping = document.createParagraph();
		paragraphSafeUpKeeping.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runSafeUpKeeping = paragraphSafeUpKeeping.createRun();
		runSafeUpKeeping.setBold(true);
		runSafeUpKeeping.setUnderline(UnderlinePatterns.SINGLE);
		runSecrecy.setText("Safe up-keeping of company’s property:" + "\n");
		XWPFParagraph paragraphSafeUpKeeping1 = document.createParagraph();
		paragraphSafeUpKeeping.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runSafeUpKeeping1 = paragraphSafeUpKeeping1.createRun();
		runSafeUpKeeping1.setText("\r\n"
				+ "Safe up-keeping and return in good conditions and order of all the company’s property such as tools, equipment’s,"
				+ " instruments, uniform, literature etc. in your use / custody / care / charge will have to be observed by you."
				+ " Accountability of any such goods or literatures etc., provided to you for official purpose will be yours. "
				+ "On completion of work or assignment or at the terminate or cessation of employment, you will return all such "
				+ "properties allotted to you to your reporting authority with record.");
		// Termination
		XWPFParagraph paragraphTermination = document.createParagraph();
		paragraphTermination.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runTermination = paragraphTermination.createRun();
		runTermination.setBold(true);
		runTermination.setUnderline(UnderlinePatterns.SINGLE);
		runTermination.setText("Termination:" + "\n");

		XWPFParagraph paragraphTermination1 = document.createParagraph();
		paragraphTermination1.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runTermination1 = paragraphTermination1.createRun();
		runTermination1.setText(
				"Your employment with the company can be terminated by the management with immediate effect without assigning "
						+ "any reason whatsoever during the training or probationary period of your services. Any breach of trust on your"
						+ " part will be liable for termination of your services with 30 days’ notice period. After confirmation, your services"
						+ " can be terminated by notice pay in lieu of notice period." + "");

		XWPFParagraph paragraphTermination2 = document.createParagraph();
		paragraphTermination2.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runTermination2 = paragraphTermination2.createRun();
		runTermination2.setText(
				"You will adhere to the rules and policies of the company existing or all those which may come into force in future. "
						+ "Extend cooperation to your colleagues in the execution of jobs and follow the instructions given by your superiors."
						+ " A detail of other conditions will be provided at the time of confirmation. In the event of any situation not specified "
						+ "in the above terms and conditions, the management’s decision will be bound to you." + "");

		XWPFParagraph paragraphTermination3 = document.createParagraph();
		paragraphTermination3.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runTermination3 = paragraphTermination3.createRun();
		runTermination3.setText(""
				+ "We welcome you to the company and look forward to your participation in making the activities of the company an outstanding success.");

		XWPFParagraph paragraphTermination4 = document.createParagraph();
		paragraphTermination4.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runTermination4 = paragraphTermination4.createRun();
		runTermination4.setText(""
				+ "You are requested to treat this appointment letter as a confidential document. Please sign and return the duplicate copy of this letter in"
				+ " token of acceptance of the terms and conditions mentioned above.");
		// For WFD Labs PVT.LTD
		XWPFParagraph paragraphForWFDLabsPVTLTD = document.createParagraph();
		paragraphForWFDLabsPVTLTD.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runForWFDLabsPVTLTD = paragraphForWFDLabsPVTLTD.createRun();
		runForWFDLabsPVTLTD.setBold(true);
		runForWFDLabsPVTLTD.setUnderline(UnderlinePatterns.SINGLE);
		runForWFDLabsPVTLTD.setText("For WFD Labs PVT.LTD:" + "\n");
		// Human Resources
		XWPFParagraph paragraphHumanResources = document.createParagraph();
		paragraphHumanResources.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runHumanResources = paragraphHumanResources.createRun();
		runHumanResources.setBold(true);
		runHumanResources.setUnderline(UnderlinePatterns.SINGLE);
		runHumanResources.setText("Human Resources:" + "\n");

		XWPFParagraph paragraphHumanResources1 = document.createParagraph();
		paragraphHumanResources1.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runHumanResources1 = paragraphHumanResources1.createRun();
		runHumanResources1.setText(
				"I have read the terms and conditions of this letter of appointment and confirm my acceptance of the same.");
		// Accepted
		XWPFParagraph paragraphAccepted = document.createParagraph();
		paragraphAccepted.setAlignment(ParagraphAlignment.BOTH);
		XWPFRun runAccepted = paragraphAccepted.createRun();
		runAccepted.setBold(true);
		runAccepted.setText("Accepted:");
		runAccepted.setText("Date:");

		// Write the Document in file system
		FileOutputStream out = new FileOutputStream(new File("E:\\Ashokg.docx"));
		document.write(out);
		out.close();
		System.out.println("createdocument.docx written successully");
	}
}
