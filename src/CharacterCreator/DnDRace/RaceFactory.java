package CharacterCreator.DnDRace;

public class RaceFactory {

    public static CharacterRace getRace(RaceAbstractFactory factory, String type) {
        return factory.create(type);
    }
}
