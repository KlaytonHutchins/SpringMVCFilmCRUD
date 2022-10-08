package com.skilldistillery.film.entities;

import java.util.List;
import java.util.Objects;

public class Film {

	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private int languageId;
	private String languageName;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private String category;
	private List<Actor> actors;

	public Film() {
	}

	public Film(String title, int releaseYear, String rating, String description, String language) {
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.languageName = language;
	}

	public Film(int id, String title, String description, int releaseYear, String language, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, String specialFeatures, String category) {
		this(title, releaseYear, rating, description, language);
		this.id = id;
		this.languageName = language;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.specialFeatures = specialFeatures;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	
	public String getLanguage() {
		return languageName;
	}

	public void setLanguage(String language) {
		this.languageName = language;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actors, category, description, id, languageName, languageId, length, rating, releaseYear,
				rentalDuration, rentalRate, replacementCost, specialFeatures, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(category, other.category)
				&& Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(languageName, other.languageName) && languageId == other.languageId && length == other.length
				&& Objects.equals(rating, other.rating) && releaseYear == other.releaseYear
				&& rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Title: " + title + "\nRelease Year: " + releaseYear + "\nRating: " + rating + "\nDescription: "
				+ description + "\nLanguage: " + languageName + "\nCategory: " + category;
	}
	
	public String toStringMoreInfo() {
		return "\nId: " + id + "\n" + this
		+ "\nRental Duration: " + rentalDuration + "\nRental Rate: "
		+ rentalRate + "\nLength: " + length
		+ "\nReplacement Cost: " + replacementCost
		+ "\nSpecial Features: " + specialFeatures;
	}
	
}
