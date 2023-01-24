public class UntrustworthyMailWorker implements MailService {
    MailService[] mailServices;
    Sendable sendable;

    public UntrustworthyMailWorker(MailService[] mailServices, Sendable sendable) {
        this.mailServices = mailServices;
        this.sendable = sendable;
        processMail(sendable);
    }

    public RealMailService getRealMailService() {
        return null;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        return null;
    }
}
