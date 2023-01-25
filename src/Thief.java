public class Thief implements MailService {
    int minPrice;//минимальная цена посылки, которую вор забирает
    int summPrice;//суммарная стоимость посылок

    public Thief(int minPrice) {
        this.minPrice = minPrice;
        summPrice = 0;
    }

    public int getStolenValue(int price) {
        return summPrice += price;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (minPrice <= ((MailPackage) mail).getContent().getPrice()) {
            if (mail instanceof MailPackage) {
                Package newPackage = new Package("stones instead of " + ((MailPackage) mail).getContent().getContent(), 0);
                summPrice = getStolenValue(((MailPackage) mail).getContent().getPrice());
                return new MailPackage(mail.getFrom(), mail.getTo(), newPackage);
            }
        }
        1
        return mail;
    }
}
