package com.lagrange.colocation;

public interface IColocationService {
    FlatShare getFlatShareById(String id);
    void shuffleCommuneTaskForEveryFlatshare();
}
