package cn.mwm.service.impl;


import org.apache.log4j.Logger;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.mwm.dao.IUserDao;
import cn.mwm.exception.BusinessException;
import cn.mwm.model.TOrganization;
import cn.mwm.model.TRole;
import cn.mwm.model.TUser;
import cn.mwm.model.TUserRole;
import cn.mwm.pageModel.Page;
import cn.mwm.service.IUserService;
import cn.mwm.utils.DateUtil;
import cn.mwm.vo.User;

@Service("userService")
public class UserServiceImpl implements IUserService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@SuppressWarnings("rawtypes")
	@Autowired
	private IUserDao userDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public void save(User tuser) throws Exception {
		if(null==tuser){
			throw new BusinessException("用户对象为空！");
		}
		TUser user=new TUser();
		BeanUtils.copyProperties(tuser,user);
		if(tuser.getRoleId() != null ){
			TRole role=new TRole();
			TUserRole userRole=new TUserRole();
			Set<TUserRole> troles=new HashSet<TUserRole>();			
			role.setId(tuser.getRoleId());
			userRole.setTUser(user);
			userRole.setTRole(role);
			troles.add(userRole);
			user.setTUserRoles(troles);
		}
		if(null != tuser.getOrgId()){
			TOrganization org=new TOrganization();
			org.setOrganizationId(tuser.getOrgId());
			user.setTOrganization(org);
		}
		user.setCreateDate(DateUtil.getDateTime());
		userDao.save(user);
	}

	@Override
	public User getUserById(Integer userId) {
		
		return null;//(User) userDao.getUserById(userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByName(String userName) throws  BusinessException{
		if(userName==null){
			throw new BusinessException("用户名参数为空!");
		}
		StringBuffer hql=new StringBuffer("from TUser where username= :username");
		Map<String,Object> params=new HashMap<String, Object>();
		if(null!=userName)
		{
			params.put("username",userName);
		}
		TUser t=null;
		User u = new User();
		List<TUser> list=userDao.find(hql.toString(),params);
		if(list!=null&&list.size()>0){
			t=list.get(0);
			BeanUtils.copyProperties(t, u);
			return u;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page findByPage(Page pager, User user) throws BusinessException {
		if(null == pager){
			throw new BusinessException("查询错误，分页参数为空!");
		}
		logger.info("********用户分页查询开始*******");
		StringBuffer hql = new StringBuffer(" from TUser as s where 1=1 ");
		Map<String, Object> parmas = new HashMap<String, Object>();
		List<User> ul = new ArrayList<User>();
		if (user.getUsername() != null && !"".equals(user.getUsername())) {
			hql.append(" and s.username like :username");
			parmas.put("username", "%" + user.getUsername() + "%");
		}
		if (user.getStatus() != null) {
			hql.append(" and s.status = :status");
			parmas.put("status", user.getStatus());
		}
		if (user.getBeginTime() != null) {
			hql.append(" and s.createDate >=:beginTime");
			parmas.put("beginTime", user.getBeginTime());
		}
		if (user.getEndTime() != null) {
			hql.append(" and s.createDate <=:endTime");
			parmas.put("endTime", user.getEndTime());
		}
		if(pager.getSort()!=null&&pager.getOrder()!=null){
			hql.append(" order by "+pager.getSort()+" "+pager.getOrder());
		}
		String countHql = "select count(*)" + hql;
		logger.info("查询HQL=:" + hql.toString());
		logger.info("查询countHql:" + countHql);
		logger.info("查询参数为:" + parmas+" "+pager.getSort()+" "+pager.getOrder());
		List<TUser> l;
		l = (List<TUser>) userDao.find(hql.toString(), parmas,pager.getPage(), pager.getRows());
		if (l != null && l.size() > 0) {
			for (TUser t : l) {
				User u = new User();
				String roles = "";
				String orgName = "";
				String roleId = "";
				Set<TUserRole> roleList = t.getTUserRoles();
				if (roleList != null && roleList.size() > 0) {
					for (TUserRole tr : roleList) {
						roles += tr.getTRole().getName() + ",";
					}
					if (roles.length() > 0) {
						roles = roles.substring(0, roles.length() - 1);
					}
					if (roles.length() > 0) {
						roles = roles.substring(0, roles.length() - 1);
					}
				}
				u.setRoleNameList(roles);
				if (t.getTOrganization() != null) {
					u.setOrgName(t.getTOrganization().getFullName());
				}
				BeanUtils.copyProperties(t, u);
				ul.add(u);
			}
	}
		logger.info("查询userList:" + l.size());
		pager.setTotal(Integer.parseInt(userDao.count(countHql, parmas).toString()));
		logger.info("********用户分页查询结束*******共" + pager.getTotal() + "条记录！");
		pager.setResultList(ul);
		return pager;
	}

	@Override
	public int deleteByIds(String ids) {
		
		String[] ids2=ids.split(",");
		StringBuffer hql=new StringBuffer("delete from TUser t where t.id in(");
		for (int i = 0; i < ids2.length; i++) {
			if(i>0){
				hql.append(",");
			}
			hql.append("'"+ids2[i]+"'");
		}
		hql.append(")");
		
		Integer count=userDao.executeHql(hql.toString());
		return count;
	}

	@Override
	public List<User> findUserList() throws BusinessException {
		List<User> ul = null;
		List<TUser> l;
		try {
			ul = new ArrayList<User>();
			String hql="from TUser";
			 l = (List<TUser>)userDao.find(hql);
			if (l != null && l.size() > 0) {
				for (TUser t : l) {
					User u = new User();
					String roles="";
					String orgName ="";

					for (TUserRole tr : t.getTUserRoles()) {
						roles=tr.getTRole().getName()+",";
					}
					if(roles.length()>0){
						roles=roles.substring(0, roles.length()-1);
					}
					u.setRoleNameList(roles);
					if(t.getTOrganization()!=null){
						u.setOrgName(t.getTOrganization().getFullName());
					}
					BeanUtils.copyProperties(t, u);
					ul.add(u);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("查询出错："+e.getMessage());
		}
		return ul;
	}

}
