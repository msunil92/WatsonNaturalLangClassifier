/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.ibm.apitester;

import java.io.PrintStream;
import java.util.HashMap;

public class APIResponse {
	public String getResponse(String Id, String Entity)
  {
    String resOut = "";
    HashMap hm = new HashMap();
    String INPXML = null;
    String TEMPXML = "";
    String output = "";
    try
    {
      InvokeAPIUtil ap = new InvokeAPIUtil();
      XMLDecoder decoder = new XMLDecoder();

      hm.put("IPPORT", "localhost:7001");
      hm.put("CTXROOT", "smcfs");
      hm.put("UNAME", "admin");
      hm.put("PASS", "password");
      hm.put("TEMPXML", TEMPXML);

      if (Entity.equals("OrderStatus")) {
        INPXML = "<Order OrderHeaderKey=\"" + Id + "\"/>";
        hm.put("INPXML", INPXML);
        hm.put("APINAME", "getOrderDetails");
        output = ap.callApi(hm);
        if (output.equals("</Errors>")) {
          System.out.println("Error");
          resOut = "<p style=\"color:red\">Please enter valid information or Id doesn't exists :( </p>";
        }
        resOut = decoder.Orderdecoder(output);

      }
      if (Entity.equals("ItemSearch")) {
        INPXML = "<Item ItemKey='" + Id + "' /> ";
        hm.put("INPXML", INPXML);
        hm.put("APINAME", "getItemDetails");
        output = ap.callApi(hm);
        if (output.equals("</Errors>")) {
          System.out.println("Error");
          resOut = "<span style=\"color:red\">Please enter valid information or Id doesn't exists :( </span>";
        }
        else {
          resOut = decoder.Itemdecoder(output);
        }
      }
    }
    catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
    label311: return resOut;
  }
}