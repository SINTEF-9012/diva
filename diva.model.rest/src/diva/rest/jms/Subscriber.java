package diva.rest.jms;

import java.io.UnsupportedEncodingException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSubscriber;

import diva.rest.resources.PubSub;

public class Subscriber implements MessageListener {

	public static void startListening() throws JMSException {
	//public static void main(String[] args) throws JMSException{
		
		System.setProperty("java.naming.factory.initial", 
				"org.wso2.andes.jndi.PropertiesFileInitialContextFactory");
		
		System.setProperty("connectionfactory.ConnectionFactory", 
				"amqp://admin:admin@clientid/carbon?brokerlist='tcp://94.75.243.141:5673'");
		
		TopicConnectionFactory topicConnectionFactory = JNDIContext.getInstance().getTopicConnectionFactory();
		TopicConnection topicConnection = topicConnectionFactory.createTopicConnection();
		
		
		Session session = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("tp");
        //session.createB
        
        TopicSubscriber  sub = session.createDurableSubscriber(topic, "testSubscripber2");
        
        //topicConnection.setClientID("testid2");
		sub.setMessageListener(new Subscriber());
        topicConnection.start();
        System.out.println("started");       
	}

	@Override
	public void onMessage(Message arg0) {
		
		//System.out.println(arg0);
		try {
			TextMessage textMessage = (TextMessage) arg0;
			String s = textMessage.getText();
			System.out.println(s);
			new PubSub().cepEvent(s);
		} catch (JMSException e) {
			
			e.printStackTrace();
		}
	}

}
