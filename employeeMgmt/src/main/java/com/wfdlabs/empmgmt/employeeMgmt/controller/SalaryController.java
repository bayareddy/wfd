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
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlException;
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
		/*XWPFDocument document = new XWPFDocument();
		CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
		XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(document, sectPr);
		
		
		// write header content
		CTP ctpHeader = CTP.Factory.newInstance();
		CTR ctrHeader = ctpHeader.addNewR();
		CTText ctHeader = ctrHeader.addNewT();
		
		XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, document);
		XWPFRun run = headerParagraph.createRun();

		String headerText = "This is header";
		run = headerParagraph.createRun();
		String imgFile = "E:/Capture1.jpg";
		run.addPicture(new FileInputStream(imgFile), XWPFDocument.PICTURE_TYPE_JPEG, imgFile, Units.toEMU(50), Units.toEMU(50));
		ctHeader.setStringValue(headerText);
		
		
		XWPFParagraph[] parsHeader = new XWPFParagraph[1];
		parsHeader[0] = headerParagraph;
		policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);
		
		
		FileOutputStream out = new FileOutputStream("E:/prasad.docx");

		// write footer content
		CTP ctpFooter = CTP.Factory.newInstance();
		CTR ctrFooter = ctpFooter.addNewR();
		CTText ctFooter = ctrFooter.addNewT();
		String footerText = "This is footer";
		ctFooter.setStringValue(footerText);
		
		
		XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooter, document);
		XWPFParagraph[] parsFooter = new XWPFParagraph[1];
		parsFooter[0] = footerParagraph;
		policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);

		document.write(out);
		out.close();*/
	
	XWPFDocument doc= new XWPFDocument();

	  // the body content
	  XWPFParagraph paragraph = doc.createParagraph();
	  XWPFRun run=paragraph.createRun();  
	  run.setText("The Body:");

	  paragraph = doc.createParagraph();
	  run=paragraph.createRun();  
	  run.setText("Lorem ipsum....");

	  // create header start
	  CTSectPr sectPr = doc.getDocument().getBody().addNewSectPr();
	  XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(doc, sectPr);

	  XWPFHeader header = headerFooterPolicy.createHeader(XWPFHeaderFooterPolicy.DEFAULT);

	  paragraph = header.createParagraph();
	  paragraph.setAlignment(ParagraphAlignment.LEFT);

	  CTTabStop tabStop = paragraph.getCTP().getPPr().addNewTabs().addNewTab();
	  tabStop.setVal(STTabJc.RIGHT);
	  int twipsPerInch =  1440;
	  tabStop.setPos(BigInteger.valueOf(6 * twipsPerInch));

	  run = paragraph.createRun();  
	  run.setText("The Header:");
	  run.addTab();

	  run = paragraph.createRun(); 
	  String imgFile="E://Capture1.jpg";
	  run.addPicture(new FileInputStream(imgFile), XWPFDocument.PICTURE_TYPE_PNG, imgFile, Units.toEMU(50), Units.toEMU(50));


	  // create footer start
	  XWPFFooter footer = headerFooterPolicy.createFooter(XWPFHeaderFooterPolicy.DEFAULT);

	  paragraph = footer.createParagraph();
	  paragraph.setAlignment(ParagraphAlignment.CENTER);

	  run = paragraph.createRun();  
	  run.setText("The Footer:");


	  doc.write(new FileOutputStream("E:/prasad.docx"));
	return null;

		//return null;

	}

}
