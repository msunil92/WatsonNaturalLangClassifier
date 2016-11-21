/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.ibm.conversation;

import com.ibm.decoder.JOSNdecoder;
import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest.Builder;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class watsonConversation {
	public String Conversion(String questions) throws IOException, ParseException {
		String serviceid = "8153d0c3-de01-4474-8a2b-1b1cded5845c";
		String wsId = "1ef31e3b-3021-4343-888c-68b1b28c85f8";
		String servicepassword = "3rHa1X2xUUUE";
		String versiondate = "2016-09-21";

		ConversationService cs = new ConversationService(versiondate, serviceid, servicepassword);

		MessageRequest inputRequest = new MessageRequest.Builder().inputText(questions).build();

		MessageResponse response = (MessageResponse) cs.message(wsId, inputRequest).execute();
		JOSNdecoder jsonDecoder = new JOSNdecoder(response);

		String textOutput = jsonDecoder.retriveAttributeValue("text");
		return textOutput;
	}
}