package application;

public class WebSite {
protected String webAddress, siteName;

public WebSite() {
	this.siteName = "";
	this.webAddress = "";
}
public WebSite(String siteName, String webAddress) {
	this.siteName = siteName;
	this.webAddress = webAddress;
}

public String getSiteName() {
	return this.siteName;
}
public void setSiteName(String siteName) {
	this.siteName = siteName;
}
public String getWebAddress() {
	return this.webAddress;
}
public void setWebAddress(String webAddress) {
	this.webAddress = webAddress;
}
public boolean equals(Object o) {
	WebSite b = (WebSite)o;

if(this.siteName.equalsIgnoreCase(b.getSiteName()) && this.webAddress.equalsIgnoreCase(b.getWebAddress()))
return true;
else
return false;
}

public String toString() {
	return "Website name: " + this.siteName + "\nWeb address : " + this.webAddress;
}
}
