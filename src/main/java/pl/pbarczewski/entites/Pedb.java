package pl.pbarczewski.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@IdClass(PedbId.class)
@Table(name= "pedb")
public class Pedb {
	
	@Id
	@Column(name = "languages")
	private String languages;
	@Id
	@Column(name = "project")
	private String project;
	@Column(name = "srclang")
	private String srcLang;
	@Column(name = "trglang")
	private String trgLang;
	@Column(name = "enginename")
	private String engineName;
	@Column(name = "customer")
	private String customer;
	@Column(name = "specialisation")
	private Integer specialisation;
	@Column(name = "filename")
	private String filename;
	@Column(name = "translator")
	private String translator;
	@OneToOne
	private DBO dbo;

	public Pedb() {
		
	}
	
	public Pedb(String languages, String project, String srcLang, String trgLang, String engineName, String customer,
			Integer specialisation, String filename, String translator, DBO dbo) {
		this.languages = languages;
		this.project = project;
		this.srcLang = srcLang;
		this.trgLang = trgLang;
		this.engineName = engineName;
		this.customer = customer;
		this.specialisation = specialisation;
		this.filename = filename;
		this.translator = translator;
		this.dbo = dbo;
	}

	public String getLanguages() {
		return languages;
	}

	public String getProject() {
		return project;
	}

	public String getSrcLang() {
		return srcLang;
	}

	public String getTrgLang() {
		return trgLang;
	}

	public String getEngineName() {
		return engineName;
	}

	public String getCustomer() {
		return customer;
	}

	public Integer getSpecialisation() {
		return specialisation;
	}

	public String getFilename() {
		return filename;
	}

	public String getTranslator() {
		return translator;
	}

	public DBO getDbo() {
		return dbo;
	}
}
