package org.sample;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONFile {

	public static void main(String[] args) throws IOException, ParseException {

		// FileReader --> Reading the file location
		FileReader reader = new FileReader("D:\\JanBatch\\TestingProject\\src\\test\\resources\\users_10k.json");

		// Creating Object for JSONParser --> From simple JSON dependency
		JSONParser parser = new JSONParser();

		// From JSONParser class there is a method called parse() --> pass the
		// FileReader ref

		Object parse = parser.parse(reader);

		// In Parse --> JSONFile
		// Inside JSONFile --> we have JSONObject, JSONArray

		// We need to typecast Object to JSONArray

		JSONArray arr = (JSONArray) parse;

		Object object = arr.get(9999);

		JSONObject obj = (JSONObject) object;

		// Default --> get() --> Return type will be Object
		// To convert into string we can use toString()
		
		String id = obj.get("id").toString();
		String name = obj.get("name").toString();
		String city = obj.get("city").toString();
		String age = obj.get("age").toString();

		System.out.println(id);
		System.out.println(name);
		System.out.println(city);
		System.out.println(age);

		Object object2 = obj.get("friends");

		JSONArray arr2 = (JSONArray) object2;

		Object object3 = arr2.get(0);

		JSONObject obj2 = (JSONObject) object3;

		String friendName = obj2.get("name").toString();
		System.out.println(friendName);

		Object object4 = obj2.get("hobbies");

		JSONArray arr3 = (JSONArray) object4;
		String friend1hobbies1 = arr3.get(0).toString();
		System.out.println(friend1hobbies1);
		String friend1hobbies2 = arr3.get(1).toString();
		System.out.println(friend1hobbies2);

		Object object5 = arr2.get(1);

		JSONObject obj3 = (JSONObject) object5;

		String friendName2 = obj3.get("name").toString();
		System.out.println(friendName2);

		Object object6 = obj3.get("hobbies");

		JSONArray arr4 = (JSONArray) object6;
		String friend2hobbies1 = arr4.get(0).toString();
		System.out.println(friend2hobbies1);
		String friend2hobbies2 = arr4.get(1).toString();
		System.out.println(friend2hobbies2);
		String friend2hobbies3 = arr4.get(2).toString();
		System.out.println(friend2hobbies3);
		
		Object object7 = arr2.get(2);

		JSONObject obj4 = (JSONObject) object7;

		String friendName3 = obj4.get("name").toString();
		System.out.println(friendName3);

		Object object8 = obj4.get("hobbies");

		JSONArray arr5 = (JSONArray) object8;
		String friend3hobbies1 = arr5.get(0).toString();
		System.out.println(friend3hobbies1);
		String friend3hobbies2 = arr5.get(1).toString();
		System.out.println(friend3hobbies2);
		String friend3hobbies3 = arr5.get(2).toString();
		System.out.println(friend3hobbies3);

//		String id = obj.get("id").toString();
//		String name = obj.get("name").toString();
//		String city = obj.get("city").toString();
//		String age = obj.get("age").toString();
//
//		System.out.println(id);
//		System.out.println(name);
//		System.out.println(city);
//		System.out.println(age);
//
//		Object object2 = obj.get("friends");
//
//		JSONArray arr2 = (JSONArray) object2;
//
//		Object object3 = arr2.get(0);
//
//		JSONObject obj2 = (JSONObject) object3;
//
//		String friendName = obj2.get("name").toString();
//		System.out.println(friendName);
//
//		Object object4 = obj2.get("hobbies");
//
//		JSONArray arr3 = (JSONArray) object4;
//		String friend1hobbies1 = arr3.get(0).toString();
//		System.out.println(friend1hobbies1);
//		String friend1hobbies2 = arr3.get(1).toString();
//		System.out.println(friend1hobbies2);
//		String friend1hobbies3 = arr3.get(2).toString();
//		System.out.println(friend1hobbies3);
//
//		Object object5 = arr2.get(1);
//
//		JSONObject obj3 = (JSONObject) object5;
//
//		String friendName2 = obj3.get("name").toString();
//		System.out.println(friendName2);
//
//		Object object6 = obj3.get("hobbies");
//
//		JSONArray arr4 = (JSONArray) object6;
//		String friend2hobbies1 = arr4.get(0).toString();
//		System.out.println(friend2hobbies1);
//		String friend2hobbies2 = arr4.get(1).toString();
//		System.out.println(friend2hobbies2);

	}

}
