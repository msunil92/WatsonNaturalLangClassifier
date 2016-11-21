/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.ibm.test;

import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifiers;
import java.io.File;
import java.io.PrintStream;

public class Test {
	public static void main(String[] args) {
		NaturalLanguageClassifier service = new NaturalLanguageClassifier();
		service.setUsernameAndPassword("3c6dbc77-9d0d-4a8f-89b6-19522d64e45b", "gHRskEK0PogN");

		Classifier classifier = (Classifier) service.createClassifier("My Classifier", "en", new File("./train.csv"))
				.execute();

		System.out.println(classifier);

		Classifiers classifiers = (Classifiers) service.getClassifiers().execute();
		System.out.println(classifiers);
		service.deleteClassifier("");

		Classifier classifieraa = (Classifier) service.getClassifier("2d7ac0x100-nlc-2565").execute();
		System.out.println(classifieraa);

		Classification classification = (Classification) service
				.classify("2d7ac0x100-nlc-2565", "will it be spring tomorrow?").execute();
		System.out.println(classification);
	}
}