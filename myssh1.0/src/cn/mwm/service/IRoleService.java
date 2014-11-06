package cn.mwm.service;

import java.util.List;

import cn.mwm.exception.BusinessException;
import cn.mwm.model.TRole;

public interface IRoleService {

	public List<TRole> getAllRoleList() throws BusinessException;
}
