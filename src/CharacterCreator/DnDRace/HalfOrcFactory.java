package CharacterCreator.DnDRace;

import CharacterCreator.Stats;

public class HalfOrcFactory implements RaceAbstractFactory{
    @Override
    public CharacterRace create(String type) {
        return new HalfOrc(type, new Stats(2, 0, 1, 0, 0, 0));
    }
}
