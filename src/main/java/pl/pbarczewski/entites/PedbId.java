package pl.pbarczewski.entites;

import java.io.Serializable;

public class PedbId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String languages;
	private String project;
	
	public PedbId() {
		
	}
	
	public PedbId(String languages, String project) {
		this.languages = languages;
		this.project = project;
	}
}
