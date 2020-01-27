package es.mfortea.fp2020.user.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import es.mfortea.fp2020.user.exceptions.UserException;
import es.mfortea.fp2020.user.modelo.User;
import es.mfortea.fp2020.user.repository.UserRepository;

@Repository
public class UserRepositoryMemoryList implements UserRepository {
	final List<User> users = new ArrayList();

	@Override
	public void addUser(User user) {
		users.add(user);
	}

	@Override
	public void modifyUser(String nickName, User modifiedUser) {
		// Construye un objeto usuario con solo el nickname y el resto de valores null
		final int position = users.indexOf(User.builder().nickName(nickName).build());
		if (position == -1) {
			throw new UserException("err.user.not.exists");
		}
		users.set(position, modifiedUser);

	}

	@Override
	public void deleteUser(String nickname) {
		users.remove(User.builder().nickName(nickname).build());
	}

	@Override
	public List<User> searchUsersByCountry(String country) {
		return users.stream().filter(
				user -> 
				user.getCountry().equals(country)).
				collect(Collectors.toList());
	}

	@Override
	public boolean userExists(String nickName) {
		return users.contains(User.builder().nickName(nickName).build());
	}

	@Override
	public List<User> getAllUsers() {
		return users.stream().collect(Collectors.toList());
	}

}
