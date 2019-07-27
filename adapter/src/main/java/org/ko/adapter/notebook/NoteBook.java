package org.ko.adapter.notebook;

/**
 * 笔记本类
 */
public class NoteBook {
	
	private ThreePlugIf plug;

	/**
	 * 只接收使用三项电充电
	 * @param plug
	 */
	public NoteBook (ThreePlugIf plug) {
		this.plug = plug;
	}
	
	/**
	 * 使用插座充电
	 */
	public void charge () {
		plug.powerWithThree();
	}
}
