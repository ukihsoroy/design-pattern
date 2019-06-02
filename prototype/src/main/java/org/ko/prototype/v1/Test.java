package org.ko.prototype.v1;

public class Test {

    public static void main(String[] args) {
        Mail mail = new Mail();
        mail.setContent("初始化模板");

        for (int i = 0; i < 10; i++) {
            mail.setName("K.O_" + i);
            mail.setEmailAddress("ko.shen_" + i + "@hotmail.com");
            mail.setContent("恭喜您中奖了。");
            MailUtil.sendMail(mail);
        }
        MailUtil.saveOriginMailRecord(mail);
    }
}
