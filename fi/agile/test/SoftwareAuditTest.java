package fi.agile.test;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * @author Shweta Manek
 * @version 1.0
 */
public class SoftwareAuditTest {
    static Logger logger = Logger.getLogger(SoftwareAuditTest.class.getName());

    /**
     * @param args
     */
    public static void main(String[] args) {
        int x;
        Scanner scan = null;
        UserRegistery registery = new UserRegistery();
        try (Scanner in = new Scanner(System.in)) {
            logger.info("Please enter a length of log: ");
            x = in.nextInt();
            if (1 <= x && x <= 1000) {
                logger.info("Please enter description: ");
                for (int i = 0; i < x; i++) {
                    scan = new Scanner(System.in);
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    String name = parts[1].trim();
                    String action = parts[0].trim();
                    if (action.equalsIgnoreCase("entry")) {
                        registery.userEntered(name);
                    } else {
                        registery.userExited(name);
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
