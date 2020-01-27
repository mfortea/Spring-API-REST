package es.mfortea.fp2020.user.services;

import java.util.List;

import es.mfortea.fp2020.user.modelo.User;

public interface UserService {

	public abstract void addUser(User user);

	public abstract void modifyUser(String nickname, User modifiedUser);

	public abstract void deleteUser(String nickname);

	public abstract List<User> searchUsersByCountry(String country);

	public abstract List<User> getAllUsers();

}
