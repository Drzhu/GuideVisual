package com.guide.ascvd.pojo;

import java.io.Serializable;

public class ASCVD implements Serializable{

	private static final long serialVersionUID = 1L;

	private String serialName;//指标名称
	private String serialCount1;//指标统计个数
	private String serialCount2;//指标统计个数
	public String getSerialName() {
		return serialName;
	}
	public void setSerialName(String serialName) {
		this.serialName = serialName;
	}
	public String getSerialCount1() {
		return serialCount1;
	}
	public void setSerialCount1(String serialCount1) {
		this.serialCount1 = serialCount1;
	}
	public String getSerialCount2() {
		return serialCount2;
	}
	public void setSerialCount2(String serialCount2) {
		this.serialCount2 = serialCount2;
	}
	@Override
	public String toString() {
		return "ASCVD [serialName=" + serialName + ", serialCount1=" + serialCount1 + ", serialCount2=" + serialCount2
				+ "]";
	}

}
