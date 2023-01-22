package model;

public class Employees {
	private Long idEmployees;
	private String fname;
	private String lname;
	private String city;
	private String phoneNumber;
	private String adress;
	private int salary;
	private Long idManager;

	public Employees() {

	}

	public Long getIdEmployees() {
		return idEmployees;
	}

	public void setIdEmployees(Long idEmployees) {
		this.idEmployees = idEmployees;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Long getIdManager() {
		return idManager;
	}

	public void setIdManager(Long idManager) {
		this.idManager = idManager;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((idEmployees == null) ? 0 : idEmployees.hashCode());
		result = prime * result + ((idManager == null) ? 0 : idManager.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employees other = (Employees) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (idEmployees == null) {
			if (other.idEmployees != null)
				return false;
		} else if (!idEmployees.equals(other.idEmployees))
			return false;
		if (idManager == null) {
			if (other.idManager != null)
				return false;
		} else if (!idManager.equals(other.idManager))
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employees [idEmployees=" + idEmployees + ", fname=" + fname + ", lname=" + lname + ", city=" + city
				+ ", phoneNumber=" + phoneNumber + ", adress=" + adress + ", salary=" + salary + ", idManager="
				+ idManager + "]";
	}
	
	
}
