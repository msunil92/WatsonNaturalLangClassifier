/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.ibm.test;

import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier;
import java.io.File;
import java.io.PrintStream;
import java.util.List;

public class WatsonNLCDemo {
	String userId = "3c6dbc77-9d0d-4a8f-89b6-19522d64e45b";
	String password = "gHRskEK0PogN";
	NaturalLanguageClassifier service = null;

	public WatsonNLCDemo() {
		this.service = new NaturalLanguageClassifier();
		this.service.setUsernameAndPassword(this.userId, this.password);
	}

	public void createNewClassifier(String classifierId, String filePath) {
		Classifier classifier = (Classifier) this.service.createClassifier(classifierId, "en", new File(filePath))
				.execute();
		System.out.println(classifier);
	}

	public boolean checkActiveClassifier(String classifierId) {
		boolean flag = false;

		NaturalLanguageClassifier service = new NaturalLanguageClassifier();
		service.setUsernameAndPassword(this.userId, this.password);

		Classifier classifierStatusDesc = (Classifier) service.getClassifier(classifierId).execute();

		if (classifierStatusDesc.getStatusDescription()
				.equals("The classifier instance is now available and is ready to take classifier requests.")) {
			flag = true;
		}
		return flag;
	}

	public List getClassification(String classifierId, String Question) {
		Classification classification = (Classification) this.service.classify(classifierId, Question).execute();
		return classification.getClasses();
	}
}