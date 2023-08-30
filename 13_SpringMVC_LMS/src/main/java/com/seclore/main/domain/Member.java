package com.seclore.main.domain;

public class Member {
	private int id, issueCount;
	private String name, type, status;

	public Member() {
	}

	public Member(int id, String name, String type, String status, int issueCount) {
		super();
		this.id = id;
		this.issueCount = issueCount;
		this.name = name;
		this.type = type;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIssueCount() {
		return issueCount;
	}

	public void setIssueCount(int issueCount) {
		this.issueCount = issueCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", issueCount=" + issueCount + ", name=" + name + ", type=" + type + ", status="
				+ status + "]";
	}

}
