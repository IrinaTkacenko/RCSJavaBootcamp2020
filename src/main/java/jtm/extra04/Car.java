package jtm.extra04;

import org.json.JSONString;
import java.util.Locale;

public class Car implements JSONString{

	private String model;
	private Integer year;
	private String color;
	private Float price;

	// TODO #1 generate public constructor which takes all properties of an
	// object as parameters

	public Car(String model, Integer year, String color, Float price) {
		this.model = model;
		this.year = year;
		this.color = color;
		this.price = price;
	}

	// TODO #2 generate public getters of all object properties
	public String getModel() {
		return model;
	}

	public Integer getYear() {
		return year;
	}

	public String getColor() {
		return color;
	}

	public Float getPrice() {
		return price;
	}

	@Override
	public String toJSONString() {
		return "{\"model\":" + "\"" + model + "\"" + "," +
				"\"year\":" + year + "," +
				"\"color\":" + "\"" + color + "\"" + "," +
				"\"price\":" + String.format(Locale.US, "%.0f", price) + "}";
	}
}
