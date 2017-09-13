package com.leisucn.test.mavenpack;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by sulei on 2017/9/12.
 */
public class Counter {

    private Logger logger = LogManager.getLogger(getClass());

    private int count = 0;

    public Counter(){
        logger.info("initialize Counter instance");
    }


    public int getCount() {
        return count;
    }

    public void increase(){
        this.count = this.count + 1;
    }
}
