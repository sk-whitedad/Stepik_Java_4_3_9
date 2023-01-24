public class Thief implements MailService {
    int price;
    int summPrice;


    public Thief(int price) {
        this.price = price;
        summPrice = 0;

    }

    public int getStolenValue() {
        return summPrice + price;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            Package newPackage = new Package("stones instead of " + ((MailPackage) mail).getContent().getContent(), 0);
            return new MailPackage(mail.getFrom(), mail.getTo(), newPackage);
        }
        return mail;
    }
}
