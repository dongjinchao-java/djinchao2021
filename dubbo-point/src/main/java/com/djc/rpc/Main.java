package com.djc.rpc;

import com.djc.rpc.dubbo.DubboConsummer;
import com.djc.rpc.dubbo.DubboProvider;
import org.djc.cross.WorldService;

public class Main {

    static String url = "dubbo://127.0.0.1:20880/org.djc.cross.WorldService";

    public static void main(String[] args) throws Exception {
        DubboProvider.getInstance().initProvider();
        DubboConsummer.getInstance().initComsummer();
        for (int i = 0; i < 2; i++) {
            WorldService service = DubboConsummer.getInstance().getWorldService(url);
            String str = service.testDubbo();
            System.out.printf("resulttttttttttttttttttttttttttttttt=============== " + str);
            Thread.sleep(50000);
        }
        System.in.read();
    }
}
