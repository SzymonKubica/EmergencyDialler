
public abstract class EmergencyDialler {
  protected PriorityQueue<Contact> queue;
  protected Location location;
  private Dialler dialler;

  public EmergencyDialler(Location location, Dialler dialler) {
    this.location = location;
    this.queue = new LinkedListPriorityQueue<>();
    this.dialler = dialler;
  }

  public Contact emergency() {
    Contact currentContact = null;
    boolean wasCallSuccessful = false;
    while (!wasCallSuccessful) {
      currentContact = queue.dequeue();
      for (Person person : currentContact.getPeople()) {
        wasCallSuccessful = wasCallSuccessful || dialler.call(person.getTelephoneNumber(),
                String.format("Emergency occurred at (%d, %d)", location.getX(), location.getY()));
      }
    }
    return currentContact;
  }

  public abstract void addToEmergencyContactList(Contact contact);

}
