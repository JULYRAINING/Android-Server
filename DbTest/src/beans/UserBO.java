package beans;



/**
 * Created by SECONDHEAVEN on 2015/9/15.
 */
public class UserBO  {

	
	private int userId;
	
	private String minor;
	
	private String major;
	
	private int grade;
	
	private String name;
	
	private String signature;
	
	private int gender;
	
	private String userImage;

	public UserBO() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMinor() {
		return minor;
	}

	public void setMinor(String minor) {
		this.minor = minor;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	@Override
	public String toString() {
		return "UserBO [userId=" + userId + ", minor=" + minor + ", major=" + major + ", grade=" + grade + ", name="
				+ name + ", signature=" + signature + ", gender=" + gender + ", userImage=" + userImage + "]";
	}

	
   
}
