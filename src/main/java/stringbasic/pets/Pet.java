package stringbasic.pets;

import java.time.LocalDate;

public class Pet {

    private String name;

    private LocalDate dateOfBirth;

    private Gender gender;

    private String registrationNumber;

    public Pet(String name, LocalDate dateOfBirth, Gender gender, String registrationNumber) {
        if (registrationNumber.length() != 6) {
            throw new IllegalArgumentException("6 számjegynek kell lennie!");
        }
        int regNumber = Integer.parseInt(registrationNumber);
        this.name = name;
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Hibás születési adat!");
        }
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public static void main(String[] args) {
        Pet pet = new Pet("Manci", LocalDate.of(2020,3,1), Gender.MALE, "123456");
        System.out.println(pet.getName()+pet.dateOfBirth+pet.gender+pet.registrationNumber);
    }
}
