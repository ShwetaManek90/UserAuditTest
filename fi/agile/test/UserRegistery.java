package fi.agile.test;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author Shweta Manek
 * @version 1.0
 */
public class UserRegistery {
    static Logger logger = Logger.getLogger(UserRegistery.class.getName());

    Map<String, Integer> nameAndCount = new HashMap<>();

    public void userEntered(String userName) {
        userAction(userName, "entered");
    }

    public void userExited(String userName) {
        userAction(userName, "exited");
    }

    private void userAction(String user, String action) {
        boolean anomaly = false;

        Integer count = nameAndCount.computeIfAbsent(user, k -> 0);
        nameAndCount.put(user, count);

        if (action.equalsIgnoreCase("entered") && nameAndCount.get(user) % 2 == 1) {
            anomaly = true;
        }

        if (action.equalsIgnoreCase("exited") && nameAndCount.get(user) % 2 == 0) {
            anomaly = true;
        }

        if (!anomaly) {
            nameAndCount.put(user, ++count);
        }

        logAction(user, action, anomaly);

    }

    private void logAction(String user, String action, boolean anomaly) {
        if (anomaly) {
            logger.info(user + " " + action + " " + "(ANOMALY)");
        } else {
            logger.info(user + " " + action);
        }

    }
}
