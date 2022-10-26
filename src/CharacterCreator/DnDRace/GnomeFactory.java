package CharacterCreator.DnDRace;

import CharacterCreator.Stats;

public class GnomeFactory implements RaceAbstractFactory{
    @Override
    public CharacterRace create(String type) {
        return new Gnome(type, new Stats(0, 1, 0, 2, 0, 0));
    }
}
