package com.tce.myjsp;

import java.util.ListResourceBundle;

public class Example_Cn extends ListResourceBundle {

	static final Object[][] contents = { { "count.one", "һ��" }, { "count.two", "����" }, { "count.three", "����" }, };

	@Override
	protected Object[][] getContents() {
		return contents;
	}
}
