package aepm;

import java.io.IOException;
import java.net.MalformedURLException;

public class AEPMGetMaster {
	private static String soapXml = "<?xml version=\"1.0\" encoding=\"utf-8\"?> " + 
			 "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\"> " + 
			 "   <soapenv:Header/> " + 
			 "   <soapenv:Body> " + 
			 "      <tem:GetMaster soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\"> " + 
			 "         <PartNumber xsi:type=\"xsd:string\">#</PartNumber> " + 
			 "      </tem:GetMaster> " + 
			 "   </soapenv:Body> " + 
			 "</soapenv:Envelope> ";
	
	
	public static String GetPartInfo(String[] args) {
		//test comment//
		
		String myString = soapXml;   
		
		myString = myString.replace("#", args[0]);
		
		java.net.URL url = null;
		try {
			url = new java.net.URL("http://enmiis01.global.nmhg.corp/AEPM_services/Services.svc");
		} catch (MalformedURLException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		java.net.URLConnection conn = null;
		try {
			conn = url.openConnection();
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		// Set the necessary header fields
		conn.setRequestProperty("SOAPAction", "http://tempuri.org/IServices/GetMaster");
		conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
		conn.setDoOutput(true);
		// Send the request
		java.io.OutputStreamWriter wr = null;
		try {
			wr = new java.io.OutputStreamWriter(conn.getOutputStream());
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			wr.write(myString);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			wr.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Read the response
		java.io.BufferedReader rd = null;
		try {
			rd = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = "";
		String wholeBundle = "";
		try {
			while ((line = rd.readLine()) != null) 
			{ 
				wholeBundle = wholeBundle + line; 
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wholeBundle;
		
	}

}
