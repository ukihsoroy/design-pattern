package org.ko.adapter.notebook;

/**
 * 测试与应用类
 */
public class AdapterTest {

//  类适配器测试
//	public static void main(String[] args) {
//		ThreePlugIf three = new TwoPlugAdapterExtends();
//		NoteBook book = new NoteBook(three);
//		book.charge();
//	}

//  对象适配器测试
	public static void main(String[] args) {
		GBTowPlug two = new GBTowPlug();
		ThreePlugIf three = new TwoPlugAdapter(two);
		NoteBook book = new NoteBook(three);
		book.charge();
	}
}
