#include <vector>

using std::vector;

class MyHashSet {
public:
    MyHashSet(): store() {

    }

    void add(int key) {
        if (store.empty()) {
            store.push_back(key);
        } else {
            for (int x: store) {
                if (x == key) {
                    return;
                }
            }
            store.push_back(key);
        }
    }

    void remove(int key) {
        if (!(store.empty())) {
            auto it = store.begin();

            for (; it !=store.end(); it++) {
                if ((*it) == key) {
                    store.erase(it);
                    return;
                }
            }
        }
    }

    bool contains(int key) const {
        for (int x: store) {
            if (x == key) {
                return true;
            }
        }
        return false;
    }
private:
    vector<int> store;
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
