package com.djc.rpc.serviceImpl;

import org.djc.cross.WorldService;

public class WorldServiceImpl implements WorldService {

    @Override
    public String testDubbo() {
        return "123";
    }
}
