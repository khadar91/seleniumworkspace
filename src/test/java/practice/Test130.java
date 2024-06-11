package practice;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

public class Test130 {
	@Test
	public void method1() throws Exception
	{
		//create object to "properties" class and send "mailing server" details
		Properties props=new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mal.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		//this will handle the complete Authenticaton(credentials)
		Authenticator auth=new Authenticator()
				{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication("vallikhadar15","aeuaaaoeaqcxkqha");
			}
				};
				//create object of session class by using properties and authentication info
				Session s=Session.getDefaultInstance(props, auth);
				//create object to Message class and set details
				Message msg=new MimeMessage(s);
				msg.setFrom(new InternetAddress("vallikhadar15@gmail.com"));
				msg.setRecipients(Message.RecipientType.TO, 
						InternetAddress.parse("venuthurlakhadarvalli@gmail.com,vallikhadar15@gmail.com"));
				msg.setSubject("Teastinf Subject");
				//create object to add multimedia type content
				BodyPart bodymsg1=new MimeBodyPart();
				bodymsg1.setText("Hi\n please refer attached file");
				BodyPart bodymsg2=new MimeBodyPart();
				String filename="D:\\Selenium264\\E__Model Resume Exp.doc";
				DataSource source=new FileDataSource(filename);
				bodymsg2.setDataHandler(new DataHandler(source));
				bodymsg2.setFileName(filename);
				//create object or MmeMultpart class
				Multipart mpart=new MimeMultipart();
				mpart.addBodyPart(bodymsg1);
				mpart.addBodyPart(bodymsg2);
				msg.setContent(mpart);
				//Finally send the mail
				Transport.send(msg);
				System.out.println("===== Email Sent");
	}

}
