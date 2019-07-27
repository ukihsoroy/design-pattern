package org.ko.adapter.notebook;

/**
 * 二项插座转三项插座的适配器
 */
public class TwoPlugAdapter implements ThreePlugIf {

	/**
	 * 组合
	 */
	private GBTowPlug plug;
	
	public TwoPlugAdapter (GBTowPlug plug) {
		this.plug = plug;
	}
	
	public void powerWithThree() {
		System.out.println("对象适配器-通过转化");
		plug.powerWithTwo();
	}
}
