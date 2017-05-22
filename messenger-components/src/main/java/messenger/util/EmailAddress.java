package messenger.util;

import java.io.Serializable;

public class EmailAddress implements Serializable{
    private static final long serialVersionUID = -8396186007472766181L;

    private String recipientName;
    private String domainAddress;

    public EmailAddress(String recipientName, String domainAddress) {
        this.recipientName = recipientName;
        this.domainAddress = domainAddress;
    }

    public String asString(){
        return recipientName + "@" + domainAddress;
    }

    @Override
    public String toString() {
        return asString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof EmailAddress))
            return false;

        EmailAddress that = (EmailAddress) o;

        if (!getRecipientName().equals(that.getRecipientName()))
            return false;
        return getDomainAddress().equals(that.getDomainAddress());
    }

    @Override
    public int hashCode() {
        int result = getRecipientName().hashCode();
        result = 31 * result + getDomainAddress().hashCode();
        return result;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getDomainAddress() {
        return domainAddress;
    }
}
