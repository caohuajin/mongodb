package guru.springframework.controllers;


import guru.springframework.api.CommonResult;
import guru.springframework.domain.User;
import guru.springframework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     *通过用户名查询用户
     */
    @GetMapping("/findUser/{username}")
    public User getUserByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        return user;
    }

    /**
     * 获取所有用户
     */
    @GetMapping("/getAllUsers")
    public CommonResult getAllUsers() {
        List<User> users = userService.getAllUsers();
        users.forEach(user -> System.out.println(user));
        return CommonResult.success(users);
    }

    /**
     * 新增或更新用户
     */
    @PostMapping("/creatUser")
    public CommonResult createUser(@RequestBody User user) {
        return CommonResult.success(userService.saveUser(user));
    }

    /**
     * 查询年龄大于age
     */
    @GetMapping("/getUsersByAgeGreaterThan/{age}")
    public CommonResult getUsersByAgeGreaterThan(@PathVariable int age) {
        return CommonResult.success(userService.getUsersByAgeGreaterThan(age));
    }
    /**
     *分页查询用户
     */
    @GetMapping("/getUsersByPage")
    public CommonResult getUsersByPage(@RequestParam(defaultValue = "0") int pageNumber,
                                       @RequestParam(defaultValue = "10") int pageSize) {
        return CommonResult.success(userService.getUsersByPage(pageNumber, pageSize));
    }

    /**
     * 分页查询用户并按年龄倒序
     */
    @GetMapping("/getUsersByPageAndSort")
    public CommonResult getUsersByPageAndSort(@RequestParam(defaultValue = "0") int pageNumber,
                                              @RequestParam(defaultValue = "10") int pageSize) {
        return CommonResult.success(userService.getUsersByPageAndSort(pageNumber, pageSize));
    }

    /**
     * 新增或更新用户支持事务
     */
    @PostMapping("/saveUserWithTransaction")
    public CommonResult saveUserWithTransaction(@RequestBody User user) {
        userService.saveUserWithTransaction(user);
        return CommonResult.success(null);
    }
}
