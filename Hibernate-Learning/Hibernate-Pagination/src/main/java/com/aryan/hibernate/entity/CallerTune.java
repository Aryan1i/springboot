package com.aryan.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;


@Entity
@Table(name = "CallerTune")
public class CallerTune {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int tuneId;
	private String tuneName;
	private String movieName;
	
	@Version
	private int count;

	public CallerTune(String tuneName, String movieName) {
		super();
		this.tuneName = tuneName;
		this.movieName = movieName;
	}

	public CallerTune() {
		
	}

	public int getTuneId() {
		return tuneId;
	}

	public void setTuneId(int tuneId) {
		this.tuneId = tuneId;
	}

	public String getTuneName() {
		return tuneName;
	}

	public void setTuneName(String tuneName) {
		this.tuneName = tuneName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CallerTune [tuneId=" + tuneId + ", tuneName=" + tuneName + ", movieName=" + movieName + ", count="
				+ count + "]";
	}
	
}
