package com.example.model;

public class Traffic {

	private String name;
	private String incident;
	private int severity;
	public Traffic(String name, String incident, int severity) {
		super();
		this.name = name;
		this.incident = incident;
		this.severity = severity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIncident() {
		return incident;
	}
	public void setIncident(String incident) {
		this.incident = incident;
	}
	public int getSeverity() {
		return severity;
	}
	public void setSeverity(int severity) {
		this.severity = severity;
	}
}
