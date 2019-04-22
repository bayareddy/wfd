/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Service;

import com.wfd.schoolmgt.schoolMgmt.Entity.Topic;

/**
 * @author Nithin
 *
 */
public interface TopicService {
	/**
	 * This method is used to create Topic Details
	 * 
	 * @param pAddress
	 * @return
	 */

	Topic createTopic(Topic pTopic);

	/**
	 * This method is used to get Topic Details
	 * 
	 * @param pAddress
	 * @return
	 */

	Topic getTopic(Integer topicId);

	/**
	 * This method is used to Update Topic Details
	 * 
	 * @param pAddress
	 * @return
	 */

	Topic updateTopic(Topic pTopic);

	/**
	 * This method is used to Delete Topic Details
	 * 
	 * @param pAddress
	 * @return
	 */

	String deleteTopic(Integer topicId);

}
