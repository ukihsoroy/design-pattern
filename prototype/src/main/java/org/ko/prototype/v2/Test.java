package org.ko.prototype.v2;

/**
 * 测试与应用
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();
        mail.setContent("初始化模板");

        System.out.println("初始化mail: " + mail.toString());
        for (int i = 0; i < 10; i++) {
            Mail mailTemp = (Mail) mail.clone(); //并没有调用Mail构造器
            mailTemp.setName("K.O_" + i);
            mailTemp.setEmailAddress("ko.shen_" + i + "@hotmail.com");
            mailTemp.setContent("恭喜您中奖了。");
            MailUtil.sendMail(mailTemp);
            System.out.println("克隆的mailTemp: " + mailTemp.toString());
        }
        MailUtil.saveOriginMailRecord(mail);
    }
}
