/**
 * 
 */
package cn.cuit.lsn.dao;

import cn.cuit.lsn.dto.BooksDto;

import java.util.List;

/**
 * @author 路双宁
 *
 */
public interface BooksDao {
	/**
	 * 根据书名查找
	 * @param bookName 书名
	 */
	BooksDto queryBookByName(String bookName);
	
	/**
	 * 查找相同种类的书
	 * @param category 所属类别
	 */
	
	List<BooksDto> queryBooksWithType(String category);
	
	
	/**
	 * 查找所有书
	 */
	List<BooksDto> queryAllBooks();
	

}
