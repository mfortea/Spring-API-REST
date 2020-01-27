package es.mfortea.fp2020.user.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.mfortea.fp2020.user.exceptions.UserException;
import es.mfortea.fp2020.user.modelo.User;
import es.mfortea.fp2020.user.repository.UserRepository;
import es.mfortea.fp2020.user.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void addUser(User user) {
		if (this.userRepository.userExists(user.getNickName())) {
			throw new UserException("err.user.already.exists");
		}
		this.userRepository.addUser(user);
	}

	@Override
	public void modifyUser(String nickName, User modifiedUser) {
		if (!this.userRepository.userExists(nickName)) {
			throw new UserException("err.user.not.exists");
		}

		if (isNickNameToModifyInUse(nickName, modifiedUser)) {
			throw new UserException("err.nick.name.already.in.use");
		}

		this.userRepository.modifyUser(nickName, modifiedUser);
	}

	@Override
	public void deleteUser(String nickname) {
		userRepository.deleteUser(nickname);
	}

	@Override
	public List<User> searchUsersByCountry(String country) {
		return userRepository.searchUsersByCountry(country);
	}

	private boolean isNickNameToModifyInUse(String nickName, User modifiedUser) {
		return !nickName.equals(modifiedUser.getNickName())
				&& this.userRepository.userExists(modifiedUser.getNickName());
	}

	@Override
	public List<User> getAllUsers() {
		return this.userRepository.getAllUsers();
	}

}
