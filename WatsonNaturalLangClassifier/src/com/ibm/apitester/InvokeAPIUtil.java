/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.ibm.apitester;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;

public class InvokeAPIUtil {
	public String callApi(HashMap<?, ?> inpMap) throws Exception {
		String IPAddr = (String) inpMap.get("IPPORT");
		String ContxtRoot = (String) inpMap.get("CTXROOT");
		String InpXml = (String) inpMap.get("INPXML");
		String TempXml = (String) inpMap.get("TEMPXML");
		String APIname = (String) inpMap.get("APINAME");
		String Username = (String) inpMap.get("UNAME");
		String Password = (String) inpMap.get("PASS");
		URL url = new URL("http://" + IPAddr + "/" + ContxtRoot + "/interop/InteropHttpServlet");

		URLConnection connection = url.openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setUseCaches(false);

		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.setRequestProperty("Referer",
				"http://" + IPAddr + "/" + ContxtRoot + "/yfshttpapi/yantrahttpapitester.jsp");
		connection.setRequestProperty("Connection", "keep-alive");
		DataOutputStream printout = new DataOutputStream(connection.getOutputStream());

		String content = "YFSEnvironment.progId=" + URLEncoder.encode("SterlingHttpTester") + "&InteropApiName="
				+ URLEncoder.encode(APIname) + "&IsFlow=" + URLEncoder.encode("N") + "&ServiceName="
				+ URLEncoder.encode("") + "&ApiName=" + URLEncoder.encode(APIname) + "&YFSEnvironment.userId="
				+ URLEncoder.encode(Username) + "&YFSEnvironment.password=" + URLEncoder.encode(Password)
				+ "&YFSEnvironment.version=" + URLEncoder.encode("") + "&YFSEnvironment.locale=" + URLEncoder.encode("")
				+ "&InteropApiData=" + URLEncoder.encode(InpXml) + "&TemplateData=" + URLEncoder.encode(TempXml)
				+ "&Content-Type=" + URLEncoder.encode("application/x-www-form-urlencoded");

		printout.writeBytes(content);
		printout.flush();
		printout.close();

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		String realOut = "";
		String decodedString;
		while ((decodedString = in.readLine()) != null) {
			if (!(decodedString.isEmpty()))
				realOut = decodedString;
		}
		in.close();
		return realOut;
	}
}