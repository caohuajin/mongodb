package guru.springframework.repositories;

import guru.springframework.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
    // 分页查询所有用户
    Page<User> findAll(Pageable pageable);

    // 按照age字段倒序排序的分页查询
    Page<User> findAllByOrderByAgeDesc(Pageable pageable);

}

