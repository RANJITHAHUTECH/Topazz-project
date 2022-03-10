
package com.hutech.topazproject.serviceimpl;

import java.time.Duration;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hutech.topazproject.model.AdminLogin;
import com.hutech.topazproject.repository.AdminRepository;

@Service
public class ForgetAndResetService {

	private static final String tokenUrl = "http://localhost:8888/reset-password?token=";
	private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public String forgotPassword(String emailId) {
		Optional<AdminLogin> loginOptional = Optional.ofNullable(adminRepository.findByEmailId(emailId));
		System.out.println("loginOptional{} " + loginOptional);

		if (!loginOptional.isPresent()) {
			return "Email id Doesn't exist";
		}

		AdminLogin admin = loginOptional.get();
		admin.setToken(generateToken());

		admin.setTokenCreationDate(LocalDateTime.now());

		SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
		passwordResetEmail.setFrom("ranjitha@hutechsolutions.com");
		passwordResetEmail.setTo(admin.getEmailId());
		passwordResetEmail.setSubject("Password Reset Request");
		passwordResetEmail.setText(
				"To reset your password, click the link below:\n" + tokenUrl + "/reset?token=" + admin.getToken());
		// emailService.sendEmail(passwordResetEmail);
		javaMailSender.send(passwordResetEmail);
		admin = adminRepository.save(admin);
		System.out.println("save obj{} " + admin);

		if (admin != null) {
			return tokenUrl + "<" + admin.getToken() + ">";
		} else {
			return "Failed to Save";
		}

	}

	public String checkTokenAndResetPassword(String token, String password) {
		String finalTokenFromLink = token.substring(token.indexOf("<") + 1, token.indexOf(">"));
		System.out.println("finalTokenFromLink{} " + finalTokenFromLink);

		Optional<AdminLogin> loginOptional = Optional.ofNullable(adminRepository.findByToken(finalTokenFromLink));
		System.out.println("tokenExist Processind..{} " + loginOptional);

		if (!loginOptional.isPresent()) {
			return "Invalid token";
		}

		LocalDateTime tokenCreationDate = loginOptional.get().getTokenCreationDate();
		if (isTokenExpired(tokenCreationDate)) {
			return "Token expired.";
		}

		AdminLogin admin = loginOptional.get();
		String encode = bCryptPasswordEncoder.encode(password);
		admin.setPassword(encode);

		admin.setToken(finalTokenFromLink);
		admin.setTokenCreationDate(LocalDateTime.now());
		admin = adminRepository.save(admin);

		if (admin != null)
			return "Your password successfully updated.";
		else
			return "Failed to update password";
	}

	private String generateToken() {
		StringBuilder token = new StringBuilder();
		return token.append(UUID.randomUUID().toString()).append(UUID.randomUUID().toString()).toString();
	}

	private boolean isTokenExpired(final LocalDateTime tokenCreationDate) {
		LocalDateTime now = LocalDateTime.now();
		Duration diff = Duration.between(tokenCreationDate, now);
		return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
	}

}
