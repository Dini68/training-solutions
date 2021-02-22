package exam03retake01;

import _toto.ppp.A;

import java.util.ArrayList;
import java.util.List;

public class MailBox {

    private List<Mail> mails = new ArrayList<>();

    public List<Mail> getMails() {
        return new ArrayList<>(mails);
    }

    public List<Mail> findByCriteria(String criteria) {
        List<Mail> result = new ArrayList<>();
        if (criteria.startsWith("from:")) {
            String temp = criteria.substring(5);
            for (Mail m: getMails()) {
                if (m.getFrom().getName().equals(temp) ||
                m.getFrom().getEmail().equals(temp)) {
                    result.add(m);
                }
            }
            return result;
        }
        if (criteria.startsWith("to:")) {
            String temp = criteria.substring(3);
            for (Mail m: getMails()) {
                for (Contact c: m.getTo()) {
                    if (c.getName().equals(temp) ||
                    c.getEmail().equals(temp)) {
                        result.add(m);
                    }
                }
            }
            return result;
        }
        for (Mail m: getMails()) {
            if (m.getMessage().contains(criteria) ||
                m.getSubject().contains(criteria)) {
                result.add(m);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("from:hjkhhkjh".substring(5));

    }
}
