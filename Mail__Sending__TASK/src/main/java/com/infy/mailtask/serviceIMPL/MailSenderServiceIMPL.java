package com.infy.mailtask.serviceIMPL;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.infy.mailtask.Model.MailSender;
import com.infy.mailtask.serviceI.MailSenderServiceI;

@Service
public class MailSenderServiceIMPL implements MailSenderServiceI {

	@Autowired
	JavaMailSender jm;

	@Override
	public void sendMail(MailSender m) {
		System.out.println("in Impl");
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setText(m.getTextMsg());
		sm.setTo(m.getTo());
		sm.setSubject(m.getSubject());
		sm.setFrom(m.getFrom());
		System.out.println("777");
		jm.send(sm);
		System.out.println("end");
		System.out.println("Sent");
	}

	@Override
	public void sendMailwithAttach(MailSender m, MultipartFile attach){
		MimeMessage mm=jm.createMimeMessage();
	try {
		MimeMessageHelper sm=new MimeMessageHelper(mm,true);
		sm.setText(m.getTextMsg());
		sm.setTo(m.getTo());
		sm.setSubject(m.getSubject());
		sm.setFrom(m.getFrom());
		sm.addAttachment(attach.getOriginalFilename(), attach);

	}
	catch (MessagingException e) {
     e.printStackTrace();
	}
		jm.send(mm);
	}

}
