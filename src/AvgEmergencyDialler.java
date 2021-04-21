public class AvgEmergencyDialler extends EmergencyDialler {
  public AvgEmergencyDialler(Location location, Dialler dialler) {
    super(location, dialler);
  }

  @Override
  public void addToEmergencyContactList(Contact contact) {
    Double priority = calculatePriority(contact);
    super.queue.add(priority, contact);

  }

  private double calculatePriority(Contact contact) {
    Double priority = contact.getPeople().stream()
            .mapToDouble(
                    person -> person.getAddress().distanceTo(super.location)
            ).average().getAsDouble();
    return priority;
  }
}
