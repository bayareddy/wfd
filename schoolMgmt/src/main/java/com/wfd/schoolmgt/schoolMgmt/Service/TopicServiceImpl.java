/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfd.schoolmgt.schoolMgmt.Entity.Topic;
import com.wfd.schoolmgt.schoolMgmt.Repository.TopicRepository;

/**
 * @author Nithin
 *
 */
@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	TopicRepository topicRepository;

	/**
	 * This method is used to create Topic Details
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public Topic createTopic(Topic pTopic) {

		return topicRepository.save(pTopic);
	}

	/**
	 * This method is used to get Topic Details
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public Topic getTopic(Integer topicId) {

		return topicRepository.findById(topicId).get();
	}

	/**
	 * This method is used to update Topic Details
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public Topic updateTopic(Topic pTopic) {

		return topicRepository.save(pTopic);
	}

	/**
	 * This method is used to Delete Topic Details
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public String deleteTopic(Integer topicId) {
		topicRepository.deleteById(topicId);
		return "Topic Deleted";
	}

}
