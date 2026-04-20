package Storage;

public class StorageFactory {
    private static StorageFactory instance;

    private StorageFactory() {}

    public static StorageFactory getInstance() {
        if (instance == null) {
            instance = new StorageFactory();
        }
        return instance;
    }

    public Storage create() {
        return new Storage();
    }
}