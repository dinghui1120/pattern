package singleton.lazy;

/**
 * double check
 */
public class LazySingletonV3 {

    private LazySingletonV3(){}

    private static LazySingletonV3 instance = null;

    public static LazySingletonV3 getInstance() {
        //检查是否要阻塞
        if (null == instance) {
            synchronized (LazySingletonV3.class) {
                //检查是否要创建实例
                //两个线程有可能同时进入这里
                if (null == instance) {
                    instance = new LazySingletonV3();
                }
            }
        }
        return instance;
    }
}
