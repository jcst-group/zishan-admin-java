package com.nongxin.terminal.plugin.vo;

/**
 * @author clover
 * @date 2019/11/14
 * @description
 */
public class Customer {
    private String host;
    private String db;

    public Customer() {
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "host='" + host + '\'' +
                ", db='" + db + '\'' +
                '}';
    }
}
