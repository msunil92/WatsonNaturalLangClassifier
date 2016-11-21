/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.ibm.test;

import java.io.PrintStream;
import java.util.List;

public class naturalLangClassImplementation {
	public static void main(String[] args) {
		WatsonNLCDemo obj = new WatsonNLCDemo();

		if (!(obj.checkActiveClassifier("2d7ac0x100-nlc-2565")))
			return;
		List classificationList = obj.getClassification("2d7ac0x100-nlc-2565", "will it be spring tomorrow?");
		System.out.println(classificationList);
	}
}