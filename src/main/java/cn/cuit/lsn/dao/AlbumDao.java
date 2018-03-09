/**
 * 
 */
package cn.cuit.lsn.dao;

import cn.cuit.lsn.dto.AlbumDto;

import java.util.List;

/**
 * @author 路双宁
 *
 */
public interface AlbumDao {
	
	/*
	 *查询相册
	 */
	List<AlbumDto> querryAlbum();
	
	/*
	 * 查询相册的内容
	 */
	List<AlbumDto> querryDetail(String belongTo);
	
}
