package __practice;

import java.util.ArrayList;
import java.util.List;

public class MailBox {

    private final List<Mail> mails = new ArrayList<>();

    public void addMail(Mail mail) {
        mails.add(mail);
    }

    public List<Mail> getMails() {
        return new ArrayList<>(mails);
    }

    public List<Mail> findByCriteria(String criteria) {
        List<Mail> result = new ArrayList<>();
        if (criteria.startsWith("from:")) {
            return criteriaIsFrom(criteria, result);
        }
        if (criteria.startsWith("to:")) {
            return criteriaIsTo(criteria, result);
        }
        for (Mail m: getMails()) {
            if (m.getSubject().contains(criteria) ||
                m.getMessage().contains(criteria)) {
                result.add(m);
            }
        }
        return result;
    }

    private List<Mail> criteriaIsTo(String criteria, List<Mail> result) {
        String criteriaText = criteria.substring(3);
        for (Mail m: getMails()) {
            for (Contact c: m.getTo()) {
                if (c.getName().equals(criteriaText) ||
                    c.getEmail().equals(criteriaText)) {
                    result.add(m);
                }
            }
        }
        return result;
    }

    private List<Mail> criteriaIsFrom(String criteria, List<Mail> result) {
        String criteriaText = criteria.substring(5);
        for (Mail m: getMails()) {
            if (criteriaText.equals(m.getFrom().getName()) ||
                    criteriaText.equals(m.getFrom().getEmail())) {
                result.add(m);
            }
        }
        return result;
    }
}
