package th.engine.game;

/**
 * Данные объекта
 */
public class ObjectData {

    private String mName;
    private Object mObject;
    private int mPriority;

    public ObjectData(String name, Object object, int priority) {
        mName = name;
        mObject = object;
        mPriority = priority;
    }

    public String getName() {
        return mName;
    }

    public Object getObject() {
        return mObject;
    }

    public int getPriority() {
        return mPriority;
    }
}

