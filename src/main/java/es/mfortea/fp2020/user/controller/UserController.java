package es.mfortea.fp2020.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.mfortea.fp2020.user.modelo.User;
import es.mfortea.fp2020.user.services.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {
	
	private final UserService userService;
	
//	@Autowired
//	public UserController(UserService userService) {
//		this.userService = userService;
//	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		this.userService.addUser(user);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return this.userService.getAllUsers();
	}
	
	@DeleteMapping("/users/{nickname}")
	public void deleteUser(@PathVariable String nickname) {
		this.userService.deleteUser(nickname);
	}
	
	@PutMapping("/users/{nickname}")
	public void modifyUser(@PathVariable String nickname, @RequestBody User modifiedUser) {
		this.userService.modifyUser(nickname, modifiedUser);
	}
	
	@GetMapping("/users/{country}")
	public List<User> searchUsersByCountry(@PathVariable String country){
		return this.userService.searchUsersByCountry(country);
	}
	
}
