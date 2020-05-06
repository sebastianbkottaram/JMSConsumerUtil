public class AuthConf {

    String IPAddress;
    String PortNo;
    String BrokerURL;
    String userName;
    String password;
    String topicName;



    @Override
    public String toString() {
        return "AuthConf{" +
                "IPAddress='" + IPAddress + '\'' +
                ", PortNo='" + PortNo + '\'' +
                ", BrokerURL='" + BrokerURL + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", topicName='" + topicName + '\'' +
                '}';
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public String getPortNo() {
        return PortNo;
    }

    public void setPortNo(String portNo) {
        PortNo = portNo;
    }

    public String getBrokerURL() {
        return BrokerURL;
    }

    public void setBrokerURL(String brokerURL) {
        BrokerURL = brokerURL;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}
