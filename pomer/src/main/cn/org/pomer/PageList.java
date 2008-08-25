package cn.org.pomer;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class PageList<E> {
	private long totalCount;
	private List<E> list;

	public PageList(long totalCount, List<E> list) {
		super();
		this.totalCount = totalCount;
		this.list = list;
	}

	public PageList() {
		super();
		this.totalCount = 0;
		this.list = new ArrayList<E>();
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
