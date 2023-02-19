
public class AnimalTest {
    public static void main(String[] args) {
        //The two tests are called.
        animalInfo();
        animalEquality();
    }

    private static void animalInfo() {

        System.out.println("-----Test 1: Animal Information-----");

        //An array of animals of size 4 is declared
        Animal[] animals = new Animal[4];

        //Each array element and corresponding names are declared
        animals[0] = new Canary("Travis");
        animals[1] = new Ostrich("Tariq");
        animals[2] = new Shark("DeAndre");
        animals[3] = new Trout("Bishop");

        //A for loop is used to parse each animal in the array as it loops
        for (Animal animal : animals) {
            System.out.println();
            //The animals corresponding toString() method is called
            System.out.print(animal);
            //Also each animal is called to move and eat.
            animal.move(500);
            animal.eat();
            //The sing method will also be called if the object in the array is a bird
            if (animal instanceof Bird ){
                ((Bird) animal).sing();
            }
            //Or if it's a shark, it will be called upon to bite.
            else if (animal instanceof Shark ){
                ((Shark) animal).bite();
            }
        }
    }

    private static void animalEquality(){
        System.out.println("\n----Test 2: Animal Equality----");
        //Animal array with 10 animals.
        Animal[] animals = new Animal[10];
        //Canaries
        animals[0] = new Canary("Tom");
        animals[1] = new Canary("Tom");
        //Ostriches
        animals[2] = new Ostrich("Red");
        animals[3] = new Ostrich("John");
        //Trout
        animals[4] = new Trout("Lee");
        animals[5] = new Trout("Greg");
        animals[6] = new Trout("Lee");
        //Sharks
        animals[7] = new Shark("Joe");
        animals[8] = new Shark("Joe");
        animals[9] = new Shark("Will");

        //Running Equality test between different animals
        //If animals are of the same type (AND SAME NAME) they are considered equal.
        System.out.println("\n\tCanary equals Canary (Same Name): "+animals[0].equals(animals[1]));
        System.out.println("\n\tCanary equals Shark: "+animals[0].equals(animals[7]));
        System.out.println("\n\tOstrich equals Trout: "+animals[2].equals(animals[4]));
        System.out.println("\n\tTrout equals Trout (Different Name): "+animals[4].equals(animals[5]));
        System.out.println("\n\tTrout equals Trout (Same Name): "+animals[4].equals(animals[6]));
        System.out.println("\n\tShark equals Ostrich: "+animals[7].equals(animals[3]));
        System.out.println("\n\tTrout equals Canary: "+animals[5].equals(animals[1]));
        System.out.println("\n\tOstrich equals Ostrich (Different Name): "+animals[2].equals(animals[3]));
        System.out.println("\n\tShark equals Shark (Same Name): "+animals[7].equals(animals[8]));
        System.out.println("\n\tShark equals Shark (Different Name): "+animals[7].equals(animals[9]));
    }
}
