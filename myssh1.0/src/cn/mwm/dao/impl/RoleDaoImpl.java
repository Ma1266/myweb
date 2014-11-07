package cn.mwm.dao.impl;
import org.springframework.stereotype.Repository;

import cn.mwm.dao.IRoleDao;
import cn.mwm.dao.IUserDao;
import cn.mwm.model.TRole;
import cn.mwm.vo.User;
@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<TRole> implements IRoleDao<TRole> {

}
