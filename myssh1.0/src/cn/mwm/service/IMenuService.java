package cn.mwm.service;

import java.util.List;

import cn.mwm.pageModel.MenuModel;
import cn.mwm.vo.User;

public interface IMenuService {


	public List<MenuModel> getAllMenu(Integer userId);

}
