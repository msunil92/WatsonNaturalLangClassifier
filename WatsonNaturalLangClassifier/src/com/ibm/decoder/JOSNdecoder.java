/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.ibm.decoder;

import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JOSNdecoder {
	JSONObject obj = new JSONObject();
	String res = null;

	public JOSNdecoder(MessageResponse res) {
		this.res = res.toString();
	}

	public String retriveAttributeValue(String attributeName) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(this.res);
		JSONObject structure = (JSONObject) jsonObject.get("output");
		JSONArray outputText = (JSONArray) structure.get(attributeName);
		String output = (String) outputText.get(0);
		return output;
	}
}