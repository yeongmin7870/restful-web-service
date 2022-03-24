package com.example.demo.user;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;

    static {
        users.add(new User(1,"Kenneth",new Date(), "pass1","701010-1111"));
        users.add(new User(2,"hey",new Date() ,"pass2","701010-1131"));
        users.add(new User(3,"what",new Date(),"pass3","701010-1121"));
    }

    public List<User> findAll(){
        return users;
    }



    public User save(User user){
        if(user.getId() == null){
            user.setId(++userCount);
            users.add(user);
        }
        return user;
    }



    public User findOne(int id){
        for(User user: users){
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()){
            User user = iterator.next();

            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }

    public User updateUser (Integer id,User user){
        users.stream()
                .forEach(c -> {
                    if(c.getId() == id){
                        c.setName(user.getName());
                        c.setJoinDate(user.getJoinDate());
                    }
                });
        return user;
    }
}
