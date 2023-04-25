package by.belstu.lab13.Command;

public class CommandResult {
    private String page;
    private boolean isRedirect;
    public CommandResult() { }
    public CommandResult(String page) { this.page = page; }
    public CommandResult(String page, boolean isRedirect) {
        this.page = page;
        this.isRedirect = isRedirect;
    }
    public String getPage() { return page; }
    public void setPage(String page) { this.page = page; }
    public boolean isRedirect() { return isRedirect; }

}
