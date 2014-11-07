package cn.mwm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mwm.dao.IRoleDao;
import cn.mwm.exception.BusinessException;
import cn.mwm.model.TRole;
import cn.mwm.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleDao roleDao; 
	@Override
	public List<TRole> getAllRoleList() throws BusinessException {
		
		String hql="from TRole ";
		return roleDao.find(hql);
	}

}
