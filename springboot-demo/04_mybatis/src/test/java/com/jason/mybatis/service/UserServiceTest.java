package com.jason.mybatis.service;

import com.jason.mybatis.enums.UserSexEnum;
import com.jason.mybatis.mapper.UserMapper;
import com.jason.mybatis.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
public class UserServiceTest {
    @InjectMocks
    UserService userService;

    @Mock
    UserMapper userMapper;

    User user1;
    User user2;

    @Before
    public void init() {
        user1 = new User();
        user1.setId(1L);
        user1.setUserName("Stan");
        user1.setUserSex(UserSexEnum.MAN);

        user2 = new User();
        user2.setId(2L);
        user2.setUserName("Alice");
        user2.setUserSex(UserSexEnum.WOMAN);
    }

    @Test
    public void getUsers() {
        Mockito.when(userMapper.getAll()).thenReturn(Arrays.asList(user1, user2));
        List<User> userList = userService.getUsers();
        assertThat(userList, notNullValue());
        assertThat(userList.size(), is(2));
    }

    @Test
    public void getUser() {
        Mockito.doReturn(user1).when(userMapper).getOne(1L);

        User user = userService.getUser(1L);
        assertThat(user, notNullValue(User.class));
        assertThat(user.getId(), is(1L));
        assertThat(user.getUserName(), equalTo("Stan"));
        assertThat(user.getUserSex(), equalTo(UserSexEnum.MAN));
    }
}
