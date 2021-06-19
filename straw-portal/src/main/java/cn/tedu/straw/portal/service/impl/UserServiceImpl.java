package cn.tedu.straw.portal.service.impl;

import cn.tedu.straw.portal.dto.StudentRegisterDTO;
import cn.tedu.straw.portal.ex.ClassDisabledException;
import cn.tedu.straw.portal.ex.InsertException;
import cn.tedu.straw.portal.ex.InviteCodeException;
import cn.tedu.straw.portal.ex.PhoneDuplicateException;
import cn.tedu.straw.portal.mapper.ClassInfoMapper;
import cn.tedu.straw.portal.mapper.UserMapper;
import cn.tedu.straw.portal.model.ClassInfo;
import cn.tedu.straw.portal.model.User;
import cn.tedu.straw.portal.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tedu.cn
 * @since 2021-06-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    ClassInfoMapper classInfoMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public void reginsertStudent(StudentRegisterDTO studentRegisterDTO) {
        // 基于参数inviteCode调用classInfoMapper.findByInviteCode()执行查询
        ClassInfo classInfo = classInfoMapper.findByInviteCode(studentRegisterDTO.getInviteCode());
        // 判断查询结果是否为null
        if(classInfo==null){
            // 是：抛出InviteCodeException
            throw new InviteCodeException();
        }

        // 判断以上查询结果中的isEnabled是否为0
        if(classInfo.getIsEnabled()==0){
            // 是：抛出ClassDisabledException
            throw new ClassDisabledException();
        }
        // 基于参数phone调用userMapper.findByPhone()执行查询
        User result = userMapper.findByPhone(studentRegisterDTO.getPhone());
        // 判断查询结果是否不为null
        if(result!=null){
            // 是：抛出PhoneDuplicateException
            throw new PhoneDuplicateException();
        }
        // 创建当前时间对象now
        LocalDateTime now = LocalDateTime.now();
        // 创建User对象
        User user = new User();
        // 补全user对象的属性值：nickName < 参数nickName
        user.setNickName(studentRegisterDTO.getNackName());
        // 补全user对象的属性值：password < 参数password
        user.setPassword(studentRegisterDTO.getPassWorld());
        // 补全user对象的属性值：phone < 参数phone
        user.setPhone(studentRegisterDTO.getPhone());
        // 补全user对象的属性值：classId < 此前的查询结果
        user.setClassId(classInfo.getId());
        // 补全user对象的属性值：isEnabled < 1
        user.setIsEnabled(1);
        // 补全user对象的属性值：isLocked < 0
        user.setIsLocked(0);
        // 补全user对象的属性值：accountType < 0
        user.setAccountType(0);
        // 补全user对象的属性值：gmtCreate < now
        user.setGmtCreate(now);
        // 补全user对象的属性值：gmtModified < now
        user.setGmtModified(now);

        int row = userMapper.insert(user);
        if(row != 1){
            throw new InsertException();
        }
    }
}
