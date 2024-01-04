package mypackage3;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private LinkedHashMap<String, String> countryOptions;
	private String language;
	private LinkedHashMap<String, String> languageOptions;
	private String[] checkboxes;
	private LinkedHashMap<String, String> checkboxesOptions;
	public Student()
	{
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("c1", "country1");
		countryOptions.put("c2", "country2");
		countryOptions.put("c3", "country3");
		
		languageOptions = new LinkedHashMap<>();
		languageOptions.put("l1", "language1");
		languageOptions.put("l2", "language2");
		languageOptions.put("l3", "language3");
		
		checkboxesOptions = new LinkedHashMap<>();
		checkboxesOptions.put("cb1", "checkboxes1");
		checkboxesOptions.put("cb2", "checkboxes2");
		checkboxesOptions.put("cb3", "checkboxes3");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public LinkedHashMap<String, String> getLanguageOptions() {
		return languageOptions;
	}

	public String[] getCheckboxes() {
		return checkboxes;
	}

	public void setCheckboxes(String[] checkboxes) {
		this.checkboxes = checkboxes;
	}

	public LinkedHashMap<String, String> getCheckboxesOptions() {
		return checkboxesOptions;
	}
}
