package es.mfortea.fp2020.user.repository.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.mfortea.fp2020.user.exceptions.UserException;
import es.mfortea.fp2020.user.modelo.User;

public class UserRepositoryMemoryListTest {
	protected static final String NICK_NAME = "minick";
	private final User user = User.builder().nickName(NICK_NAME).build();
	private final User user2 = User.builder().nickName(NICK_NAME).build();
	private final User user3 = User.builder().nickName(NICK_NAME).build();
	private UserRepositoryMemoryList userRepository;

	@BeforeEach
	public void initializeBeforeEachTest() {
		this.userRepository = new UserRepositoryMemoryList();
	}

	@Test
	public void shouldThrowExceptionModifyUser() {
		assertThrows(UserException.class, () -> this.userRepository.modifyUser(NICK_NAME, user));
	}

	@Test
	public void shouldModifyUser() {
		this.userRepository.users.add(this.user);
		this.userRepository.users.add(this.user2);

		// training
		when(user.getNickName()).thenReturn(NICK_NAME);
		
		// test execution
		this.userRepository.modifyUser(NICK_NAME, this.user3);
		
		// result validation
		assertSame(this.user3, this.userRepository.users.get(0));

	}

}
