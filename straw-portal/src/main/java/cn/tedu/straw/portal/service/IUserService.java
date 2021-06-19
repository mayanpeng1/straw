package cn.tedu.straw.portal.service;

import cn.tedu.straw.portal.dto.StudentRegisterDTO;
import cn.tedu.straw.portal.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tedu.cn
 * @since 2021-06-05
 */
public interface IUserService extends IService<User> {
    void reginsertStudent(StudentRegisterDTO studentRegisterDTO);

}
