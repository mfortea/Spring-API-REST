package es.mfortea.fp2020.user.repository;

import java.util.List;

import es.mfortea.fp2020.user.modelo.User;

public interface UserRepository {

	public abstract void addUser(User user);

	public abstract void modifyUser(String nickName, User modifiedUser);

	public abstract void deleteUser(String nickname);

	public abstract List<User> searchUsersByCountry(String country);

	public abstract boolean userExists(String nickName);

	public abstract List<User> getAllUsers();

}