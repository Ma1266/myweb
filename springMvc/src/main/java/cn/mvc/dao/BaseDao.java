package cn.mvc.dao;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.mvc.common.exception.BusinessException;


public class BaseDao<T>{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BaseDao.class);

	
	
	@Autowired
	JdbcTemplate jdbcTemplate;	
	
	
	 int deleteById(Object tableName,String ids) throws Exception{
		 List<Object> params=new ArrayList<Object>();
		 String sql="delete from ? where id in(?)";
		 if(tableName==null||tableName.equals("")){
			 throw new BusinessException("获取数据库表名称异常!");
		 }
		 String[] id=ids.split(",");
		 StringBuffer idsBuffer=new StringBuffer();
		 for (int i = 0; i < id.length; i++) {
			if(i>0){
				idsBuffer.append(",");
			}
			idsBuffer.append("'"+id[i]+"'");
		}
		 params.add(tableName);
		 params.add(ids);
		 logger.info("根据主键批量删除sql="+sql);
		 logger.info("根据主键批量删除参数="+params.toArray());

		return jdbcTemplate.update(sql, params.toArray());
		 
	 }
}
