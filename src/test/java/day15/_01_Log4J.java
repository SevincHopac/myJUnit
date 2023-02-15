package day15;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class _01_Log4J {

    private  static Logger logger = LogManager.getLogger(_01_Log4J.class.getName());
    @Test
    public void log4JTest() {

        //        logger objesi ile yazdirma islemini yap
        logger.fatal("Fatal Log!");
        logger.error("Error Log!");
        logger.warn("Warn Log!");
        logger.debug("Debug Log!");
        logger.info("Info Log!");

    }
}
