package edu.cssp.beans;

public class Clubs {
	private Integer id;
	private String name;
	private String contact_name;
	private String phone_no;
	private int dimension_id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getContact_name() {
		return contact_name;
	}

	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public int getDimension_id() {
		return dimension_id;
	}

	public void setDimension_id(int dimension_id) {
		this.dimension_id = dimension_id;
	}
}
