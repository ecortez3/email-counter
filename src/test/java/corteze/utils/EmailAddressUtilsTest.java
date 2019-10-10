package corteze.utils;

import corteze.entity.EmailAddress;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;

import java.util.Arrays;

import static org.junit.Assert.*;

public class EmailAddressUtilsTest {

    @Test
    public void countUniqueEmailAddresses() {
        assertEquals(2, EmailAddressUtils.countUniqueEmailAddresses(
                Arrays.asList(new EmailAddress().withEmailAddress("robertmark@gmail.com"),
                        new EmailAddress().withEmailAddress("robert_mark@gmail.com"),
                        new EmailAddress().withEmailAddress("robert.mark@gmail.com"),
                        new EmailAddress().withEmailAddress("robert.mar.k@gmail.com"),
                        new EmailAddress().withEmailAddress("robertmark+anything@gmail.com"),
                        new EmailAddress().withEmailAddress("robert.mark+anything@gmail.com")))
        );
    }

    @Test
    public void stripEmailAddress() {
        String testComparator = "robertmark@gmail.com";
        String underscore = "robert_mark@gmail.com";
        String onePeriod = "robert.mark@gmail.com";
        String twoPeriod = "robert.mar.k@gmail.com";
        String plus = "robertmark+anything@gmail.com";
        String periodPlus = "robert.mark+anything@gmail.com";
        assertNotEquals(testComparator, underscore);
        assertNotEquals(testComparator, onePeriod);
        assertNotEquals(underscore, onePeriod);

        assertEquals(testComparator, EmailAddressUtils.stripEmailAddress(testComparator));
        assertNotEquals(testComparator, EmailAddressUtils.stripEmailAddress(underscore));
        assertEquals(testComparator, EmailAddressUtils.stripEmailAddress(onePeriod));
        assertEquals(testComparator, EmailAddressUtils.stripEmailAddress(twoPeriod));
        assertEquals(testComparator, EmailAddressUtils.stripEmailAddress(plus));
        assertEquals(testComparator, EmailAddressUtils.stripEmailAddress(periodPlus));
    }

    @Test
    public void cleanAddressName() {
        String testComparator = "robertmark";
        String underscore = "robert_mark";
        String onePeriod = "robert.mark";
        String twoPeriod = "robert.mar.k";
        String plus = "robertmark+anything";
        String periodPlus = "robert.mark+anything";
        assertNotEquals(testComparator, underscore);
        assertNotEquals(testComparator, onePeriod);
        assertNotEquals(underscore, onePeriod);

        assertEquals(testComparator, EmailAddressUtils.cleanAddressName(testComparator));
        assertNotEquals(testComparator, EmailAddressUtils.cleanAddressName(underscore));
        assertEquals(testComparator, EmailAddressUtils.cleanAddressName(onePeriod));
        assertEquals(testComparator, EmailAddressUtils.cleanAddressName(twoPeriod));
        assertEquals(testComparator, EmailAddressUtils.cleanAddressName(plus));
        assertEquals(testComparator, EmailAddressUtils.cleanAddressName(periodPlus));


    }
}