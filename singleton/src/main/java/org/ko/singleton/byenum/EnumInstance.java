package org.ko.singleton.byenum;

public enum EnumInstance {

    INSTANCE {
        protected void  printTest () {
            System.out.println("K.O print Test!");
        }
    };

    private Object data;

    protected abstract void printTest();

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumInstance getInstance() {
        return INSTANCE;
    }

}
