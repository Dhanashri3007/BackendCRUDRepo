package com.demo.serviceIMPL;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exception.InvalidePassword;
import com.demo.exception.Invalide__Contact;
import com.demo.exception.Invalide__EmailAddress;
import com.demo.exception.Invalide__FistName__LastName;
import com.demo.exception.UserNameNotValide;
import com.demo.model.UserLogin;
import com.demo.repositry.HomeRepositry;
import com.demo.serviceI.HomeServiceI;

@Service
public class HomeServiceIMPL implements HomeServiceI {
	@Autowired
	HomeRepositry hr;

	@Override
	public UserLogin save(UserLogin u) {
		String uname = u.getUname();
		if (Pattern.matches("(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*]).{6}", uname)) {
			System.out.println("Valid USer Name");
			String upass = u.getUpass();
			if (Pattern.matches("(?=.*[a-zA-Z0-9])(?=.*[!@#$%^&*]).{6}", upass)) {
				System.out.println("Valid password");
				String email = u.getEmailaddress();
				if (Pattern.matches("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$", email)) {
					System.out.println("Valide email");

					String contact = u.getContact();
					if (Pattern.matches("[0-9]{10}", contact)) {
						System.out.println("Valid contact");
						String fname = u.getFirstname();
						String lname = u.getLastname();
						if ((Pattern.matches("^[A-Z].*", fname)) && (Pattern.matches("^[A-Z].*", lname))) {
							System.out.println("Valid fname");
							return hr.save(u);

						} else {
							 throw new Invalide__FistName__LastName("Invalide First_Name");
						}

					} else {
						throw new Invalide__Contact("Invalide Contact");
					}
				} else {
					throw new Invalide__EmailAddress("Invalide Email");
				}

			} else {
				throw new InvalidePassword("You Enter invalide Password");
			}

		} else {
			throw new UserNameNotValide("You Enter Wrong username");
		}
		
	
	}

}
