package com.system.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.system.sys.entity.Menu;
import com.system.sys.mapper.MenuMapper;
import com.system.sys.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xzy
 * @since 2023-09-02
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Override
    public List<Menu> getAllMenu() {
        LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Menu::getParentId,0);
        List<Menu> list = this.list(wrapper);
        setMenuChildren(list);
        return list;
    }

    private void setMenuChildren(List<Menu> list) {
        if (list != null){
            for (Menu menu : list) {
                LambdaQueryWrapper<Menu> subWrapper = new LambdaQueryWrapper<>();
                subWrapper.eq(Menu::getParentId,menu.getMenuId());
                List<Menu> subList = this.list(subWrapper);
                menu.setChildren(subList);
                //递归
                setMenuChildren(subList);
            }
        }
    }
    @Override
    public List<Menu> getMenuListByUserId(Integer userId) {
        //一级菜单
        List<Menu> menuList = baseMapper.getMenuListByUserId(userId, 0);
        //子菜单
        setMenuChildrenByUserId(userId, menuList);
        return menuList;
    }

    private void setMenuChildrenByUserId(Integer userId, List<Menu> menuList) {
        if (menuList != null){
            for (Menu menu : menuList) {
                List<Menu> subMenuList = baseMapper.getMenuListByUserId(userId, menu.getMenuId());
                menu.setChildren(subMenuList);
                setMenuChildrenByUserId(userId,subMenuList);
            }
        }
    }
}
