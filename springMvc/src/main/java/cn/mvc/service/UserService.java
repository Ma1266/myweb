package cn.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mvc.common.exception.BusinessException;
import cn.mvc.dao.UserDao;
import cn.mvc.model.SysUser;

@Service
public class UserService extends BaseService {

	@Autowired
	private UserDao userDao;
	public SysUser findByLoginName(String loginName) throws Exception {
		if(loginName==null||"".equals(loginName)){
			throw new BusinessException("��ѯ����loginNameΪ��!");
		}
		return userDao.findByName(loginName);
	}
	
    public int deleteByIds(String ids) throws Exception{
    	if(ids==null||"".equals(ids)){
			throw new BusinessException("����idsΪ��!");
		}
		return userDao.deleteByIds(ids);
	}

}
