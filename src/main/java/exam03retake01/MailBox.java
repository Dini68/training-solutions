package exam03retake01;

import java.util.ArrayList;
import java.util.List;

public class MailBox {

    private List<Mail> mails = new ArrayList<>();

    public List<Mail> getMails() {
        return new ArrayList<>(mails);
    }

    public void addMail(Mail mail) {
        mails.add(mail);

    }

    public List<Mail> findByCriteria(String criteria) {
        if (criteria.startsWith("to:")) {
            return findByTo(criteria.substring(3));
        }
        else if (criteria.startsWith("from:")) {
            return findByFrom(criteria.substring(5));
        }
        else {
            return findByContent(criteria);
        }
    }

    private List<Mail> findByContent(String criteria) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail: getMails()) {
            if (mail.getSubject().contains(criteria) ||
                    mail.getMessage().contains(criteria)) {
                result.add(mail);
            }
        }
        return result;
    }

    private List<Mail> findByFrom(String substring) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail: getMails()) {
            if (mail.getFrom().getName().equals(substring) ||
                    mail.getFrom().getEmail().equals(substring)) {
                result.add(mail);
            }
        }
        return result;
    }

    private List<Mail> findByTo(String substring) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail: getMails()) {
            boolean isContain = false;
            for (Contact c: mail.getTo()) {
                if (c.getName().equals(substring) || c.getEmail().equals(substring)) {
                    isContain = true;
                }
            }
            if (isContain) {
                result.add(mail);
            }
        }
        return result;
    }
}
