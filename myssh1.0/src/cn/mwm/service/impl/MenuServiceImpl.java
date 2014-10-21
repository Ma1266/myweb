package cn.mwm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mwm.constant.GlobleNames;
import cn.mwm.dao.IMenuDao;
import cn.mwm.pageModel.MenuModel;
import cn.mwm.service.IMenuService;
import cn.mwm.vo.User;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private IMenuDao menuDao;

	@Override
	public List<MenuModel> getAllMenu(Integer userId) {
		StringBuffer sql = new StringBuffer("select f.id,f.pid,f.name,f.iconCls,f.sort,f.url from t_function f ");
		// 1.如果是管理员admin 则具有全部的功能权限
		// 2.其他用户根据用户id 查询角色所拥有的功能菜单
		if (GlobleNames.ADMIN.equals(userId)) {
			sql.append(" where f.status=1 order by f.sort asc");
			//sql = "select f.id,f.pid,f.name,f.iconCls,f.sort,f.url from t_function f where f.status=1 order by f.sort asc ";
		} else {
//			sql = "select f.id,f.pid,f.name,f.iconCls,f.sort,f.url from t_function f,t_role_func tr, t_role ro,t_user_role tu \n"
//					+ " where tr.func_id=f.id AND tr.role_id = ro.id and ro.id = tu.role_id and f.status=1 and  tu.user_id="
//					+ user.getId() + " order by f.sort asc ";
			sql.append(",t_role_func tr,");
			sql.append(" t_role ro,");
			sql.append(" t_user_role tu ");
			sql.append(" where tr.func_id=f.id AND tr.role_id = ro.id ");
			sql.append(" and ro.id = tu.role_id and f.status=1 ");
			sql.append(" and tu.user_id="+userId+" order by f.sort asc");
		}
		List menuList = menuDao.findBySQL(sql.toString());
		List<MenuModel> parentMenuList = new ArrayList<MenuModel>();
		for (Object obj : menuList) {
			Object[] objs = (Object[]) obj;
			int id = Integer.parseInt(objs[0].toString());
			int pid = Integer.parseInt(objs[1].toString());
			if (pid == 0) {// pid is null
				// 构造 父级菜单列表
				MenuModel menuModel = new MenuModel();
				menuModel.setName(String.valueOf(objs[2]));
				menuModel.setIconCls(String.valueOf(objs[3]));
				menuModel.setUrl(String.valueOf(objs[5]));
				List<MenuModel> childList = new ArrayList<MenuModel>();
				// 构造 父级菜单对应子级菜单列表
				for (Object obj2 : menuList) {
					MenuModel menuChildModel = new MenuModel();
					Object[] objs2 = (Object[]) obj2;
					int pid2 = Integer.parseInt(objs2[1].toString());
					if (pid2 == id) {
						menuChildModel.setName(String.valueOf(objs2[2]));
						menuChildModel.setIconCls(String.valueOf(objs2[3]));
						menuChildModel.setUrl(String.valueOf(objs2[5]));
						childList.add(menuChildModel);
					}
				}
				menuModel.setChild(childList);
				parentMenuList.add(menuModel);
			}
		}
		return parentMenuList;
	}

}
