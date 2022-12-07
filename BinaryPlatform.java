public class BinaryPlatform implements IPlatform {
    private boolean raised;

    public BinaryPlatform() {
        raised = true;
    }

    public BinaryPlatform(boolean raised) {
        this.raised = raised;
    }

    public IPlatform clone() {
        return new BinaryPlatform(raised);
    }

    public void raise() {
        raised = true;
    }

    public void lower() {
        raised = false;
    }

    public boolean isActive() {
        return !raised;
    }
}
