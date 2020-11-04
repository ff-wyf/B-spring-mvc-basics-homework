package com.thoughtworks.capacity.gtb.mvc.Service;

import com.thoughtworks.capacity.gtb.mvc.Exception.UserNameIsSameException;
import com.thoughtworks.capacity.gtb.mvc.Exception.UserNotFoundException;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.stereotype.Service;

import static com.thoughtworks.capacity.gtb.mvc.Repository.UserRepository.userList;

@Service
public class UserService {

    public void registerUser(User user) {
        String username = user.getUsername();
        for (int i = 0; i < userList.size(); ++i) {
            if (userList.get(i).getUsername().equals(username)) {
                throw new UserNameIsSameException("用户已存在");
            }
        }
        userList.add(User.builder().username(user.getUsername()).password(user.getPassword()).email(user.getEmail()).build());
    }

    public User loginUser(String username, String password) {
        boolean isFound = false;
        User user = new User();
        for (int i = 0; i < userList.size(); ++i) {
            if (userList.get(i).getUsername().equals(username) && userList.get(i).getPassword().equals(password)) {
                isFound = true;
                user = User.builder().id(String.valueOf(i)).email(userList.get(i).getEmail()).password(userList.get(i).getPassword()).username(userList.get(i).getUsername()).build();
                break;
            }
        }
        if (!isFound) {
            throw new UserNotFoundException("用户名或密码错误");
        }
        return user;
    }
}
