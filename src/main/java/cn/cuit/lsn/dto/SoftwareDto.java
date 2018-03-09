/**
 * 
 */
package cn.cuit.lsn.dto;

/**
 * @author 路双宁
 *
 */
public class SoftwareDto {
	
	private String softwareName;
	
	private String category;
	
	private String softwareIntro;
	
	private String downloadLink;
	
	private String softwareVersion;
	
	public SoftwareDto(){};

	public String getSoftwareName() {
		return softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSoftwareIntro() {
		return softwareIntro;
	}

	public void setSoftwareIntro(String softwareIntro) {
		this.softwareIntro = softwareIntro;
	}

	public String getDownloadLink() {
		return downloadLink;
	}

	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}

	public String getSoftwareVersion() {
		return softwareVersion;
	}

	public void setSoftwareVersion(String softwareVersion) {
		this.softwareVersion = softwareVersion;
	}

}
