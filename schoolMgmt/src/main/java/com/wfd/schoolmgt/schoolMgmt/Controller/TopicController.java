/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wfd.schoolmgt.schoolMgmt.Entity.Topic;
import com.wfd.schoolmgt.schoolMgmt.Service.TopicService;

/**
 * @author Nithin
 *
 */
@RequestMapping("/topic")
@RestController

public class TopicController {

	@Autowired
	TopicService topicService;

	/**
	 * This method is used to create topic Details
	 * 
	 * @param pAddress
	 * @return
	 */

	@RequestMapping(method = RequestMethod.POST)
	public Topic createTopic(@RequestBody Topic pTopic) {
		return topicService.createTopic(pTopic);
	}

	/**
	 * This method is used to get TopicDetails
	 * 
	 * @param pAddress
	 * @return
	 */

	@RequestMapping(value = "/{topicId}", method = RequestMethod.GET)
	public ResponseEntity<Topic> getTopic(@PathVariable Integer topicId) {
		Topic topic = null;
		Boolean noElementFound = false;
		try {
			topic = topicService.getTopic(topicId);
		} catch (NoSuchElementException nsee) {
			noElementFound = true;

		}
		if (noElementFound || topic == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(topic, HttpStatus.OK);
	}

	/**
	 * This method is used to Update topic Details
	 * 
	 * @param pAddress
	 * @return
	 */

	@RequestMapping(method = RequestMethod.PUT)
	public Topic updateTopic(@RequestBody Topic pTopic) {
		return topicService.updateTopic(pTopic);
	}

	/**
	 * This method is used to Delete topic Details
	 * 
	 * @param pAddress
	 * @return
	 */
	@RequestMapping(value = "/{topicId}", method = RequestMethod.DELETE)
	public String deleteTopic(@PathVariable Integer topicId) {
		return topicService.deleteTopic(topicId);
	}

}
