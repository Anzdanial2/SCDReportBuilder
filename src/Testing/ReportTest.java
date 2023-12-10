package Testing;

import BL.Components.Component;
import BL.Reports.Exporter;
import BL.Reports.Report;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReportTest {

    @Test
    void testReportInitialization() {
        String title = "Test Report";
        Report report = new Report(title);
        assertEquals(title, report.getTitle());
        assertTrue(report.getTimeStamp().isBefore(LocalDateTime.now().plusMinutes(1)));
        assertTrue(report.getTimeStamp().isAfter(LocalDateTime.now().minusMinutes(1)));
    }

    @Test
    void testAddComponent() {
        Report report = new Report("Test Report");
        Component mockComponent = mock(Component.class); // Mock object
        report.add(mockComponent);
        assertEquals(1, report.getComponentList().size());
    }

    @Test
    void testDisplay() {
        Report report = new Report("Test Report");
        Component mockComponent = mock(Component.class);
        report.add(mockComponent);
        report.display();
        verify(mockComponent, times(1)).display();
    }

    @Test
    void testLoad() {
        Report report = new Report("Test Report");
        Component mockComponent = mock(Component.class);
        report.add(mockComponent);
        report.load();
        verify(mockComponent, times(1)).setData();
    }

    @Test
    void testExport() {
        Report report = new Report("Test Report");
        Exporter mockExporter = mock(Exporter.class);
        report.export(mockExporter);
        verify(mockExporter, times(1)).export();
    }
}
