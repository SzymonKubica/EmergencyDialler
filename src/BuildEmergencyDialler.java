public class BuildEmergencyDialler {
  public static void main(String[] args) {
    EmergencyDialler dialler = new AvgEmergencyDialler(new Location(2,3), new Dialler());

    Contact contact1 = new Person("Jensen", 4, 2, -9);
    Contact person2 = new Person("Jamil", 3, 2, 32);
    Contact person3 = new Person("Ji", 5, -4, -9);
    Contact person4 = new Person("Jane", 2, -4, 1);
    Contact person5 = new Person("Joe", 1, 2, 3);

    Group contact2 = new Group("contact2");
    contact2.add(person2);

    Group contact2Inner = new Group("contact2Inner");
    contact2Inner.add(person3);
    contact2Inner.add(person4);

    contact2.add(contact2Inner);

    Group contact3 = new Group("contact3");
    contact3.add(person5);

    dialler.addToEmergencyContactList(contact1);
    dialler.addToEmergencyContactList(contact2);
    dialler.addToEmergencyContactList(contact3);

    dialler.emergency();
  }
}
