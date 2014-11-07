package cn.mvc.dao;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.mvc.model.SysUser;

@Repository
public class UserDao extends BaseDao<SysUser> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserDao.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SysUser findByName(String loginName) throws Exception {
		List<Object> list = new ArrayList<Object>();
		SysUser u=null;
		String sql="select * from sys_user s wher s.login_name=? ";
		list.add(loginName);
		
		logger.info("根据用户名查询用户信息,查询sql=:"+sql);
		logger.info("根据用户名查询用户信息,查询参数=:"+list.toArray());

		List<SysUser> userList=jdbcTemplate.query(sql,list.toArray(),new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				SysUser user =new SysUser();
				user.setId(rs.getString("id"));
				user.setLoginName(rs.getString("login_name"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		});
		if(userList!=null && userList.size()>0){
			u=userList.get(0);
		}
		return u;
	}
	
	public int deleteByIds(String ids) throws Exception{
		
		return deleteById("sys_user", ids);
	}
}
