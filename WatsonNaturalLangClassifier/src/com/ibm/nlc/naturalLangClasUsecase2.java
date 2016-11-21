/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.ibm.nlc;

import com.ibm.apitester.APIResponse;
import com.ibm.conversation.watsonConversation;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ClassifiedClass;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.parser.ParseException;

public class naturalLangClasUsecase2 {
	String userId = "3c6dbc77-9d0d-4a8f-89b6-19522d64e45b";
	String password = "gHRskEK0PogN";
	String filePath = "C:\\Users\\IBM_ADMIN\\Desktop\\sunil\\WatsonApi\\NLC\\test.csv";
	String classifyId = "2a3173x97-nlc-2864";
	String tempAnswer = "please enter valid question.";
	HashMap<String, String> hm = null;

	public String nlc(String Question, HashMap<String, String> hm) throws IOException, ParseException
  {
    try
    {
      NaturalLanguageClassifier service = new NaturalLanguageClassifier();
      service.setUsernameAndPassword(this.userId, this.password);

      Classification classification = (Classification)service.classify(this.classifyId, Question).execute();

      ArrayList classesList = new ArrayList();
      classesList = (ArrayList)classification.getClasses();

      if (((String)hm.get("flag")).equals("true")) {
        String Entity = (String)hm.get("Entity");
        if ((Entity != null) && (Entity != "")) {
          APIResponse oms = new APIResponse();
          this.tempAnswer = oms.getResponse(Question.trim(), Entity);
          hm.put("flag", "flase");
          }
      }
      if (classesList.size() > 0)
      {
        double firstConfidence = ((ClassifiedClass)classesList.get(0)).getConfidence().doubleValue();

        if (firstConfidence > 0.5D) {
          String firstClassName = ((ClassifiedClass)classesList.get(0)).getName();
          System.out.println(firstClassName);

          if (firstClassName.equals("ItemAvailability")) {
            this.tempAnswer = "Please enter the item name to check the avaliability.";
            hm.put("flag", "true");
            hm.put("Entity", "ItemAvailability");
          }
          else if (firstClassName.equals("OrderStatus")) {
            this.tempAnswer = "please type in the exact order#";
            hm.put("flag", "true");
            hm.put("Entity", "OrderStatus");
          }
          else if (firstClassName.equals("ItemSearch")) {
            this.tempAnswer = "Provide me the item name.";
            hm.put("flag", "true");
            hm.put("Entity", "ItemSearch");
          }
          else {
            watsonConversation conversation = new watsonConversation();
            this.tempAnswer = conversation.Conversion(Question);
          }
        }
        else
        {
          watsonConversation conversation = new watsonConversation();
          this.tempAnswer = conversation.Conversion(Question);
        }
      }
    }
    catch (Exception e) {
      return e.getMessage();
    }

    label351: return this.tempAnswer;
  }
}