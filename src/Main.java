public class Main {
    public static void main(String[] args) {
        String content = "Посылка с подарками";
        int price = 100;
        String from = "Москва";
        String to = "Санкт-Петербург";
        Package pack = new Package(content, price);
        Sendable mailPackage = new MailPackage(from, to, pack);//создали посылку
        MailService thief = new Thief(10);

        MailService[] mailServices = {thief};


        MailService untrust = new UntrustworthyMailWorker(mailServices, mailPackage);//передали почтальону посылку и список левых чуваков

        System.out.println();
    }
}
