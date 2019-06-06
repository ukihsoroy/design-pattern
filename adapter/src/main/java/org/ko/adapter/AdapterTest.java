package org.ko.adapter;


import org.ko.adapter.extend.TwoPlugAdapterExtends;
import org.ko.adapter.grouping.GBTowPlug;
import org.ko.adapter.grouping.NoteBook;
import org.ko.adapter.grouping.ThreePlugIf;
import org.ko.adapter.grouping.TwoPlugAdapter;

public class AdapterTest {

	public static void main(String[] args) {
		GBTowPlug two = new GBTowPlug();
		ThreePlugIf three = new TwoPlugAdapter(two);
		
		NoteBook book = new NoteBook(three);
		book.charge();
		
		three = new TwoPlugAdapterExtends();
		book = new NoteBook(three);
		book.charge();
	}
}
