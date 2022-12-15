interface IPlatform {
    void raise();
    void lower();
    IPlatform clone();
    boolean isActive();
}
