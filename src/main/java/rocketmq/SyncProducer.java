package rocketmq;


import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;


public class SyncProducer {
    /*
    * Constructs a client instance with your account for accessing DefaultMQProducer
    */
    private static DefaultMQProducer producer = new DefaultMQProducer("2018-07-05");
    private static int initialState = 0;

    private SyncProducer() {

    }

    public static DefaultMQProducer getDefaultMQProducer(){
        if(producer == null){
            producer = new DefaultMQProducer("2018-07-05");

        }

        if(initialState == 0){
            producer.setNamesrvAddr("ip地址");
            producer.setInstanceName("hexiaobo");
            try {
                producer.start();
            } catch (MQClientException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }

            initialState = 1;
        }

        return producer;
    }

    public static void main(String[] args) {
        SyncProducer.getDefaultMQProducer();
    }
}
