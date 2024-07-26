package org.sample;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileRead {

	public static void main(String[] args) throws IOException, ParseException {

		FileReader reader = new FileReader("D:\\JanBatch\\TestingProject\\src\\test\\resources\\Sample2.json");
		JSONParser parser = new JSONParser();
		Object parse = parser.parse(reader);

		JSONObject obj = (JSONObject) parse;

		String s1 = obj.get("page").toString();
		System.out.println(s1);

		String s2 = obj.get("per_page").toString();
		System.out.println(s2);

		String s3 = obj.get("total").toString();
		System.out.println(s3);

		String s4 = obj.get("total_pages").toString();
		System.out.println(s4);

		Object object = obj.get("support");

		JSONObject obj2 = (JSONObject) object;

		String s5 = obj2.get("url").toString();
		System.out.println(s5);

		String s6 = obj2.get("text").toString();
		System.out.println(s6);
		
		// We need to typecast JSONObject to JSONArray
		
		Object object1 = obj.get("data");
		
		JSONArray arr = (JSONArray) object1;

		// Getting objects of 1st element in array
		Object object2 = arr.get(0);

		JSONObject obj3 = (JSONObject) object2;

		String aE1S1 = obj3.get("id").toString();
		int aE1Id = Integer.parseInt(aE1S1);
		System.out.println(aE1Id);

		String aE1S2 = obj3.get("email").toString();
		System.out.println(aE1S2);

		String aE1S3 = obj3.get("first_name").toString();
		System.out.println(aE1S3);

		String aE1S4 = obj3.get("last_name").toString();
		System.out.println(aE1S4);

		String aE1S5 = obj3.get("avatar").toString();
		System.out.println(aE1S5);

		// Getting objects of 2nd element in array
		Object object3 = arr.get(1);

		JSONObject obj4 = (JSONObject) object3;

		String aE2S1 = obj4.get("id").toString();
		int aE2Id = Integer.parseInt(aE2S1);
		System.out.println(aE2Id);

		String aE2S2 = obj4.get("email").toString();
		System.out.println(aE2S2);

		String aE2S3 = obj4.get("first_name").toString();
		System.out.println(aE2S3);

		String aE2S4 = obj4.get("last_name").toString();
		System.out.println(aE2S4);

		String aE2S5 = obj4.get("avatar").toString();
		System.out.println(aE2S5);

		// Getting objects of 3rd element in array
		Object object4 = arr.get(2);

		JSONObject obj5 = (JSONObject) object4;

		String aE3S1 = obj5.get("id").toString();
		int aE3Id = Integer.parseInt(aE3S1);
		System.out.println(aE3Id);

		String aE3S2 = obj5.get("email").toString();
		System.out.println(aE3S2);

		String aE3S3 = obj5.get("first_name").toString();
		System.out.println(aE3S3);

		String aE3S4 = obj5.get("last_name").toString();
		System.out.println(aE3S4);

		String aE3S5 = obj5.get("avatar").toString();
		System.out.println(aE3S5);

		// Getting objects of 4th element in array
		Object object5 = arr.get(3);

		JSONObject obj6 = (JSONObject) object5;

		String aE4S1 = obj6.get("id").toString();
		int aE4Id = Integer.parseInt(aE4S1);
		System.out.println(aE4Id);

		String aE4S2 = obj6.get("email").toString();
		System.out.println(aE4S2);

		String aE4S3 = obj6.get("first_name").toString();
		System.out.println(aE4S3);

		String aE4S4 = obj6.get("last_name").toString();
		System.out.println(aE4S4);

		String aE4S5 = obj6.get("avatar").toString();
		System.out.println(aE4S5);

		// Getting objects of 5th element in array
		Object object6 = arr.get(4);

		JSONObject obj7 = (JSONObject) object6;

		String aE5S1 = obj7.get("id").toString();
		int aE5Id = Integer.parseInt(aE5S1);
		System.out.println(aE5Id);

		String aE5S2 = obj7.get("email").toString();
		System.out.println(aE5S2);

		String aE5S3 = obj7.get("first_name").toString();
		System.out.println(aE5S3);

		String aE5S4 = obj7.get("last_name").toString();
		System.out.println(aE5S4);

		String aE5S5 = obj7.get("avatar").toString();
		System.out.println(aE5S5);

		// Getting objects of 6th element in array
		Object object7 = arr.get(5);

		JSONObject obj8 = (JSONObject) object7;

		String aE6S1 = obj8.get("id").toString();
		int aE6Id = Integer.parseInt(aE6S1);
		System.out.println(aE6Id);

		String aE6S2 = obj8.get("email").toString();
		System.out.println(aE6S2);

		String aE6S3 = obj8.get("first_name").toString();
		System.out.println(aE6S3);

		String aE6S4 = obj8.get("last_name").toString();
		System.out.println(aE6S4);

		String aE6S5 = obj8.get("avatar").toString();
		System.out.println(aE6S5);

	}

}
