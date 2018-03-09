package cn.cuit.lsn.dao;

import cn.cuit.lsn.pojo.MyFile;

import java.util.List;

public interface MyFileDao {
	/**
	 * 根据文件名查找文件
	 * @param fileName 文件名
	 * @return
	 */
	MyFile querryFileByName(String fileName);
	
	/**
	 * 查找相同类型的文件
	 * @param fileType 文件类型
	 * @return
	 */
	List<MyFile> querryFileWithType(int fileType);
	
	/**
	 * 查找所有文件
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<MyFile> querryAllFile(int offset, int limit);

	/**
	 * 添加文件
	 * @param fileName
	 * @param fileType
	 * @param fileLoc
	 * @return
	 */
	int insertFile(String fileName, int fileType, String fileLoc);
	
}
