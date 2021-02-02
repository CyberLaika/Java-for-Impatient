package theory.AnotherOne;

public class Contact {
    String phoneNumber;
    String mail;
    String address;
    String webSite;
    String comment;

    public Contact(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public Contact(String phoneNumber, String mail, String address, String webSite, String comment) {
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.address = address;
        this.webSite = webSite;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", mail='" + mail + '\'' +
                ", address='" + address + '\'' +
                ", webSite='" + webSite + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
