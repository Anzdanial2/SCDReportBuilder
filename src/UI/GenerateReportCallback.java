package UI;

/**
 * Interface for handling the callback when the "Generate Report" action is triggered.
 * This interface defines a method that must be implemented by any class that wishes to
 * respond to the event of generating a report in the UI layer of the application.
 */
public interface GenerateReportCallback {
    /**
     * Method to be called when the "Generate Report" button is clicked.
     * Implementing classes should define the behavior that occurs upon this action.
     */
    void onGenerateReportClicked();
}
