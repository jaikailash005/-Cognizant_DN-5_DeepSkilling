package com.exmple;

import java.util.List;

public interface UserRepository {
    List<User> findByName(String name);
}