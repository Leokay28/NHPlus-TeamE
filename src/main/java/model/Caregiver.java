package model;

import java.util.ArrayList;
import java.util.List;


/**
 * Caregivers work in a NURSING home and are treating the patients.
 */
public class Caregiver extends Person {
    private long cid;
    private String telephone;
    private List<Treatment> allTreatments = new ArrayList<Treatment>();


    /**
     * constructs a caregiver from the given params.
     * @param firstname
     * @param surname
     * @param telephone
     */
    public Caregiver(String firstname, String surname, String telephone) {
        super(firstname, surname);
        this.telephone = telephone;
    }

    /**
     * constructs a caregiver from the given params.
     * @param cid
     * @param firstname
     * @param surname
     * @param telephone
     */
    public Caregiver(long cid, String firstname, String surname, String telephone) {
        super(firstname, surname);
        this.cid = cid;
        this.telephone = telephone;
    }

    /**
     *
     * @return caregiver id
     */
    public long getCid() {
        return cid;
    }

    /**
     *
     * @return telephone as string
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     *
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * adds a treatment to the treatment-list, if it does not already contain it.
     * @param m Treatment
     * @return true if the treatment was not already part of the list. otherwise false
     */
    public boolean add(Treatment m) {
        if (!this.allTreatments.contains(m)) {
            this.allTreatments.add(m);
            return true;
        }
        return false;
    }

    /**
     *
     * @return string-representation of the caregiver
     */
    public String toString() {
        return "Caregiver" + "\nMNID: " + this.cid +
                "\nFirstname: " + this.getFirstName() +
                "\nSurname: " + this.getSurname() +
                "\nTelephone: " + this.telephone +
                "\n";
    }
}
