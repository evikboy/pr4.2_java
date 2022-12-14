public class MementoPatternDemo {
    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        Originator originator = new Originator();

        Character player = new Character("Eldridge", "Paladin");


        System.out.println("\n-----------------------------------" +
                "Saving states stage" +
                "-----------------------------------");

        Stats stats = Stats.generate();

        player.setAttributes(stats);
        player.printSheet();

        originator.setState(stats);
        careTaker.add(originator.saveStateToMemento());


        System.out.println("!!!Regenerate...");


        stats = Stats.generate();

        player.setAttributes(stats);
        player.printSheet();

        originator.setState(stats);
        careTaker.add(originator.saveStateToMemento());


        System.out.println("!!!Regenerate...");


        stats = Stats.generate();

        player.setAttributes(stats);
        player.printSheet();

        originator.setState(stats);
        careTaker.add(originator.saveStateToMemento());


        System.out.println("\n-----------------------------------" +
                "Loading state stage" +
                "-----------------------------------\n");

        originator.getStateFromMemento(careTaker.get(0).getState());
        stats = originator.getState();

        player.setAttributes(stats);
        player.printSheet();
    }
}