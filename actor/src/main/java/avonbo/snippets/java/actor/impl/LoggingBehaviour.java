package avonbo.snippets.java.actor.impl;

import java.util.logging.Logger;

import avonbo.snippets.java.actor.Behavior;

public class LoggingBehaviour<T> implements Behavior<T> {

    private final static Logger logger = Logger.getLogger(LoggingBehaviour.class.getName());

    @Override
    public boolean receive(T msg) {
        logger.info(msg.toString());
        return true;
    }

    @Override
    public void exception(Exception e) {
        logger.warning(e.toString());
    }
}
