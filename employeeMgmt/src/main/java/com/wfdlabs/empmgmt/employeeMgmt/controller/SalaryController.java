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

	
}
