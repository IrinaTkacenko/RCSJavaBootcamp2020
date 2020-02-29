package jtm.extra04;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;


public class JsonCars {

	/*- TODO #1
	 * Implement method, which returns list of cars from generated JSON string
	 */
	public List<Car> getCars(String jsonString){
		/*- HINTS:
		 * You will need to use:
		 * - https://stleary.github.io/JSON-java/org/json/JSONObject.html
		 * - https://stleary.github.io/JSON-java/org/json/JSONArray.html
		 */

		List<Car> someCars = new ArrayList<>();
		JSONObject jsonObject = new JSONObject(jsonString);
		String[] array = JSONObject.getNames(jsonObject);
		for (String field:array) {
			JSONArray jsonArray = new JSONArray(jsonObject.get(field).toString());
			for(int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonCar = new JSONObject(jsonArray.get(i).toString());
				String[] carFields = JSONObject.getNames(jsonCar);
				String[] orderedCarFields = new String[carFields.length];
				for(String carField:carFields) {
					switch (carField){
						case "model":
							orderedCarFields[0] = carField;
							break;
						case "year":
							orderedCarFields[1] = carField;
							break;
						case "color":
							orderedCarFields[2] = carField;
							break;
						case "price":
							orderedCarFields[3] = carField;
							break;
					}
				}
				someCars.add(new Car(jsonCar.getString(orderedCarFields[0]),jsonCar.getInt(orderedCarFields[1]),
						jsonCar.getString(orderedCarFields[2]),jsonCar.getFloat(orderedCarFields[3])));
			}
		}
		return someCars;
	}

	/*- TODO #2
	 * Implement method, which returns JSON String generated from list of cars
	 */
	public String getJson(List<Car> cars) {
		/*- HINTS:
		 * You will need to use:
		 * - https://docs.oracle.com/javase/8/docs/api/index.html?java/io/StringWriter.html
		 * - http://static.javadoc.io/org.json/json/20180130/index.html?org/json/JSONWriter.html
		 */
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		for(Car car:cars) {
			array.put(new Car(car.getModel(),car.getYear(),car.getColor(),car.getPrice()));
		}
		return object.put("cars", array).toString();
	}
}