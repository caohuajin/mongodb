package guru.springframework.services;


import guru.springframework.domain.User;
import guru.springframework.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MongoTransactionManager transactionManager;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    //查询年龄大于20的用户
    public List<User> getUsersByAgeGreaterThan(int age) {
        Query query = new Query(Criteria.where("age").gt(age));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }
    //分页查询用户
    public Page<User> getUsersByPage(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return userRepository.findAll(pageRequest);
    }
    //分页查询按年龄倒序
    public Page<User> getUsersByPageAndSort(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return userRepository.findAllByOrderByAgeDesc(pageRequest);
    }

    /**
     * 保存用户添加事务支持，需要mongodb 4.0以上
     */
    @Transactional
    public void saveUserWithTransaction(User user) {
        try {
            userRepository.save(user);
            int x = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback(transactionManager.getTransaction(null));
        }
    }
}



