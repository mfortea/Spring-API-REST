package es.mfortea.fp2020.user.services.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.mfortea.fp2020.user.exceptions.UserException;
import es.mfortea.fp2020.user.modelo.User;
import es.mfortea.fp2020.user.repository.UserRepository;

public class UserServiceImplTest {

	private static final String NICK_NAME = "minick";
	private UserServiceImpl userService;
	private final UserRepository userRepository = mock(UserRepository.class);
	private final User modifiedUser = mock(User.class);

	@BeforeEach
	public void initializeBeforeEachTest() {
		this.userService = new UserServiceImpl(userRepository);
	}

	@Test
	public void shouldThrowExceptionIfModifyUserNotExists() {
		assertThrows(UserException.class, () -> this.userService.modifyUser(NICK_NAME, modifiedUser));

	}

	@Test
	public void shouldThrowExceptionIfModifyUserWithExistingNickName() {
		// training
		when(this.userRepository.userExists(NICK_NAME)).thenReturn(true);
		when(modifiedUser.getNickName()).thenReturn("nuevo");
		when(this.userRepository.userExists("nuevo")).thenReturn(true);

		// test execution
		assertThrows(UserException.class, () -> this.userService.modifyUser(NICK_NAME, modifiedUser));
	}

	@Test
	public void shouldModifyUser() {
		// training
		when(this.userRepository.userExists(NICK_NAME)).thenReturn(true);
		when(modifiedUser.getNickName()).thenReturn(NICK_NAME);

		// test execution
		this.userService.modifyUser(NICK_NAME, modifiedUser);

		// result validation
		verify(this.userRepository, times(1)).modifyUser(NICK_NAME, modifiedUser);
	}

	@Test
	public void shouldSearchByCountry() {
		// variables definition
		final List<User> usersReturnedByRepository = new ArrayList();

		// training
		when(userRepository.searchUsersByCountry("es")).thenReturn(usersReturnedByRepository);

		// test execution
		final List<User> result = this.userService.searchUsersByCountry("es");

		// result validation
		assertSame(usersReturnedByRepository, result);
	}

}
