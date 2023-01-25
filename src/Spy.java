import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService {
    Logger logger;
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";
    public Spy(Logger logger) {
        this.logger = logger;
    }


    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage) {
            MailMessage mailMessage = (MailMessage) mail;
            String from = mailMessage.getFrom();
            String to = mailMessage.getTo();
            if (from.equals(AUSTIN_POWERS) || to.equals(AUSTIN_POWERS)){// == AUSTIN_POWERS
                logger.warning("Detected target mail correspondence: from " + ((MailMessage) mail).from + " to " + ((MailMessage) mail).to + "\"" + ((MailMessage) mail).getMessage() + "\"");
            } else {
                logger.info("Usual correspondence: from " + ((MailMessage) mail).from + " to " + ((MailMessage) mail).to + "");
            }
        }
        return mail;
    }
}
