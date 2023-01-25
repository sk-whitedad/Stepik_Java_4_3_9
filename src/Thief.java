public class Thief implements MailService {
    int minPrice;//минимальная цена посылки, которую вор забирает
    int stolenPrice = 0;//суммарная стоимость украденых посылок

    public Thief(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getStolenValue() {
        return stolenPrice;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (minPrice <= ((MailPackage) mail).getContent().getPrice()) {
            if (mail instanceof MailPackage) {
                Package newPackage = new Package("stones instead of " + ((MailPackage) mail).getContent().getContent(), 0);
                stolenPrice +=((MailPackage) mail).getContent().getPrice();
                return new MailPackage(mail.getFrom(), mail.getTo(), newPackage);
            }
        }
        return mail;
    }
}
