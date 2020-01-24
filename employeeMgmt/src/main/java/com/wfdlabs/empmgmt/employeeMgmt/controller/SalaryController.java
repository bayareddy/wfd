package com.wfdlabs.empmgmt.employeeMgmt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.poi.hssf.record.chart.UnitsRecord;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
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
import com.wfdlabs.empmgmt.employeeMgmt.entity.Salary;
import com.wfdlabs.empmgmt.employeeMgmt.service.SalaryService;

@RestController
@RequestMapping("/salary")
public class SalaryController {

	@Autowired
	SalaryService salaryService;

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Salary> createSalary(@RequestBody Salary salary) {
		salary.setUpdateDate(null);
		salary = salaryService.createSalary(salary);
		return new ResponseEntity<>(salary, HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Salary> getSalary(@RequestParam Integer id) {
		Salary salary = null;
		boolean noElementFlag = false;
		try {
			salary = salaryService.getSalary(id);
		} catch (NoSuchElementException nsee) {
			noElementFlag = true;
		}
		if (noElementFlag || salary == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(salary, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ResponseEntity<List<Salary>> getAllSalary() {
		List<Salary> salaryList = salaryService.getAllSalary();
		return new ResponseEntity<>(salaryList, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity deleteSalary(@RequestParam Integer id) {
		salaryService.deleteSalary(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Salary> updateSalary(@RequestBody Salary salary) {
		salary = salaryService.updateSalary(salary);
		return new ResponseEntity<>(salary, HttpStatus.OK);
	}

	@RequestMapping(value = "/generateWordDoc", method = RequestMethod.GET, produces = "application/Word")
	public ResponseEntity<byte[]> getWord() throws IOException, XmlException, InvalidFormatException {

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

		
		  File img = new File("E://wfdlab.jpg");
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
		FileOutputStream out = new FileOutputStream(new File("E:\\Ashok.docx"));
		document.write(out);
		out.close();
		System.out.println("createdocument.docx written successully");
	}

}
