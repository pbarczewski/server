package pl.pbarczewski.entites;




import java.time.LocalDate;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
@Table (name = "files")
public class File {
	
	@NotNull
	@Id
	@Column(name = "guid")
	private Integer guId;
	@NotNull
	@NotBlank
	@Column(name = "filename")
	private String fileName;
	@NotNull
	@NotBlank
	@Column(name = "srclang")
	private String srcLang;
	@NotNull
	@NotBlank
	@Column(name = "trglang")
	private String trgLang;
	@Column(name = "customer")
	private String customer;
	@Column(name = "specialisation")
	private Integer specialisation;
	@Column(name = "engine")
	private String engine;
	@Column(name = "project")
	private String project;
	@Column(name = "translator")
	private String translator;
	@Column(name = "addedon")
	//@Temporal(TemporalType.DATE)
	private LocalDate addedOn;
	//@OneToMany(mappedBy = "file", cascade = CascadeType.ALL)
	@OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JoinColumn(name = "fileid")
	private Set<Segment> segments = new HashSet<>();


	public File() {
		
	}
	
	
	
	public File(@NotNull @NotBlank Integer guId, @NotNull @NotBlank String fileName, @NotNull @NotBlank String srcLang,
			@NotNull @NotBlank String trgLang, LocalDate addedOn) {
		this.guId = guId;
		this.fileName = fileName;
		this.srcLang = srcLang;
		this.trgLang = trgLang;
		this.addedOn = addedOn;
	}



	public Integer getGuId() {
		return guId;
	}

	public String getFileName() {
		return fileName;
	}

	public String getSrcLang() {
		return srcLang;
	}

	public String getTrgLang() {
		return trgLang;
	}

	public String getCustomer() {
		return customer;
	}

	public Integer getSpecialisation() {
		return specialisation;
	}

	public String getEngine() {
		return engine;
	}

	public String getProject() {
		return project;
	}

	public String getTranslator() {
		return translator;
	}

	public LocalDate getAddedOn() {
		return addedOn;
	}
	
	public Set<Segment> getSegments() {
		return segments;
	}
}
