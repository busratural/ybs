package mbs;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EPostaYolla {

	public  void EPostaYolla() {
		try {
	        System.out.println("deneme3");

			// e-postay� g�nderece�iniz adres
			String from = "T4MBSTEST@gmail.com";
			// hesab�n�z�n parolas�
			String pass = "53575357";
			// e-postan�n g�nderilece�i adresler
			String[] to = { "T4MBSTEST@gmail.com","hamdii.colak@gmail.com" };
			// host
			String host = "smtp.gmail.com";

			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.password", pass);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props, null);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			InternetAddress[] toAddress = new InternetAddress[to.length];
			for (int i = 0; i < to.length; i++) {
				toAddress[i] = new InternetAddress(to[i]);
			}

			for (int i = 0; i < toAddress.length; i++) {
				message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}
			// ba�l�k
			message.setSubject("Merhaba Java Uzman�!!!");
			// i�erik
			message.setText("ARIZA B�LD�R�M�  !!!");
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}