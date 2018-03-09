/**
 * 
 */
package cn.cuit.lsn.dto;

/**
 * @author 路双宁
 *
 */
public class AlbumDto {
	private String belongTo;
	private String name;
	private int frontCover;
	
	public AlbumDto(){}

	public String getBelongTo() {
		return belongTo;
	}

	public void setBelongTo(String belongTo) {
		this.belongTo = belongTo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFrontCover() {
		return frontCover;
	}

	public void setFrontCover(int frontCover) {
		this.frontCover = frontCover;
	}
	
	
}
