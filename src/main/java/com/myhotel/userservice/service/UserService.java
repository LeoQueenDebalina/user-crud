package com.myhotel.userservice.service;

import com.myhotel.userservice.entity.UserDatabase;

import java.util.List;

public interface UserService {
    public List<UserDatabase> getUsers();
    public UserDatabase getUserByMNumber(String mnumber);
    public UserDatabase addUser(UserDatabase userDatabase);
    public UserDatabase updateUser(UserDatabase userDatabase);
    public void deleteUser(String mnumber);
}
