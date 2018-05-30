package main;

import java.util.HashMap;

public class UserService {
    private HashMap<Long,String> userMap;

    public UserService() {
        userMap = new HashMap<Long,String>();
    }

    public String getUsername(Long id) {
        return userMap.get(id);
    }

    public Long createUser(String name) {
        Long id = IDGenerator.generateUniqueId();
        userMap.put(id, name);
        System.out.println(userMap);
        return id;
    }

    public boolean createUserDirectory(String directoryPath){
        return true;
    }

}