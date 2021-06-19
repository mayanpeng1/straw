package cn.tedu.straw.portal.mapper;

import cn.tedu.straw.portal.model.ClassInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClassInFoMapperTests {
    @Autowired
    ClassInfoMapper classInfoMapper;

    @Test
    void findByInviteCode(){
        String inviteCode = "JSD2006-666666";
        ClassInfo classInfo = classInfoMapper.findByInviteCode(inviteCode);
        System.err.println("classInFo="+classInfo);
    }
}
