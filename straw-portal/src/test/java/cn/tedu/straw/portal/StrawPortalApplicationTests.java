package cn.tedu.straw.portal;

import cn.tedu.straw.portal.mapper.UserMapper;
import cn.tedu.straw.portal.model.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jdk.nashorn.internal.lookup.MethodHandleFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
//trace：跟踪信息
//debug：测试信息
//info：一般信息
//warn:警告信息
//error:错误信息

class StrawPortalApplicationTests {
	@Autowired
	UserMapper userMapper;
	@Test
	void contextLoads() {
	}

	@Test
	public void findById(){
		Integer userId = 1;
		User user = userMapper.selectById(userId);
		System.err.println(user);
		log.debug("user="+user);
	}

	@Test
	void selectList(){
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		//queryWrapper.eq("id",3); eq 表示等于
		queryWrapper.gt("id", 2);//gt 表示大于  greater than
		List<User> users = userMapper.selectList(queryWrapper);
		for (User user : users) {
			System.err.println("user="+user);
		}
	}

}
