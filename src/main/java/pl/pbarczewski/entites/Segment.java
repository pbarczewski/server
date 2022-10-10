package pl.pbarczewski.entites;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "segments")
public class Segment {
	
	@NotNull
	@Id
	@Column(name="guid")
	private Integer guId;
	@NotNull
	@NotBlank
	@Column(name="srctext")
	private String srcText;
	@NotNull
	@NotBlank
	@Column(name="trgtext")
	private String trgText;
	@NotNull
	@NotBlank
	@Column(name="mttext")
	private String mtText;
	@NotNull
	@Column(name="matchrate")
	private Double matchRate;
	@NotNull
	@Column(name="ed")
	private Double ed;
	@NotNull
	@Column(name="fileid")
	private Integer fileId;
	/*
	 * @ManyToOne(fetch = FetchType.LAZY) private File file;
	 */
	
	public Segment() {
		
	}

	public Segment(Integer guId, String srcText, String trgText, String mtText, Double matchRate, Double ed,
			Integer fileId) {
		this.guId = guId;
		this.srcText = srcText;
		this.trgText = trgText;
		this.mtText = mtText;
		this.matchRate = matchRate;
		this.ed = ed;
		this.fileId = fileId;
	}

	public int getGuId() {
		return guId;
	}

	public String getSrcText() {
		return srcText;
	}

	public String getTrgText() {
		return trgText;
	}

	public String getMtText() {
		return mtText;
	}

	public Double getMatchRate() {
		return matchRate;
	}

	public Double getEd() {
		return ed;
	}

	public Integer getFileId() {
		return fileId;
	}
	
}
