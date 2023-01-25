public class Inspector implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            Package pack = ((MailPackage) mail).getContent();
            String content = pack.getContent();
            if (content.indexOf("stones") >= 0){
                throw new StolenPackageException();
            } else if (content == "weapons" || content == "banned substance") {
             throw new IllegalPackageException();
            }
        }
        return mail;
    }
}
