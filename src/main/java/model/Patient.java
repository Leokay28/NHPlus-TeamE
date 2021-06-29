package model;

import utils.DateConverter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Patients live in a NURSING home and are treated by nurses.
 */
public class Patient extends Person {
    private long pid;
    private LocalDate dateOfBirth;
    private String careLevel;
    private String roomnumber;
    private String assets;
    private List<Treatment> allTreatments = new ArrayList<Treatment>();

    /**
     * constructs a patient from the given params.
     * @param firstName
     * @param surname
     * @param dateOfBirth
     * @param careLevel
     * @param roomnumber
     * @param assets
     */
    public Patient(String firstName, String surname, LocalDate dateOfBirth, String careLevel, String roomnumber, String assets) {
        super(firstName, surname);
        this.dateOfBirth = dateOfBirth;
        this.careLevel = careLevel;
        this.roomnumber = roomnumber;
        this.assets = assets;
    }

    /**
     * constructs a patient from the given params.
     * @param pid
     * @param firstName
     * @param surname
     * @param dateOfBirth
     * @param careLevel
     * @param roomnumber
     * @param assets
     */
    public Patient(long pid, String firstName, String surname, LocalDate dateOfBirth, String careLevel, String roomnumber, String assets) {
        super(firstName, surname);
        this.pid = pid;
        this.dateOfBirth = dateOfBirth;
        this.careLevel = careLevel;
        this.roomnumber = roomnumber;
        this.assets = assets;
    }

    /**
     *
     * @return patient id
     */
    public long getPid() {
        return pid;
    }

    /**
     *
     * @return date of birth as a string
     */
    public String getDateOfBirth() {
        return dateOfBirth.toString();
    }

    /**
     * convert given param to a localDate and store as new <code>birthOfDate</code>
     * @param dateOfBirth as string in the following format: YYYY-MM-DD
     */
    public void setDateOfBirth(String dateOfBirth) {
        LocalDate birthday = DateConverter.convertStringToLocalDate(dateOfBirth);
        this.dateOfBirth = birthday;
    }

    /**
     *
     * @return careLevel
     */
    public String getCareLevel() {
        return careLevel;
    }

    /**
     *
     * @param careLevel new care level
     */
    public void setCareLevel(String careLevel) {
        this.careLevel = careLevel;
    }

    /**
     *
     * @return roomNumber as string
     */
    public String getRoomnumber() {
        return roomnumber;
    }

    /**
     *
     * @param roomnumber
     */
    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    /**
     *
     * @return assets as string
     */
    public String getAssets() {
        return assets;
    }

    /**
     *
     * @param assets
     */
    public void setAssets(String assets) {
        this.assets = assets;
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
     * @return string-representation of the patient
     */
    public String toString() {
        return "Patient" + "\nMNID: " + this.pid +
                "\nFirstname: " + this.getFirstName() +
                "\nSurname: " + this.getSurname() +
                "\nBirthday: " + this.dateOfBirth +
                "\nCarelevel: " + this.careLevel +
                "\nRoomnumber: " + this.roomnumber +
                "\nAssets: " + this.assets +
                "\n";
    }
}