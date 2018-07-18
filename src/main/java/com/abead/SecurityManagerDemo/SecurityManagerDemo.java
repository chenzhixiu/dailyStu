package com.abead.SecurityManagerDemo;

public class SecurityManagerDemo {
    public static void main(String[] args) {
        RuntimePermission shutdownPerm =
                new RuntimePermission("modifyThread");
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkPermission(shutdownPerm);
        }
    }
}
