package com.isitcom.gestionProduit.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isitcom.gestionProduit.entity.DTO;
import com.isitcom.gestionProduit.entity.LoginDto;
import com.isitcom.gestionProduit.entity.User;
import com.isitcom.gestionProduit.repository.UserRepo;
import com.isitcom.gestionProduit.response.*;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    

    @Override
    public String addUser(DTO userDTO) {
        User user = new User(
                userDTO.getUserId(),
                userDTO.getUsername(),
                userDTO.getEmail(),
                userDTO.getPassword());

        userRepo.save(user);
        return user.getUsername();
    }

    /*@Override
	public LoginResponse loginUser(LoginDto loginDto) {
		String msg="";
		User user1=userRepo.findByEmail(loginDto.getEmail());
		if(user1!=null) {
			String pwd=loginDto.getPassword();
			String encodedPwd=user1.getPassword();
			Boolean isPwdRight=pwEncoder.matches(pwd, encodedPwd);
			if(isPwdRight) {
				Optional<User> user=userRepo.findOneByEmailAndPassword(loginDto.getEmail(),loginDto.getPassword());
				if(user.isPresent()) {
					return new LoginResponse("Login success",true);
					
				}
				else {
					return new LoginResponse("Login Failed",false);
				}
				
			}
			else {
				return new LoginResponse("Password Not Match",false);
				
			}
		}
		else {
			return new LoginResponse("Email doesn't exist",false);
		}
	}*/
	
	@Override
public LoginResponse loginUser(LoginDto loginDto) {
    User user = userRepo.findByEmail(loginDto.getEmail());

    if (user != null) {
        String passwordSaisi = loginDto.getPassword();
        String pwd = user.getPassword();

        if (passwordSaisi.equals(pwd)) {
            return new LoginResponse("Login success", true);
        } else {
            return new LoginResponse("Password Not Match", false);
        }
    } else {
        return new LoginResponse("Email doesn't exist", false);
    }
}

}
