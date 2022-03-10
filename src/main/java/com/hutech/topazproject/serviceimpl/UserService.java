package com.hutech.topazproject.serviceimpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hutech.topazproject.model.UserEntity;
import com.hutech.topazproject.repository.UserRepository;

@Service
public class UserService {

	private static final String tokenUrl = "http://localhost:8888/activate-account?token=";
	private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserEntity saveEntity(UserEntity entity) {

		return userRepo.save(entity);
	}

	public List<UserEntity> getAllEntities() {
		return userRepo.findAll();
	}

	public String activateUserAccount(String emailId) {
		Optional<UserEntity> loginOptional = Optional.ofNullable(userRepo.findByEmailId(emailId));
		System.out.println("loginOptional{} " + loginOptional);

		if (!loginOptional.isPresent()) {
			return "Email id Doesn't exist";
		}

		UserEntity user = loginOptional.get();
//		user.setToken(generateToken());
//
//		user.setTokenCreationDate(LocalDateTime.now());
////
//		SimpleMailMessage activateEmail = new SimpleMailMessage();
//		activateEmail.setFrom("ranjithabm133@gmail.com");
//		activateEmail.setTo(user.getEmailId());
//		activateEmail.setSubject("Activate your account");
//		activateEmail.setText("To  Activate your Account, click the link below:\n" + tokenUrl
//				+ "/activate-account?token=" + user.getToken());
//		javaMailSender.send(activateEmail);
		user = userRepo.save(user);
		System.out.println("save obj{} " + user);

		if (user != null) {
			return tokenUrl + "<" + user.getToken() + ">";
		} else {
			return "Failed to Save";
		}

	}

	public String checkTokenAndSetPassword(String token, String password) {
		String finalTokenFromLink = token.substring(token.indexOf("<") + 1, token.indexOf(">"));
		Optional<UserEntity> loginOptional = Optional.ofNullable(userRepo.findByToken(finalTokenFromLink));
		if (!loginOptional.isPresent()) {
			return "Invalid token";
		}
		LocalDateTime tokenCreationDate = loginOptional.get().getTokenCreationDate();
		if (isTokenExpired(tokenCreationDate)) {
			return "Token expired.";
		}

		UserEntity user = loginOptional.get();
		String encode = bCryptPasswordEncoder.encode(password);
		user.setPassword(encode);

		user.setToken(null);
		user.setTokenCreationDate(LocalDateTime.now());
		user.setActivated(true);
		user = userRepo.save(user);

		if (user != null)
			return "Your Account is Activated Successfully.";
		else
			return "Failed to Activate your Account";
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