package corteze.utils;

import corteze.entity.EmailAddress;

import java.util.List;
import java.util.stream.Collectors;

public class EmailAddressUtils {

    /**
     * Return the number of unique email addresses in the provided list of EmailAddress objects.
     * If initial list is empty or has only 1 entry, then no comparisons must be done.
     * NOTE: Assumption is that all email addresses in the objects are valid/properly formatted email addresses.
     *
     * addressList - List<EmailAddress>
     *
     * return: int - number of unique email addresses
     * */
    public static int countUniqueEmailAddresses(List<EmailAddress> addressList) {
        if (addressList.size() <= 1) return addressList.size();

        List<String> uniqueAddresses = addressList
                .stream()
                .map(address -> stripEmailAddress(address.getEmailAddress()))
                .distinct()
                .collect(Collectors.toList());

        return uniqueAddresses.size();
    }

    /**
     * Separates the email address into two pieces: address and domain.
     * Once address is separated from domain, it is cleaned up, returning
     * a simplified email address which will be used for comparison.
     * NOTE: Assumes all email addresses are properly formatted.
     *
     * emailAddress - String
     * returns: String - clean, simplified email address
     * */
    static String stripEmailAddress(String emailAddress) {
        int atCharIndex = emailAddress.indexOf("@");
        String addressName = emailAddress.substring(0, atCharIndex);
        String addressDomain = emailAddress.substring(atCharIndex);

        return cleanAddressName(addressName) + addressDomain.toLowerCase();
    }

    /**
     * Removes additional tags from address (all characters following a '+')
     * and all '.' found in address.
     *
     * emailAddress - String
     * returns: String - address without periods and all chars after a '+'
     * */
    static String cleanAddressName(String emailAddress) {
        int plusCharIndex = emailAddress.indexOf("+");

        if (plusCharIndex != -1)
            emailAddress = emailAddress.substring(0, plusCharIndex);

        return emailAddress.replaceAll("\\.", "").toLowerCase();
    }
}
