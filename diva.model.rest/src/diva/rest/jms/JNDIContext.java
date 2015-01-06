package diva.rest.jms;

import java.util.Hashtable;

import javax.jms.TopicConnectionFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDIContext {
    private InitialContext initContext = null;
    private TopicConnectionFactory topicConnectionFactory = null;
    public static JNDIContext instance = null;

    private JNDIContext() {
        createInitialContext();
        createConnectionFactory();
    }

    public InitialContext getInitContext() {
        return initContext;
    }

    public TopicConnectionFactory getTopicConnectionFactory() {
        return topicConnectionFactory;
    }

    public static JNDIContext getInstance() {
        if (instance == null) {
            instance = new JNDIContext();
        }
        return instance;
    }



    /**
     * Create Connection factory with initial context
     */
    private void createConnectionFactory() {

        // create connection factory
        try {
            topicConnectionFactory = (TopicConnectionFactory) initContext.lookup("ConnectionFactory");
        } catch (NamingException e) {
        	e.printStackTrace();
            System.out.println("Can not create topic connection factory." + e);
        }
    }



    /**
     * Create Initial Context with given configuration
     */
    private void createInitialContext() {

        try {
        	Hashtable env = new Hashtable(); 
        	env.put("java.naming.factory.initial", 
				"org.wso2.andes.jndi.PropertiesFileInitialContextFactory");
        	env.put("connectionfactory.ConnectionFactory", 
				"amqp://admin:admin@clientid/carbon?brokerlist='tcp://94.75.243.141:5673'");
            initContext = new InitialContext(env);
        } catch (NamingException e) {
            System.out.println("Can not create initial context with given parameters." + e);
        }
    }
}