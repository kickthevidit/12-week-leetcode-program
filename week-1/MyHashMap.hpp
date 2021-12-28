#ifndef MYHASHMAP_HPP
#define MYHASHMAP_HPP

using std::vector;
using std::pair;

#include <iostream>
#include <vector>
#include <utility>

class MyHashMap {
public:
    MyHashMap(); /*MyHashMap() initializes the object with an empty map.*/

    void put(int key, int value);
    /*void put(int key, int value) inserts a (key, value) pair into the HashMap. 
    If the key already exists in the map, update the corresponding value.*/

    void print_structure();

    int get(int key) const;
    /*int get(int key) returns the value to which the specified key is mapped, 
    or -1 if this map contains no mapping for the key*/

    void remove(int key);
    /*void remove(key) removes the key and its corresponding value if the map 
    contains the mapping for the key*/
private:
    vector<vector<pair<int,int>>> store;

    void add_value(pair<int,int> key_val, int& index);

    //int get_index(int key) const; never implemented but using this is better
    // coding practice

};

#endif