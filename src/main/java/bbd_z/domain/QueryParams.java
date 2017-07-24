package bbd_z.domain;

import java.util.HashMap;

/**
 * 查询参数类
 *
 * @author wanggang
 *
 */
public class QueryParams {
	//类型
	private String type = "";

 	//帐号信息
	private String account = "";
	private String accountName = "";
	private String accountType = "";

	//位置信息
	private String address = "";
	private String ci = "";
	private Double latitude = 0.0;
	private Double longitude = 0.0;
	private String timeStart = "";
	private String timeEnd = "";

	//时间信息
	@Override
	public String toString() {
		return "QueryParams{" +
				"type='" + type + '\'' +
				", account='" + account + '\'' +
				", accountName='" + accountName + '\'' +
				", accountType='" + accountType + '\'' +
				", address='" + address + '\'' +
				", ci='" + ci + '\'' +
				", latitude=" + latitude +
				", longitude=" + longitude +
				", timeStart='" + timeStart + '\'' +
				", timeEnd='" + timeEnd + '\'' +
				'}';
	}

	public QueryParams() {
		//
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
