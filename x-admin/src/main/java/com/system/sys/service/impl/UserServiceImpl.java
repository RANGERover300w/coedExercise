package com.system.sys.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.system.common.utils.JwtUtil;
import com.system.sys.entity.Menu;
import com.system.sys.entity.User;
import com.system.sys.entity.UserRole;
import com.system.sys.mapper.UserMapper;
import com.system.sys.mapper.UserRoleMapper;
import com.system.sys.service.IMenuService;
import com.system.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xzy
 * @since 2023-09-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private IMenuService menuService;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Override
    public Map<String, Object> login(User user) {
        //根据用户名密码查询
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,user.getUsername());
        User loginUser = this.baseMapper.selectOne(wrapper);
        if (loginUser != null && passwordEncoder.matches(user.getPassword(),loginUser.getPassword())){
            //暂时用uuid ， 中级方案用jwt
//            String key = "user:" + UUID.randomUUID();

            //存入redis
            loginUser.setPassword(null);
            String token = jwtUtil.createToken(loginUser);
//            redisTemplate.opsForValue().set(key,loginUser,30, TimeUnit.MINUTES);

            Map<String, Object> data = new HashMap<>();
            data.put("token",token);
            return data;
        }
        return null;
        //结果不为空生成token，并将用户信息存入redis
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {
        // 从redis查询token
//        Object obj = redisTemplate.opsForValue().get(token);
        // 反序列化
        User user = null;
        try {
            user = jwtUtil.parseToken(token, User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(user != null){
            Map<String, Object> data =  new HashMap<>();
            data.put("name",user.getUsername());
            data.put("avatar",user.getAvatar());
            List<String> roleList = this.getBaseMapper().getRoleNamesByUserId(user.getId());
            data.put("roles", roleList);

            //权限列表
            List<Menu> menuList = menuService.getMenuListByUserId(user.getId());
            data.put("menuList",menuList);


            return data;
        }
        return null;
    }

    @Override
    public void logout(String token) {

//        redisTemplate.delete(token);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        baseMapper.insert(user);

        List<Integer> roleIdList = user.getRoleIdList();
        if (roleIdList != null){
            for (Integer roleId : roleIdList) {
                userRoleMapper.insert(new UserRole(null,user.getId(),roleId));
            }
        }
    }

    @Override
    public User getUserById(Integer id) {
        User user = baseMapper.selectById(id);

        LambdaQueryWrapper<UserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRole::getUserId,id);
        List<UserRole> userRoleList = userRoleMapper.selectList(wrapper);
        List<Integer> roleIdList = userRoleList.stream()
                .map(userRole -> {return userRole.getRoleId();})
                .collect(Collectors.toList());
        user.setRoleIdList(roleIdList);
        return user;
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        baseMapper.updateById(user);
        LambdaQueryWrapper<UserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRole::getUserId,user.getId());
        userRoleMapper.delete(wrapper);
        List<Integer> roleIdList = user.getRoleIdList();
        for (Integer roleId : roleIdList) {
            userRoleMapper.insert(new UserRole(null,user.getId(),roleId));
        }
    }

    @Override
    public void deleteUserById(Integer id) {
        baseMapper.deleteById(id);
        LambdaQueryWrapper<UserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRole::getUserId,id);
        userRoleMapper.delete(wrapper);
    }
}
