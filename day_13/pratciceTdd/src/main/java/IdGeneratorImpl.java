public class IdGeneratorImpl implements IdGenerator {
    private static IdGenerator instance;
    private int id = 0;

    private IdGeneratorImpl() {}

    @Override
    public IdGenerator getInstance() {
        if(IdGeneratorImpl.instance == null) {
            IdGeneratorImpl.instance = new IdGeneratorImpl();
        }
        return IdGeneratorImpl.instance;
    }

    @Override
    public int generateId() {
        return id++;
    }
}
