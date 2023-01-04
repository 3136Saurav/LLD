// add Observer
// remove Observer
// notify Observer

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogPublisher {
    Map<Integer, List<LogObserver>> observerMap;

    public LogPublisher() {
        this.observerMap = new HashMap<>();
    }

    void addObserver(int level, LogObserver observer) {
        List<LogObserver> observerList = observerMap.getOrDefault(level, new ArrayList<>());
        observerList.add(observer);
        observerMap.put(level, observerList);
    }

    void notifyObservers(int level, String message) {
        for (Map.Entry<Integer, List<LogObserver>> entry : observerMap.entrySet()) {
            if (entry.getKey() == level) {
                List<LogObserver> logObserverList = entry.getValue();
                for (LogObserver observer : logObserverList) {
                    observer.log(message);
                }
            }
        }
    }
}
