package com.leisucn.test.mavenpack;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

/**
 * Created by sulei on 2017/9/12.
 */
public class App {

    //private final Logger logger = LogManager.getLogger(getClass());

    private final static Log logger = LogFactory.getLog(App.class);

    public App(){
        logger.info("initialize App instance");
    }


    public void say(String content){
        logger.info("Hello, " + content);
    }

    public static void main(String[] args) throws Exception{

        logger.info("App is started!");


        Properties properties = new Properties();
        properties.load(App.class.getResourceAsStream("/application.properties"));


        logger.info("at " + properties.getProperty("application.name"));


        Counter counter = getCounter();
        counter.increase();

        new App().say("Counter-" + counter.getCount());
    }


    public static Counter getCounter(){

        Counter counter = null;
        String beanName = "mycounter";

//        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("application.xml");
//        counter = (Counter)beanFactory.getBean(beanName);


        logger.info("begin loading spring...");

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(new ClassPathResource("application.xml"));


        logger.info("loading spring finished!");

        counter = (Counter)beanFactory.getBean(beanName);

        logger.info("get counter finished!");

        return counter;
    }


}
