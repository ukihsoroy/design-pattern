package org.ko.flyweight.v1;

/**
 * 部门经理
 */
public class Manager implements Employee {


    /**
     * 内部状态
     */
    private String title = "部门经理";

    /**
     * 外部状态，需要在应用层引入，就是外部状态
     */
    private String department;

    private String reportContent;

    public Manager(String department) {
        this.department = department;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    @Override
    public void report() {
        System.out.println(reportContent);
    }

}
