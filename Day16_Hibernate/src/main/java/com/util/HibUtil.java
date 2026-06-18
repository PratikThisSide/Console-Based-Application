package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibUtil {

    private static SessionFactory sf;

    static {
        sf = new Configuration()
                .configure()
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sf;
    }
}