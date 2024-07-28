package org.adaschool.Weather;

import org.adaschool.Weather.data.WeatherApiResponse;
import org.adaschool.Weather.data.WeatherReport;
import org.adaschool.Weather.service.WeatherReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class WeatherReportServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private WeatherReportService weatherReportService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetWeatherReport() {
        double latitude = 37.8267;
        double longitude = -122.4233;
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=37.8267&lon=-122.4233&appid=4644368cf6ffdc1c0bd47b98689d119e";

        WeatherApiResponse mockResponse = new WeatherApiResponse();
        WeatherApiResponse.Main main = new WeatherApiResponse.Main();
        main.setTemperature(0.0);
        main.setHumidity(85.0);
        mockResponse.setMain(main);

        when(restTemplate.getForObject(url, WeatherApiResponse.class)).thenReturn(mockResponse);

        WeatherReport result = weatherReportService.getWeatherReport(latitude, longitude);

        assertEquals(0.0, result.getTemperature());
        assertEquals(85.0, result.getHumidity());
    }
}
