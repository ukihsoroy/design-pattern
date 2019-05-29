package org.ko.uml;

import java.util.List;


/**
 * 大雁群
 */
public class BigWildGooseGroup {

    public List<BigWildGoose> bigWildGooses;


    public void oneFly() {
        System.out.println("一字飞行");
    }

    public void vfly() {
        System.out.println("V字飞行");
    }

    public List<BigWildGoose> getBigWildGooses() {
        return bigWildGooses;
    }

    public void setBigWildGooses(List<BigWildGoose> bigWildGooses) {
        this.bigWildGooses = bigWildGooses;
    }
}
