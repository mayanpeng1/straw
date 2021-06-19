package cn.tedu.straw.portal.mapper;

import cn.tedu.straw.portal.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tedu.cn
 * @since 2021-06-05
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据 电话  查找用户是否存在
     * @param phone
     * @return
     */
    User findByPhone(String phone);

}
