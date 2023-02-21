package com.zhongfeng.api.modules.user.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhongfeng.api.modules.user.vo.UserVo;
import com.zhongfeng.api.modules.user.vo.params.UserParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author blueCat
 * @date 2023/2/3 15:53
 * @motto life is a gift
 */
public interface UserMapper {
    /**
     * 查询用户名
     * @param username
     * @return
     */
    int queryUserByUsername(String username);

    /**
     * 检查账号密码
     * @param username
     * @param password
     * @return
     */
    String checkAccount(@Param("username") String username,@Param("password") String password);



    /**
     * 查询用户信息
     * @param username
     * @return
     */
    UserVo queryUser(String username);

    UserVo queryUserById(Integer userId);

    /**
     * 查询全部用户
     * @param page
     * @param params
     * @return
     */
    List<UserVo> queryAllUser(Page<UserVo> page, @Param("params") UserParams params);

    /**
     * 检查用户名
     * @param username
     * @return
     */
    int checkUsername(String username);

    /**
     * 添加用户
     * @param params
     * @return
     */
    int addUser(@Param("params") UserParams params);

    /**
     *修改用户
     * @param params
     * @return
     */
    int updateUser(@Param("params") UserParams params);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUser(Integer id);
}
