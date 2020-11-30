package stringbasic.pets;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vet {

    private List<Pet> petList = new ArrayList<>();

    private boolean areEquals(Pet pet) {
        for (Pet p: petList) {
            if (p.getRegistrationNumber().equals(pet.getRegistrationNumber())) {
                return true;
            }
        }
        return false;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void addPet(Pet pet) {
        if (!areEquals(pet)) {
            petList.add(pet);
        }
    }

    public static void main(String[] args) {
        Pet pet = new Pet("Manci", LocalDate.of(2020,03,01), Gender.MALE, "123456");
        Vet vet = new Vet();
        vet.addPet(pet);
        pet = new Pet("Bogi", LocalDate.of(2018,10,21), Gender.FEMALE, "123456");
        vet.addPet(pet);
        pet = new Pet("Füles", LocalDate.of(2019,07,11), Gender.MALE, "223456");
        vet.addPet(pet);
        for (Pet p: vet.getPetList()) {
            System.out.println(p.toString());
        }
    }
}
