public class UntrustworthyMailWorker implements MailService {
    MailService[] mailServices;
    MailService realMailService = new RealMailService();

    public UntrustworthyMailWorker(MailService[] mailServices) {
        this.mailServices = mailServices;
    }

    public MailService getRealMailService() {
        return realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {

        Sendable processed = mail;

        for (int i = 0; i < mailServices.length; i++) {

            processed = mailServices[i].processMail(processed);

        }

        return realMailService.processMail(mail);


    }
}
