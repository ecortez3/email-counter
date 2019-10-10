package corteze.entity;

public class EmailAddress {

    private String emailAddress;

    public EmailAddress () {

    }

    public EmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    private void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public EmailAddress withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;

        return this;
    }
}
