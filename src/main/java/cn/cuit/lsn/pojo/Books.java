/**
 * 
 */
package cn.cuit.lsn.pojo;

/**
 * @author 路双宁
 *
 */
public class Books {
//	private Integer bookId;
	
	private String bookName;
	
	private String authorName;
	
	private String press;
	
	private String category;
	
	private String format;

	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
//	public Integer getBookId() {
//		return bookId;
//	}
//	public void setBookId(Integer bookId) {
//		this.bookId = bookId;
//	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
