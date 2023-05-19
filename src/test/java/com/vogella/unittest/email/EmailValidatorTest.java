package com.vogella.unittest.email;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.Test;

public class EmailValidatorTest {

	@Test
	public void ensureThatEmailValidatorReturnsTrueForValidEmail() {
		assertTrue(EmailValidator.isValidEmail("lars.vogel@gmail.com"));
	}
	
	@Test
	@DisplayName("Ensure that usage of a subdomain is still valid, see https://en.wikipedia.org/wiki/Subdomain")
	public void emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
		assertTrue(EmailValidator.isValidEmail("mail@subdominio.info.com"));
	}

	@Test
	@DisplayName("Ensure that a missing top-level domain returns false")
	public void emailValidator_InvalidEmailNotId_ReturnsFalse() {
		assertFalse(EmailValidator.isValidEmail("mail@info"));
	}
	
	
	@Test
	public void emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
		assertFalse(EmailValidator.isValidEmail("mail@info..com"));
	}
	
	@Test
	public void emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
		assertFalse(EmailValidator.isValidEmail("@info.com"));
	}
	
	@Test
	public void emailValidator_EmptyString_ReturnsFalse() {
		assertFalse(EmailValidator.isValidEmail(""));
	}
	
	@Test
	public void emailValidator_NullEmail_ReturnsFalse() {
		assertFalse(EmailValidator.isValidEmail(null));
	}
	
}
