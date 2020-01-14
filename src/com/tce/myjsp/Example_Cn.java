package com.tce.myjsp;

import java.util.ListResourceBundle;

public class Example_Cn extends ListResourceBundle {

	static final Object[][] contents = { { "count.one", "一个" }, { "count.two", "两个" }, { "count.three", "三个" }, };

	@Override
	protected Object[][] getContents() {
		return contents;
	}
}
