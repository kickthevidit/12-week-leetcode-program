#include "MyHashMap.hpp"

using std::vector;
using std::pair;


MyHashMap::MyHashMap(): store(25){}

void MyHashMap::print_structure() {
    for (int i = 0; i < store.size(); i++) {
        if (!(store[i].empty())) {
            std::cout << "i: " << i << "|";
            for (int j = 0; j < store[i].size(); j++) {
                std::cout << "(" << store[i][j].first << "," << store[i][j].second << "),";
            }
            std::cout << '\n';
        }
    }
}

void MyHashMap::put(int key, int value) {
    const pair<int, int> key_val = {key, value};
    
    ////std::cout << "Key,Value: " << key_val.first << "," << key_val.second << '\n';

    int index = key%25;
    
    ////std::cout << index << std::endl;

    if (store[index].empty()) {
        store[index].push_back(key_val);
    } else {
        add_value(key_val, index);
    }
}

void MyHashMap::add_value(pair<int, int> key_val, int& index) {
    if (store[index].empty()) {
        throw std::runtime_error("The size of this vector should be non-zero");
    }

    auto it = store[index].begin();

    for (;it != store[index].end(); it++) {
        ////std::cout << "Current Key: " << (*it).first << '\n';
        if (key_val.first == (*it).first) {
            (*it).second = key_val.second; // update the value
            return;
        } else if (key_val.first < (*it).first) {
            store[index].insert(it, key_val);
            return;
        }
    }
    //bool b = (it == store.at(index).end());
    //////std::cout << b << '\n';
    store[index].insert(it, key_val);
}

int MyHashMap::get(int key) const {
    const int index = key%25;

    if (store[index].empty()) {
        return -1;
    }

    for (int i = 0; i < store[index].size(); i++) {
        if (store[index][i].first == key) {
            return store[index][i].second;
        }
    }
    // key not in store
    return -1;
}

void MyHashMap::remove(int key) {
    const int index = key%25;

    if (store[index].empty()) {
        return;
    }

    auto it = store[index].begin();
    for (; it != store[index].end(); it++) {
        if ((*it).first == key) {
            store[index].erase(it);
            return;
        }
    }
}