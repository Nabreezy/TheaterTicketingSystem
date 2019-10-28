package sample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket {
    private Lock _mutex;
    private int _number;

    public Ticket(int number) {
        this._number = number;
        this._mutex = new ReentrantLock(true);
    }

    public Lock get_mutex() {
        return _mutex;
    }

    public int get_number() {
        return _number;
    }

    public void set_number(int _number) {
        this._number = _number;
    }
}
