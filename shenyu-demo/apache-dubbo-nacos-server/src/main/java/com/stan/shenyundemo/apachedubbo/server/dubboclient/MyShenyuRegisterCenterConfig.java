package com.stan.shenyundemo.apachedubbo.server.dubboclient;

import java.util.Properties;

/**
 * @Author: zengxp
 * @Date: 2021/12/24 11:28
 * @Desc:
 */
public class MyShenyuRegisterCenterConfig {

    private String registerType;

    private String serverLists;

    private Properties props = new Properties();

    public MyShenyuRegisterCenterConfig() {
    }

    public MyShenyuRegisterCenterConfig(final String registerType, final String serverLists, final Properties props) {
        this.registerType = registerType;
        this.serverLists = serverLists;
        this.props = props;
    }

    /**
     * getRegisterType.
     *
     * @return String
     */
    public String getRegisterType() {
        return registerType;
    }

    /**
     * setRegisterType.
     *
     * @param registerType registerType
     */
    public void setRegisterType(final String registerType) {
        this.registerType = registerType;
    }

    /**
     * getServerLists.
     *
     * @return String
     */
    public String getServerLists() {
        return serverLists;
    }

    /**
     * setServerLists.
     *
     * @param serverLists serverLists
     */
    public void setServerLists(final String serverLists) {
        this.serverLists = serverLists;
    }

    /**
     * getProps.
     *
     * @return String
     */
    public Properties getProps() {
        return props;
    }

    /**
     * setProps.
     *
     * @param props props
     */
    public void setProps(final Properties props) {
        this.props = props;
    }
}
