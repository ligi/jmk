package org.ligi.java.io;

public interface CommunicationAdapterInterface {
    public void flush();

    public void write(byte[] data, int offset, int length);

    public void write(byte[] data);

    public void write(char data);

    public void write(int data);

    public void connect();

    public void disconnect();

    public int available();

    public int read(byte[] data, int offset, int length);

    public int read();

    public String getURL();

    public String getName();
}
