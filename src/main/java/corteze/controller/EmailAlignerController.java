package corteze.controller;

import corteze.entity.EmailAddress;
import corteze.utils.EmailAddressUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmailAlignerController {

    /**
     * RequestMapping: /verify-emails
     *
     * Service which receives a list of email addresses and returns the number of unique
     * email addresses in the provided list as an integer.
     *
     * Params: emails - List<EmailAddress>
     * Method: GET
     * Return: Integer - Number of unique email addresses in List<EmailAddress>
     * */
    @RequestMapping("/verify-emails")
    public int verifyEmails(@RequestParam(value = "emails")List<EmailAddress> emails) {
        return EmailAddressUtils.countUniqueEmailAddresses(emails);
    }
}
