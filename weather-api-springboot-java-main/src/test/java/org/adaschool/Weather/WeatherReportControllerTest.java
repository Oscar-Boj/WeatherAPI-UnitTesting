package org.adaschool.Weather;

import org.adaschool.Weather.controller.WeatherReportController;
import org.adaschool.Weather.data.WeatherReport;
import org.adaschool.Weather.service.WeatherReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class WeatherReportControllerTest {

    @Mock
    private WeatherReportService weatherReportService;

    @InjectMocks
    private WeatherReportController weatherReportController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetWeatherReport() {
        double latitude = 37.8267;
        double longitude = -122.4233;
        WeatherReport mockReport = new WeatherReport();
        mockReport.setTemperature(20.0);
        mockReport.setHumidity(50);

        when(weatherReportService.getWeatherReport(latitude, longitude)).thenReturn(mockReport);

        WeatherReport result = weatherReportController.getWeatherReport(latitude, longitude);

        assertEquals(20.0, result.getTemperature());
        assertEquals(50, result.getHumidity());
    }
}
