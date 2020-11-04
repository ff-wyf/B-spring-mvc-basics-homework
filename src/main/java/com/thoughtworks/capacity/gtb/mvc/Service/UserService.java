package com.thoughtworks.capacity.gtb.mvc.Service;

import com.thoughtworks.capacity.gtb.mvc.Exception.UserNameIsSameException;
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
        userList.add(User.builder().username(user.getUsername()).password(user.getPassword()).email(user.getPassword()).build());
        System.out.println(userList);
    }
}
