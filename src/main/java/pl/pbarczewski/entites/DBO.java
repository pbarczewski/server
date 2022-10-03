package pl.pbarczewski.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dbo")
public class DBO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="srctext")
	private String srcText;
	@Column(name="trgtext")
	private String trgText;
	@Column(name="mttext")
	private String mtText;
	@Column(name="matchrate")
	private Integer matchRate;
	@Column(name="ed")
	private Double ed;
	
	public DBO() {
		
	}
	
	public DBO(String srcText, String trgText, String mtText, Integer matchRate, Double ed) {
		this.srcText = srcText;
		this.trgText = trgText;
		this.mtText = mtText;
		this.matchRate = matchRate;
		this.ed = ed;
	}

	public Integer getId() {
		return id;
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

	public Integer getMatchRate() {
		return matchRate;
	}

	public Double getEd() {
		return ed;
	}
}
