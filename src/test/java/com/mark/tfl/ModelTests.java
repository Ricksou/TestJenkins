package com.mark.tfl;

import com.mark.tfl.Models.TFLLineStatusObject;
import com.mark.tfl.Models.TFLMongoObject;
import com.mark.tfl.Models.TFLMongoRepo;
import com.mark.tfl.Services.TFLStatusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ModelTests {

    private TFLLineStatusObject lineStatus = new TFLLineStatusObject("testline", "teststatus");

    private TFLMongoObject mongoTFLObject = new TFLMongoObject("testtime", Arrays.asList(lineStatus));

    @Mock
    private TFLMongoRepo tflRepository;

    @InjectMocks
    private TFLStatusService tflStatusService;

    @Test
    public void newLineStatusTest() {
        String expectedLine = "sampleLine";
        String expectedStatus = "sampleStatus";
        TFLLineStatusObject lineStatus = new TFLLineStatusObject(expectedLine, expectedStatus);
        String linename = lineStatus.getLineName();
        String linestatus = lineStatus.getLineStatus();
        assertEquals(expectedLine, linename);
        assertEquals(expectedStatus, linestatus);
    }

//    @Test
//    public void newTFLResponseTest() {
//        Mockito.when(tflRepository.save(mongoTFLObject)).thenReturn(mongoTFLObject);
//        tflStatusService.scheduleAPICall();
//        Assert.assertNotSame("Line statuses assertion", null, tflStatusService.getLineStatuses());
//        Assert.assertNotSame("Line issues assertion", null, tflStatusService.getLineIssues());
//    }

    @Test
    public void nightTubeTest(){
        TFLLineStatusObject lineStatus = new TFLLineStatusObject("Victoria", "testStatus");
        boolean actual = lineStatus.isNightTube();
        assertEquals(true, actual);

        lineStatus = new TFLLineStatusObject("Metropolitan", "testStatus");
        boolean actual1 = lineStatus.isNightTube();
        assertEquals(false, actual1);
    }
}