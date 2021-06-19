package cn.tedu.straw.portal.mapper;

import cn.tedu.straw.portal.model.ClassInfo;
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
public interface ClassInfoMapper extends BaseMapper<ClassInfo> {
    /**
     * 根据班级验证码 查找对应的 班级信息
     * @param inviteCode
     * @return
     */
    ClassInfo findByInviteCode(String inviteCode);

}
