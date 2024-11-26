package com.desafio.agenciaviagem.entities;

import java.io.Serializable;
import java.util.Objects;

public class Destination implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
    private String name;
    private String location;
    private String description;
    private Double averageRating;
    private int totalRatings;
    private int ratingSum;
    
    public Destination() {
    }

	public Destination(Long id, String name, String location, String description, Double averageRating,
			int totalRatings, int ratingSum) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.description = description;
		this.averageRating = averageRating;
		this.totalRatings = totalRatings;
		this.ratingSum = ratingSum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

	public int getTotalRatings() {
		return totalRatings;
	}

	public void setTotalRatings(int totalRatings) {
		this.totalRatings = totalRatings;
	}

	public int getRatingSum() {
		return ratingSum;
	}

	public void setRatingSum(int ratingSum) {
		this.ratingSum = ratingSum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Destination other = (Destination) obj;
		return Objects.equals(id, other.id);
	}
    
}
