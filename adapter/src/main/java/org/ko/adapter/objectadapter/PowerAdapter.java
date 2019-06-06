package org.ko.adapter.objectadapter;

public class PowerAdapter implements DC5 {
    private AC220 ac = new AC220();

    @Override
    public int outputDC5() {
        int adapterInput = ac.outputAC220V();

        //变压器
        int adapterOutput = adapterInput / 44;

        System.out.println("适用PowerAdapter输入AC:" + adapterInput + ", 转化后输出为：" + adapterOutput);

        return adapterOutput;
    }
}
