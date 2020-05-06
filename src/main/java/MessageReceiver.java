import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageReceiver implements MessageListener {

    private static final TraceOrgLogger _logger = new TraceOrgLogger(MessageReceiver.class, "Consumer");
    private MessageConsumer consumer;
    private Session session;
    private Connection con;
    AuthConf authConf;

    public MessageReceiver(AuthConf authConf) throws Exception {

        this.authConf = authConf;
        //ConnectionFactory factory =  new ActiveMQConnectionFactory("vm://localhost");
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(authConf.getBrokerURL().trim());
        connectionFactory.setUserName(authConf.getUserName().trim());
        connectionFactory.setPassword(authConf.getPassword().trim());
        this.con = connectionFactory.createConnection();
        con.start();

        this.session = con.createSession(false,
                Session.AUTO_ACKNOWLEDGE);
        Topic prodtopic = session.createTopic(authConf.getTopicName().trim());
           this.consumer = session.createConsumer(prodtopic);
        consumer.setMessageListener(this);
    }


    public void onMessage (Message message) {


        if (message instanceof TextMessage) {
            TextMessage tm = (TextMessage) message;
            try {
                 System.out.printf("Message received: %s",
                        tm.getText());
                 _logger.info("Message received: "+tm.getText());
            } catch (JMSException e) {
                _logger.error(e);
                throw new RuntimeException(e);
            }
        }
    }

    public void destroy () throws JMSException {
        con.close();
    }
}
