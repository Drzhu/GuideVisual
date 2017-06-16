package com.guide.mapper;

import com.guide.pojo.User;

public interface UserMapper {

    int validate_user(User user);

    int update(User user);

	int validate_right(User user);
}