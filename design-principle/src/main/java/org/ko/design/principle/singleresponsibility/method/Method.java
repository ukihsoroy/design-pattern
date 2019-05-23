package org.ko.design.principle.singleresponsibility.method;

public class Method {

    /**
     * 职责不清晰
     * @param userName
     * @param address
     */
    public void updateUserInfo (String userName, String address) {
        userName = "K.O";
        address = "dalian";
    }

    /**
     * 职责不清晰
     * @param userName
     * @param properties
     */
    private void updateUserInfo (String userName, String... properties) {
        userName = "K.O";
    }

    /**
     * 职责清晰
     * @param username
     */
    private void updateUserName (String username) {
        username = "K.O";
    }

    /**
     * 职责清晰
     * @param address
     */
    private void updateUserAddress (String address) {
        address = "dalian";
    }

    /**
     * 这种情况也应该拆开
     * @param userName
     * @param address
     * @param bool
     */
    public void updateUserInfo (String userName, String address, boolean bool) {
        if (bool) {
            //todo something...
        } else {
            //todo something...
        }
    }
}
