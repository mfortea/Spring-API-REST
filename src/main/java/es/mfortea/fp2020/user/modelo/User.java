package es.mfortea.fp2020.user.modelo;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(of="nickName")
public class User {
	private final String firstName;
	private final String lastName;
	private final String nickName;
	private final String password;
	private final String email;
	private final String country;
}


