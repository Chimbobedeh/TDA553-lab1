public class BinaryPlatform implements IPlatform {
    private boolean raised;

    public BinaryPlatform() {
        raised = true;
    }

    public void raise() {
        raised = true;
    }

    public void lower() {
        raised = false;
    }

    public boolean isRaised() {
        return raised;
    }
}
