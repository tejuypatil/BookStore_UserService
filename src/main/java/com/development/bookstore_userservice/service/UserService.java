package com.development.bookstore_userservice.service;

import com.development.bookstore_userservice.dto.UserLoginRequestDTO;
import com.development.bookstore_userservice.dto.UserRegisterRequestDTO;
import com.development.bookstore_userservice.email.EmailService;
import com.development.bookstore_userservice.entity.UserData;
import com.development.bookstore_userservice.exception.UserAlreadyExist;
import com.development.bookstore_userservice.exception.UserOrPasswordWrong;
import com.development.bookstore_userservice.repository.UserRepository;
import com.development.bookstore_userservice.util.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    TokenUtility tokenUtility;
    @Autowired
    public UserRepository userRepository;

    @Autowired
    EmailService emailService;

    @Override
    public UserData registerUser(UserRegisterRequestDTO userRegisterRequestDTO){
        try {
            UserData userData = new UserData(userRegisterRequestDTO);
            userData = userRepository.save(userData);
            emailService.sendEmail(userData.getEmail(),"User registration successful","Hi "+userData.getFirstName()+" \nYour user successfully registered with BookStore App");
            return userData;
        }
        catch (DataIntegrityViolationException exception) {
            throw new UserAlreadyExist(userRegisterRequestDTO);
        }

    }

    @Override
    public String login(UserLoginRequestDTO userLoginRequestDTO) {
        Optional<UserData> userDataOptional = userRepository.findByLoginId(userLoginRequestDTO.getLoginId());
        if(userDataOptional.isPresent())
        {
            String passwordInDatabase = userDataOptional.get().getPassword();
            String passwordEntered = userLoginRequestDTO.getPassword();
            if (passwordEntered.equals(passwordInDatabase))
            {
                System.out.println("Login Successful");
                String token = tokenUtility.createToken(userDataOptional.get().getUserId());
                return token;
            }
            else
            {
                throw new UserOrPasswordWrong(userLoginRequestDTO.getLoginId());
            }
        }
        else
        {
            throw new UserOrPasswordWrong(userLoginRequestDTO.getLoginId());
        }
    }

    @Override
    public UserData getUser(int userId) {

        return userRepository.findById(userId).orElse(null);
    }
}
