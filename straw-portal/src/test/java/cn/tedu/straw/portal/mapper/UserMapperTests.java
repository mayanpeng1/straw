package cn.tedu.straw.portal.mapper;

import cn.tedu.straw.portal.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMapperTests {
    @Autowired
    UserMapper userMapper ;

    @Test
    void findByPhone(){
        User user = userMapper.findByPhone("15204260613");
        System.err.println("user="+user);
    }
}
