package com.example.carbooking.contoller;
import com.example.carbooking.entities.UserEntity;
import com.example.carbooking.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

   private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserEntity>createUser(@RequestBody UserEntity userEntity)
    {
        UserEntity SavedEntity=userService.create(userEntity);
        return ResponseEntity.ok(SavedEntity);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getById(@PathVariable int id) {
        UserEntity userEntity = userService.getById(id);
        return ResponseEntity.ok(userEntity);
    }
}
