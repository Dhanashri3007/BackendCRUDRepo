package com.infy.mailtask.serviceI;


import org.springframework.web.multipart.MultipartFile;

import com.infy.mailtask.Model.MailSender;

public interface MailSenderServiceI {

	void sendMail(MailSender m);

	void sendMailwithAttach(MailSender m, MultipartFile attach);

}
