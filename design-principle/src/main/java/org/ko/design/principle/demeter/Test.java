package org.ko.design.principle.demeter;

public class Test {

    public static void main(String[] args) {
        Boss boss = new Boss();
        TeamLeader leader = new TeamLeader();
        boss.commandCheckNumber(leader);
    }
}
