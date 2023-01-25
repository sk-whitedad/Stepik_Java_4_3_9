import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        String content = "Посылка с подарками";
        int price = 100;
        String from = "Москва";
        String to = "Санкт-Петербург";

        Package pack = new Package(content, price);
        Sendable mailPackage = new MailPackage(from, to, pack);//создали посылку
        MailService thief = new Thief(101);//вор
        MailService spy = new Spy(Logger.getLogger(Class.class.getName()));//шпион
        MailService Inspector = new Inspector();//инспектор

        MailService[] mailServices = {thief, spy, Inspector};


        UntrustworthyMailWorker  untrust = new UntrustworthyMailWorker(mailServices);//передали почтальону посылку и список левых чуваков
        untrust.processMail(mailPackage);
        System.out.println("Конец");
    }
}
