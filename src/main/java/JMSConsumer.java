import java.io.File;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class JMSConsumer {
    private static final TraceOrgLogger _logger = new TraceOrgLogger(JMSConsumer.class, "Consumer");
    static ObjectMapper mapper;
      public static void main (String[] args)  {
       try {
           doinit();
           AuthConf authConf = loadConnectionDetails(args[0]);
           MessageReceiver receiver = validateSender(authConf);
           _logger.info("Sender is authenticated");

           System.out.println("Consumer is waiting !!!!");
// Infinte wait
          Object lock = new Object();
           synchronized (lock) {
               lock.wait();
           }
        //   Thread.sleep(1000*60*5); // 5 mins timeout
           receiver.destroy();
           System.out.println("Reciever has been deleted");
           System.out.println("Exit system");
       }
       catch (Exception e)
       {
           _logger.error(e);
       }
    }

    private static void doinit() {
        mapper = new ObjectMapper(new YAMLFactory());
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
    }
    private static AuthConf loadConnectionDetails(String yamlPath) throws Exception {
        File file = new File(yamlPath);
        return mapper.readValue(file, AuthConf.class);
    }


    private static MessageReceiver validateSender(AuthConf authConf) throws Exception {
        try {
            return new MessageReceiver(authConf);
        } catch (Exception e) {
            System.out.println("Credentials are not Matching");
            _logger.error(e);
            throw new Exception(e);
        }
    }
}
